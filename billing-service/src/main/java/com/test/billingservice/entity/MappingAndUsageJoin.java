package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MappingAndUsageJoin {

  @Column(name = "account_id")
  private String accountId;

  @Column(name = "application_id")
  private String applicationId;

  @Column(name = "active")
  private boolean active;

  @Column(name = "credit_limit")
  private int creditLimit;

  @Column(name = "account_application_mapping")
  private int accountApplicationMapping;

  @Column(name = "month")
  private String month;

  @Column(name = "credit_used")
  private int creditUsed;
}
