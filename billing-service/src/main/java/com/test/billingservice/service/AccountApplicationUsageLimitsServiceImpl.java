package com.test.billingservice.service;

import com.test.billingservice.dao.AccountApplicationUsageLimitsRepository;
import com.test.billingservice.entity.AccountApplicationUsageLimits;
import com.test.billingservice.predicate.AccountApplicationUsageLimitsPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AccountApplicationUsageLimitsServiceImpl
    implements AccountApplicationUsageLimitsService {

  @Resource private AccountApplicationUsageLimitsRepository accountApplicationUsageLimitsRepository;

  //  @Override
  //  public AccountApplicationUsageLimits createAccountApplicationUsageLimits(
  //      AccountApplicationUsageLimits accountApplicationUsageLimits) {
  //    return accountApplicationUsageLimitsRepository.save(accountApplicationUsageLimits);
  //  }
  //
  //  @Override
  //  public AccountApplicationUsageLimits updateAccountApplicationUsageLimits(
  //      AccountApplicationUsageLimits accountApplicationUsageLimits) {
  //    return null;
  //  }

  //  @Override
  //  public AccountApplicationUsageLimits getAccountApplicationUsageLimitsByMappingId(
  //      int accountApplicationId) {
  //    AccountApplicationUsageLimits accountApplicationUsageLimits =
  //        accountApplicationUsageLimitsRepository
  //
  // .getAccountApplicationUsageLimitsByAccountApplicationMapping_Id(accountApplicationId);
  //    if (accountApplicationUsageLimits != null) return accountApplicationUsageLimits;
  //    return new AccountApplicationUsageLimits();
  //  }

  @Override
  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoin() {
    Set<AccountApplicationUsageLimits> accountApplicationUsageLimits =
        accountApplicationUsageLimitsRepository.findAccountApplicationUsageByJoin();
    return accountApplicationUsageLimits;
  }

  @Override
  public AccountApplicationUsageLimits findByAccountApplicationMapping_IdAndMonth(
      int accountApplicationMappingId, String month) {
    Optional<AccountApplicationUsageLimits> accountApplicationUsageLimits =
        accountApplicationUsageLimitsRepository.findOne(
            AccountApplicationUsageLimitsPredicate
                .getAccountApplicationUsageByAccountAppMappingIdAndMonth(
                    accountApplicationMappingId, month));
    if (accountApplicationUsageLimits.isPresent()) {
      return accountApplicationUsageLimits.get();
    }
    log.info("Error finding Account application mapping!!");
    return null;
  }

  @Override
  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoinAndMonth(
      String month) {
    return accountApplicationUsageLimitsRepository.findAccountApplicationUsageByJoinAndMonth(month);
  }
}
