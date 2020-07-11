package com.test.billingservice.dao;

import com.test.billingservice.entity.OutputMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutputMediaRepository
    extends JpaRepository<OutputMedia, Integer>, QuerydslPredicateExecutor<OutputMedia> {

  public List<OutputMedia> getByAccountId(int accountId);
}
