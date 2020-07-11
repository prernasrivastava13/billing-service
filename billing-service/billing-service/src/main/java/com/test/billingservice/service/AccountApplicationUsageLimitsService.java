package com.test.billingservice.service;

import com.test.billingservice.entity.AccountApplicationUsageLimits;

public interface AccountApplicationUsageLimitsService {

  public AccountApplicationUsageLimits createAccountApplicationUsageLimits(
      AccountApplicationUsageLimits accountApplicationUsageLimits);

  public AccountApplicationUsageLimits updateAccountApplicationUsageLimits(
      AccountApplicationUsageLimits accountApplicationUsageLimits);

  public AccountApplicationUsageLimits getAccountApplicationUsageLimitsByMappingId(int accountApplicationId);
}
