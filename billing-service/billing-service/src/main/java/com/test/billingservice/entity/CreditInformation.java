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
@Table(name = "credit_information")
@Data
public class CreditInformation {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "application_id")
  private int applicationId;

  @Column(name = "per_credit_file_size")
  private int perCreditFileSize;
}
