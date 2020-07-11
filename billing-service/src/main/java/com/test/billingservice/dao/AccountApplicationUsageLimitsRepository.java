package com.test.billingservice.dao;

import com.test.billingservice.entity.AccountApplicationUsageLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountApplicationUsageLimitsRepository
    extends JpaRepository<AccountApplicationUsageLimits, Integer>,
        QuerydslPredicateExecutor<AccountApplicationUsageLimits> {}
