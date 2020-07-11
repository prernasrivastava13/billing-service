package com.pdfdoctor.demobillingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_application_usage_limits")
@Data
public class AccountApplicationUsageLimits {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "account-application-mapping")
  int applicationId;

  @Column(name = "month")
  String month;

  @Column(name = "created-at")
  Date createdAt;

  @Column(name = "updated-at")
  Date updatedAt;

  @Column(name = "credit_used")
  int creditUsed;
}
