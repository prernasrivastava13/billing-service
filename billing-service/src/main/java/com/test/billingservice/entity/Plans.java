package com.test.billingservice.entity;

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
@Table(name = "plans")
@Data
public class Plans {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "application_id")
  private int applicationId;

  @Column(name = "plan_name")
  private String planName;

  @Column(name = "min_credits")
  private int minCredits;

  @Column(name = "max_credits")
  private int maxCredits;

  @Column(name = "fix_price")
  private int fixPrice;

  @Column(name = "per_credit_file_size")
  private int perCreditFileSize;
}
