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
@Data
@Table(name = "accounts")
public class Accounts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "primary_email")
  private String primaryEmail;

  @Column(name = "primary_phone_number")
  private String primaryPhoneNumber;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private Date createdAt = new Date();

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt = new Date();

  @Transient private int applicationId;
}
