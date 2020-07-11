package com.test.billingservice.dao;

import com.test.billingservice.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepository
    extends JpaRepository<Plans, Integer>, QuerydslPredicateExecutor<Plans> {}
