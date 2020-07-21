package com.test.billingservice.dao;

import com.test.billingservice.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository
    extends JpaRepository<Invoices, Integer>, QuerydslPredicateExecutor<Invoices> {

  //    Invoices findByAccountIdAndMonth(int accountId, String month);
}
