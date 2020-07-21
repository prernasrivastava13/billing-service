package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
@Data
public class Invoices {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private boolean invoiceStatus;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt = LocalDateTime.now();
}
