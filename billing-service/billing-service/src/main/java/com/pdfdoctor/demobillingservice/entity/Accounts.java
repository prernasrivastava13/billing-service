package com.pdfdoctor.demobillingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "ACCOUNTS")
public class Accounts {

  @Id
  @Column(name = "ACCOUNT-ID")
  int accountId;

  @Column(name = "ACCOUNT-HOLDER-NAME")
  String accountHolderName;

  @Column(name = "PRIMARY-EMAIL")
  String primaryEmail;

  @Column(name = "PRIMARY-PHONE-NUMBER")
  String primaryPhoneNumber;

  @Column(name = "CREATED-AT")
  Date createdAt;

  @Column(name = "UPDATED-AT")
  Date updatedAt;
}
