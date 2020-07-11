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
@Table(name = "invoices")
@Data
public class Invoices {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "account-id")
    int accountId;

    @Column(name = "price")
    int price;

    @Column(name = "month")
    String month;

    @Column(name = "invoice-number")
    int invoiceNumber;

    @Column(name = "invoice-media-id")
    int invoiceMediaId;

    @Column(name = "invoice-status")
    int invoiceStatus;

    @Column(name = "created-at")
    Date createdAt;

    @Column(name = "updated-at")
    Date updatedAt;

}
