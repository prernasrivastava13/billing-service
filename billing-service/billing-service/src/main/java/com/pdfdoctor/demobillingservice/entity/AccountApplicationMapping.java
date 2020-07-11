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
@Table(name = "account-application-mapping")
@Data
public class AccountApplicationMapping {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "application_id")
  int applicationId;

  @Column(name = "active")
  boolean active;

  @Column(name = "created_at")
  Date createdAt;

  @Column(name = "updated_at")
  Date updatedAt;

  @Column(name = "credit_limit")
  int creditLimit;
}
