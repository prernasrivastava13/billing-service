package com.test.billingservice.service;

import com.test.billingservice.dao.AccountApplicationUsageLimitsRepository;
import com.test.billingservice.entity.AccountApplicationUsageLimits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountApplicationUsageLimitsServiceImpl
    implements AccountApplicationUsageLimitsService {

  @Resource private AccountApplicationUsageLimitsRepository accountApplicationUsageLimitsRepository;

  @Override
  public AccountApplicationUsageLimits createAccountApplicationUsageLimits(
      AccountApplicationUsageLimits accountApplicationUsageLimits) {

    return null;
  }

  @Override
  public AccountApplicationUsageLimits updateAccountApplicationUsageLimits(
      AccountApplicationUsageLimits accountApplicationUsageLimits) {
    return null;
  }

  @Override
  public AccountApplicationUsageLimits getAccountApplicationUsageLimitsByMappingId(int accountApplicationId) {
    return null;
  }

}
