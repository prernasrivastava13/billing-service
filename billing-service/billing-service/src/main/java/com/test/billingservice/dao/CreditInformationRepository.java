package com.test.billingservice.dao;

import com.test.billingservice.entity.CreditInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditInformationRepository
    extends JpaRepository<CreditInformation, Integer>,
        QuerydslPredicateExecutor<CreditInformation> {

  public CreditInformation getByApplicationId(int applicationId);
}
