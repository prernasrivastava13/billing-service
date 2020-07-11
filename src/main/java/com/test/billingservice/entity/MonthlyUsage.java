package com.test.billingservice.entity;

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
@Table(name = "monthly_usage")
@Data
public class MonthlyUsage {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "month")
  private String month;

  @Column(name = "account_id")
  private int accountId;

  @Column(name = "credits_consumed")
  private int creditsConsumed;

  @Column(name = "invoice_id")
  private int invoiceId;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;
}
