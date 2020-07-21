package com.test.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_application_mapping")
@Data
public class AccountApplicationMapping {

//  @JsonIgnore
//  @OneToMany(mappedBy = "accountApplicationMapping")
//  List<AccountApplicationUsageLimits> accountApplicationUsageLimits =
//      new ArrayList<AccountApplicationUsageLimits>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "account_id")
  private int accountId;

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
