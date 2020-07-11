package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<Plans, Integer>
//        , QuerydslPredicateExecutor<Plans>
{}
