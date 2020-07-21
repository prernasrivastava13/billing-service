package com.test.billingservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class ScheduledMonthlyTasks {

  @Resource private MonthlyUsageService monthlyUsageService;

  @Scheduled(cron = "0 0 9 25 * ?")
  public void monthlyUsageCron() {
    monthlyUsageService.createMonthlyUsage(null);
  }
}
