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
@Table(name = "OUTPUT-MEDIA")
@Data
public class OutputMedia {

  @Id
  @Column(name = "id")
  int id;

  @Column(name = "media-id")
  int mediaId;

  @Column(name = "account-id")
  int accountId;

  @Column(name = "size")
  int size;

  @Column(name = "api")
  String api;

  @Column(name = "credits-consumed")
  int creditsConsumed;

  @Column(name = "application-id")
  int applicationId;

  @Column(name = "created-at")
  Date createdAt;

  @Column(name = "updated-at")
  Date updatedAt;
}
