package com.test.billingservice.service;

import com.test.billingservice.dao.AccountApplicationMappingRepository;
import com.test.billingservice.entity.AccountApplicationMapping;
import com.test.billingservice.predicate.AccountApplicationMappingPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

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
    Optional<AccountApplicationMapping> accountApplicationMapping =
        accountApplicationMappingRepository.findOne(
            AccountApplicationMappingPredicate
                .getAccountApplicationMappingByAccountIdAndApplicationId(accountId, applicationId));
    //
    // accountApplicationMappingRepository.getAccountApplicationMappingByAccountIdAndApplicationId(
    //            accountId, applicationId);
    if (accountApplicationMapping.isPresent()) {
      return accountApplicationMapping.get();
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
