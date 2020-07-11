package com.test.billingservice.service;

import com.test.billingservice.dao.AccountApplicationMappingRepository;
import com.test.billingservice.entity.AccountApplicationMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountApplicationMappingServiceImpl implements AccountApplicationMappingService {

  @Resource private AccountApplicationMappingRepository accountApplicationMappingRepository;

  @Override
  public AccountApplicationMapping createAccountApplicationMapping(
      AccountApplicationMapping accountApplicationMapping) {
    AccountApplicationMapping createdAccountApplicationMapping =
        accountApplicationMappingRepository.save(accountApplicationMapping);
    if (createdAccountApplicationMapping != null) {
      return createdAccountApplicationMapping;
    }
    log.info("Error creating Account Application Mapping!");
    return null;
  }

  @Override
  public AccountApplicationMapping getAccountApplicationMappingByAccountIdAndApplicationId(
      int accountId, int applicationId) {
    AccountApplicationMapping accountApplicationMapping =
        accountApplicationMappingRepository.getAccountApplicationMappingByAccountIdAndApplicationId(
            accountId, applicationId);
    if (accountApplicationMapping != null) {
      return accountApplicationMapping;
    }
    log.info("Error finding Account Application Mapping!");
    return null;
  }

  @Override
  public AccountApplicationMapping updateAccountApplicationMapping(
      AccountApplicationMapping accountApplicationMapping) {
    AccountApplicationMapping updatedAccountApplicationMapping =
        accountApplicationMappingRepository.save(accountApplicationMapping);
    return updatedAccountApplicationMapping;
  }
}
