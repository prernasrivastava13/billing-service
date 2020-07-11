package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master_application")
public class MasterApplications {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;
}
