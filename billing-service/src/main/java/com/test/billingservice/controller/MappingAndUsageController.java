package com.test.billingservice.controller;

import com.test.billingservice.dao.AccountApplicationUsageLimitsRepository;
import com.test.billingservice.entity.AccountApplicationUsageLimits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@Slf4j
@RequestMapping("/billingService/mappingandusage")
@RestController
public class MappingAndUsageController {

  @Resource private AccountApplicationUsageLimitsRepository accountApplicationUsageLimitsRepository;

  @GetMapping("/getjoinresultsbyusage")
  public Set<AccountApplicationUsageLimits> getJoinResultsByUsage() {
    return accountApplicationUsageLimitsRepository.findAccountApplicationUsageByJoin();
  }
}
