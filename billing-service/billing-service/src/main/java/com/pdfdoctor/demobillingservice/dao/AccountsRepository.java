package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountsRepository
    extends JpaRepository<Accounts, Integer>, QuerydslPredicateExecutor<Accounts> {}
