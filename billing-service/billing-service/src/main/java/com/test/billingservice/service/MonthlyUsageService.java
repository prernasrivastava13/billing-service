package com.test.billingservice.service;

import com.test.billingservice.entity.MonthlyUsage;

public interface MonthlyUsageService {

  public MonthlyUsage createMonthlyUsage(MonthlyUsage monthlyUsage);

  public MonthlyUsage updateMonthlyUsage(MonthlyUsage monthlyUsage);
}
