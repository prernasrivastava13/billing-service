package com.pdfdoctor.demobillingservice.controller;

import com.pdfdoctor.demobillingservice.entity.Accounts;
import com.pdfdoctor.demobillingservice.service.AccountsService;
import com.pdfdoctor.demobillingservice.service.AccountsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/billingService")
public class AccountsController {

  @Autowired
  @Resource private AccountsService accountsService;

  @PostMapping("/accounts")
  public ResponseEntity<Accounts> createAccounts(@RequestBody Accounts accounts) {
    Accounts createdAccounts = accountsService.createAccounts(accounts);
    if (createdAccounts == null) {
      return ResponseEntity.notFound().build();
    }
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{accountId}")
            .buildAndExpand(createdAccounts.getAccountId())
            .toUri();
    return ResponseEntity.created(uri).body(createdAccounts);
  }
}
