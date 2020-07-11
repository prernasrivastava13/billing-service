package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesRepository extends JpaRepository<Invoices, Integer>
//        , QuerydslPredicateExecutor<Invoices>
{}
