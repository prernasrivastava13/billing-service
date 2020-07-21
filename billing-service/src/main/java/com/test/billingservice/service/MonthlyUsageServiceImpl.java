package com.test.billingservice.service;

import com.test.billingservice.dao.MonthlyUsageRepository;
import com.test.billingservice.entity.AccountApplicationUsageLimits;
import com.test.billingservice.entity.Invoices;
import com.test.billingservice.entity.MonthlyUsage;
import com.test.billingservice.entity.Plans;
import com.test.billingservice.predicate.MonthlyUsagePredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class MonthlyUsageServiceImpl implements MonthlyUsageService {

  //    String currentMonth = LocalDateTime.now().getMonth().name();
  @Resource private MonthlyUsageRepository monthlyUsageRepository;

  @Resource private InvoiceService invoiceService;

  @Resource private AccountApplicationUsageLimitsService accountApplicationUsageLimitsService;

  @Resource private MonthlyUsageService monthlyUsageService;

  @Resource private PlansService plansService;

  @Override
  public MonthlyUsage createMonthlyUsage(String month) {

    String currentMonth;
    //    if (month.isEmpty())
    currentMonth = LocalDateTime.now().getMonth().name();
    //    else currentMonth = month;

    Set<AccountApplicationUsageLimits> accountApplicationUsageLimitSet =
        accountApplicationUsageLimitsService.findAccountApplicationUsageByJoinAndMonth(
            currentMonth);

    for (AccountApplicationUsageLimits accountApplicationUsageLimits :
        accountApplicationUsageLimitSet) {
      MonthlyUsage monthlyUsage =
          monthlyUsageService.findByAccountIdAndMonth(
              accountApplicationUsageLimits.getAccountApplicationMapping().getAccountId(),
              accountApplicationUsageLimits.getMonth());
      if (monthlyUsage != null) {
        monthlyUsage.setCreditsConsumed(
            monthlyUsage.getCreditsConsumed() + accountApplicationUsageLimits.getCreditUsed());
      } else {
        monthlyUsage = new MonthlyUsage();
        monthlyUsage.setMonth(currentMonth);
        monthlyUsage.setAccountId(
            accountApplicationUsageLimits.getAccountApplicationMapping().getAccountId());
        monthlyUsage.setCreditsConsumed(accountApplicationUsageLimits.getCreditUsed());
      }
      monthlyUsageService.saveMonthlyUsage(monthlyUsage);
      Optional<Plans> plans =
          plansService.findPlanByCredits(
              monthlyUsage.getCreditsConsumed(),
              accountApplicationUsageLimits.getAccountApplicationMapping().getApplicationId());

      if (plans.isPresent()) {

        log.info("Plans: " + plans);
        Invoices invoices =
            invoiceService.findByAccountIdAndMonth(
                monthlyUsage.getAccountId(), monthlyUsage.getMonth());
        if (invoices != null) {
          invoices.setPrice(
              invoices.getPrice()
                  + plans.get().getFixPrice()
                  + plans.get().getPerCreditFileSize() * monthlyUsage.getCreditsConsumed());
        } else {
          invoices = new Invoices();
          invoices.setAccountId(monthlyUsage.getAccountId());
          invoices.setMonth(monthlyUsage.getMonth());
          invoices.setPrice(
              plans.get().getFixPrice()
                  + plans.get().getPerCreditFileSize() * monthlyUsage.getCreditsConsumed());
        }
        invoiceService.saveInvoiceService(invoices);
      } else {
        log.info(
            "No plan found for credits: "
                + monthlyUsage.getCreditsConsumed()
                + " and applicationId: "
                + accountApplicationUsageLimits.getAccountApplicationMapping().getApplicationId());
        throw new RuntimeException("Plan not found");
      }
    }
    log.info("Error while creating monthly usage");
    return null;
  }

  @Override
  public MonthlyUsage findByAccountIdAndMonth(int accountId, String month) {
    Optional<MonthlyUsage> monthlyUsage =
        monthlyUsageRepository.findOne(
            MonthlyUsagePredicate.getMonthlyUsageByAccountIdAndMonth(accountId, month));
    if (monthlyUsage.isPresent()) {
      return monthlyUsage.get();
    }
    log.info("Error find monthly usage with account id: " + accountId + " and month: " + month);
    return null;
  }

  public Invoices createInvoiceForMonthlyUsage(MonthlyUsage monthlyUsage, int price) {
    Invoices invoices = new Invoices();
    invoices.setAccountId(monthlyUsage.getAccountId());
    invoices.setMonth(monthlyUsage.getMonth());
    invoices.setPrice(price);
    Invoices createdInvoices = invoiceService.saveInvoiceService(invoices);
    return createdInvoices;
  }

  public MonthlyUsage saveMonthlyUsage(MonthlyUsage monthlyUsage) {
    return monthlyUsageRepository.save(monthlyUsage);
  }
}
