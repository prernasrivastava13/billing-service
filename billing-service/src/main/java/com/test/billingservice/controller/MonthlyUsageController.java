package com.test.billingservice.controller;

import com.test.billingservice.service.MonthlyUsageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/billingService/monthlyusage")
public class MonthlyUsageController {

  @Resource private MonthlyUsageService monthlyUsageService;

  @PostMapping("/create/{month}")
  public ResponseEntity createMonthlyUsage(@PathVariable String month) {
    //  @PostMapping("/create")
    //  public void createMonthlyUsage() {
    monthlyUsageService.createMonthlyUsage(month);
    return ResponseEntity.ok().build();
  }
}
