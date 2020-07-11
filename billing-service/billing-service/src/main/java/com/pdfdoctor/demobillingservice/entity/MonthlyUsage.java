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
@Table(name = "MONTHLY-USAGE")
@Data
public class MonthlyUsage {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "month")
  String month;

  @Column(name = "account-id")
  int accountId;

  @Column(name = "CREDITS-CONSUMED")
  int creditsConsumed;

  @Column(name = "INVOICE-ID")
  int invoiceId;

  @Column(name = "CREATED-AT")
  Date createdAt;

  @Column(name = "UPDATED-AT")
  Date updatedAt;
}
