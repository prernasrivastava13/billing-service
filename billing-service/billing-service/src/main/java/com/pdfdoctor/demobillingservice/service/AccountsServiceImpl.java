package com.pdfdoctor.demobillingservice.service;

import com.pdfdoctor.demobillingservice.dao.AccountsRepository;
import com.pdfdoctor.demobillingservice.entity.Accounts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountsServiceImpl implements AccountsService {

  @Resource
  private AccountsRepository accountsRepository;

  @Override
  public Accounts createAccounts(Accounts accounts) {
    Accounts createdAccounts = accountsRepository.save(accounts);
    if (createdAccounts != null) return createdAccounts;
    log.info("Error creating account");
    throw new RuntimeException("Error creating account");
  }
}
