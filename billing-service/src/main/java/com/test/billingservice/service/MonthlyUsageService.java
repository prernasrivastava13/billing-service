package com.test.billingservice.service;

import com.test.billingservice.entity.MonthlyUsage;

public interface MonthlyUsageService {

  public MonthlyUsage createMonthlyUsage(String month);

  public MonthlyUsage findByAccountIdAndMonth(int accountId, String month);

  public MonthlyUsage saveMonthlyUsage(MonthlyUsage monthlyUsage);
}
