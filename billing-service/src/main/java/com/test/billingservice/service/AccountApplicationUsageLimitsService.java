package com.test.billingservice.service;

import com.test.billingservice.entity.AccountApplicationUsageLimits;

import java.util.Set;

public interface AccountApplicationUsageLimitsService {

//  public AccountApplicationUsageLimits createAccountApplicationUsageLimits(
//      AccountApplicationUsageLimits accountApplicationUsageLimits);

//  public AccountApplicationUsageLimits updateAccountApplicationUsageLimits(
//      AccountApplicationUsageLimits accountApplicationUsageLimits);

//  public AccountApplicationUsageLimits getAccountApplicationUsageLimitsByMappingId(
//      int accountApplicationId);

  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoin();

  public AccountApplicationUsageLimits findByAccountApplicationMapping_IdAndMonth(
      int accountApplicationMappingId, String month);

  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoinAndMonth(String month);
}
