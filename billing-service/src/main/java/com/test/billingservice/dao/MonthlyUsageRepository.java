package com.test.billingservice.dao;

import com.test.billingservice.entity.MonthlyUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyUsageRepository
    extends JpaRepository<MonthlyUsage, Integer>, QuerydslPredicateExecutor<MonthlyUsage> {

  //  public MonthlyUsage findByAccountIdAndMonth(int accountId, String month);
}
