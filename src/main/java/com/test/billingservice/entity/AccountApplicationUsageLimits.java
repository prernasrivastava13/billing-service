package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_application_usage_limits")
@Data
public class AccountApplicationUsageLimits {

  @Id
  @Column(name = "id")
  private int id;

  @OneToOne(mappedBy = "id")
  @JoinColumn(name = "account_application_mapping")
  private AccountApplicationMapping accountApplicationMapping;

  @Column(name = "month")
  private String month = "" + Calendar.getInstance().get(Calendar.MONTH) + 1;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @Column(name = "credit_used")
  private int creditUsed = 0;
}
