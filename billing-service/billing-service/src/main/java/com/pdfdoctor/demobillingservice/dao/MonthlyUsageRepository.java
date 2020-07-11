package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.MonthlyUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyUsageRepository extends JpaRepository<MonthlyUsage, Integer>
//        , QuerydslPredicateExecutor<MonthlyUsage>
{}
