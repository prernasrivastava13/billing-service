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
@Table(name = "output_media")
@Data
public class OutputMedia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "media_id")
  private int mediaId;

  @Column(name = "account_id")
  private int accountId;

  @Column(name = "size")
  private int size;

  @Column(name = "api")
  private String api;

  @Column(name = "credits_consumed")
  private int creditsConsumed;

  @Column(name = "application_id")
  private int applicationId;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private Date createdAt = new Date();

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt = new Date();
}
