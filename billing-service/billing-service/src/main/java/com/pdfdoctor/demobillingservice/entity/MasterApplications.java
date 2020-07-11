package com.pdfdoctor.demobillingservice.entity;

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
@Table(name = "MASTER-APPLICATION")
public class MasterApplications {

  @Id
  @Column(name = "ID")
  int id;

  @Column(name = "NAME")
  String name;
}
