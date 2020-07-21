package com.test.billingservice.service;

import com.test.billingservice.entity.AccountApplicationUsageLimits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Set;

@Slf4j
@Service
public class AccountUsageServiceImpl implements AccountUsageService {

  @Resource private AccountApplicationUsageLimitsService accountApplicationUsageLimitsService;

  @Override
  public boolean getAccountUsageLimit(int accountId, int applicationId) {
    String currentMonth = LocalDateTime.now().getMonth().name();
    Set<AccountApplicationUsageLimits> accountApplicationUsageLimitsSet =
        accountApplicationUsageLimitsService.findAccountApplicationUsageByJoin();

    for (AccountApplicationUsageLimits accountApplicationUsageLimits :
        accountApplicationUsageLimitsSet) {
      if ((accountApplicationUsageLimits.getAccountApplicationMapping().getAccountId() == accountId
              && accountApplicationUsageLimits.getAccountApplicationMapping().getApplicationId()
                  == applicationId)
          && accountApplicationUsageLimits.getMonth().equals(currentMonth)) {
        if (accountApplicationUsageLimits.getCreditUsed()
            < accountApplicationUsageLimits.getAccountApplicationMapping().getCreditLimit()) {
          return true;
        }
      }
    }
    return false;
  }
}
