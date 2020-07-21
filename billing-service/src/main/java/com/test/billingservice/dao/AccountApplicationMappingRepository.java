package com.test.billingservice.dao;

import com.test.billingservice.entity.AccountApplicationMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountApplicationMappingRepository
    extends JpaRepository<AccountApplicationMapping, Integer>,
        QuerydslPredicateExecutor<AccountApplicationMapping> {

//  public AccountApplicationMapping getAccountApplicationMappingByAccountIdAndApplicationId(
//      int accountId, int applicationId);

  @Query(
      value =
          "SELECT *\n"
              + "FROM account_application_mapping\n"
              + "INNER JOIN account_application_usage_limits ON account_application_mapping.id=account_application_usage_limits.account_application_mapping",
      nativeQuery = true)
  public Set<AccountApplicationMapping> findAccountApplicationMappingByJoin();
}
