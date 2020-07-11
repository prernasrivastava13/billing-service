package com.test.billingservice.service;

import com.test.billingservice.dao.MonthlyUsageRepository;
import com.test.billingservice.entity.MonthlyUsage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MonthlyUsageServiceImpl implements MonthlyUsageService {

  @Resource private MonthlyUsageRepository monthlyUsageRepository;

  @Override
  public MonthlyUsage createMonthlyUsage(MonthlyUsage monthlyUsage) {
    return monthlyUsageRepository.save(monthlyUsage);
  }

  @Override
  public MonthlyUsage updateMonthlyUsage(MonthlyUsage monthlyUsage) {
    return monthlyUsageRepository.save(monthlyUsage);
  }
}
