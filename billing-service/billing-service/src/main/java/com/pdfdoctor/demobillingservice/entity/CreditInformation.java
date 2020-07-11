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
@Table(name = "CREDIT-INFORMATION")
@Data
public class CreditInformation {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "application-id")
  int applicationId;

  @Column(name = "account-id")
  int accountId;

  @Column(name = "per-credit-file-size")
  int perCreditFileSize;
}
