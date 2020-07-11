package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
// @IdClass(AccountApplicationMapping.AccountApplicationMappingId.class)
@Table(name = "account_application_mapping")
@Data
public class AccountApplicationMapping {

  @Id
  @OneToOne
  @JoinColumn(name = "id")
  private int id;

  //  @Id
  @Column(name = "account_id")
  private int accountId;

  //  @Id
  @Column(name = "application_id")
  private int applicationId;

  @Column(name = "active")
  private boolean active = true;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private Date createdAt = new Date();

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt = new Date();

  @Column(name = "credit_limit")
  private int creditLimit = 0;
}
