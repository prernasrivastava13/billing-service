package com.pdfdoctor.demobillingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLANS")
@Data
public class Plans {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "application-id")
  int applicationId;

  @Column(name = "account-id")
  int accountId;

  @Column(name = "plan-name")
  String planName;

  @Column(name = "min-credits")
  int minCredits;

  @Column(name = "max-credits")
  int maxCredits;

  @Column(name = "per-credit-file-size")
  int perCreditFileSize;
}
