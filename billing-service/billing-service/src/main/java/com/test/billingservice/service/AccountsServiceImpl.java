package com.test.billingservice.service;

import com.test.billingservice.dao.AccountsRepository;
import com.test.billingservice.entity.AccountApplicationMapping;
import com.test.billingservice.entity.Accounts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountsServiceImpl implements AccountsService {

  @Resource private AccountsRepository accountsRepository;

  @Resource private AccountApplicationMappingService accountApplicationMappingService;

  @Override
  public Accounts createAccounts(Accounts accounts) {
    Accounts createdAccounts = accountsRepository.save(accounts);
    if (createdAccounts != null) {
      AccountApplicationMapping accountApplicationMapping = new AccountApplicationMapping();
      accountApplicationMapping.setAccountId(accounts.getId());
      accountApplicationMapping.setApplicationId(accounts.getApplicationId());
      accountApplicationMapping.setActive(true);
      accountApplicationMapping.setCreditLimit(0);
      AccountApplicationMapping createdAccountApplicationMapping =
          accountApplicationMappingService.createAccountApplicationMapping(
              accountApplicationMapping);
      if (createdAccountApplicationMapping != null) {
        log.info(
            "Created Account Application Mapping: " + createdAccountApplicationMapping.toString());
        return createdAccounts;
      }
      log.info("Error creating Account Application mapping!");
    }
    log.info("Error creating account");
    throw new RuntimeException("Error creating account");
  }
}
