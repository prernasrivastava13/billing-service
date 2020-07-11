package com.test.billingservice.service;

import com.test.billingservice.entity.AccountApplicationMapping;

public interface AccountApplicationMappingService {

  public AccountApplicationMapping createAccountApplicationMapping(
      AccountApplicationMapping accountApplicationMapping);

  public AccountApplicationMapping getAccountApplicationMappingByAccountIdAndApplicationId(
      int accountId, int applicationId);

  public AccountApplicationMapping updateAccountApplicationMapping(
      AccountApplicationMapping accountApplicationMapping);
}
