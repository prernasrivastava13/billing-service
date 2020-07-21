package com.test.billingservice.dao;

import com.test.billingservice.entity.OutputMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputMediaRepository
    extends JpaRepository<OutputMedia, Integer>, QuerydslPredicateExecutor<OutputMedia> {}
