package com.test.billingservice.controller;

import com.test.billingservice.service.AccountApplicationUsageLimitsService;
import com.test.billingservice.service.AccountUsageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/billingService/accountUsageLimits")
public class AccountUsageController {

  @Resource private AccountApplicationUsageLimitsService accountApplicationUsageLimitsService;

  @Resource private AccountUsageService accountUsageService;

  @GetMapping("/check/{accountId}/{applicationId}")
  public ResponseEntity<Boolean> getAccountUsageLimits(
      @PathVariable int accountId, @PathVariable int applicationId) {
    boolean status = accountUsageService.getAccountUsageLimit(accountId, applicationId);
    return ResponseEntity.ok(status);
  }
}
