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
@Table(name = "invoices")
@Data
public class Invoices {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "account_id")
  private int accountId;

  @Column(name = "price")
  private int price;

  @Column(name = "month")
  private String month;

  @Column(name = "invoice_number")
  private int invoiceNumber;

  @Column(name = "invoice_media_id")
  private int invoiceMediaId;

  @Column(name = "invoice_status")
  private int invoiceStatus;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;
}
