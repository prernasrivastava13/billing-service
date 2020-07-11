package com.test.billingservice.dao;

import com.test.billingservice.entity.MasterApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterApplicationsRepository
    extends JpaRepository<MasterApplications, Integer>,
        QuerydslPredicateExecutor<MasterApplications> {}
