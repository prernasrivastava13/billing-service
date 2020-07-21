package com.test.billingservice.service;

public interface AccountUsageService {

  public boolean getAccountUsageLimit(int accountId, int applicationId);
}
