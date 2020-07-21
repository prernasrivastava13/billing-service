package com.test.billingservice.dao;

import com.test.billingservice.entity.AccountApplicationUsageLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountApplicationUsageLimitsRepository
    extends JpaRepository<AccountApplicationUsageLimits, Integer>,
        QuerydslPredicateExecutor<AccountApplicationUsageLimits> {

  //  public AccountApplicationUsageLimits
  //      getAccountApplicationUsageLimitsByAccountApplicationMapping_Id(int id);

  @Query(
      value =
          "SELECT *\n"
              + "FROM account_application_usage_limits\n"
              + "INNER JOIN account_application_mapping ON account_application_usage_limits.account_application_mapping=account_application_mapping.id",
      nativeQuery = true)
  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoin();

  @Query(
      value =
          "SELECT *\n"
              + "FROM account_application_usage_limits\n"
              + "INNER JOIN account_application_mapping WHERE (account_application_usage_limits.account_application_mapping=account_application_mapping.id) && account_application_usage_limits.month = ?1",
      nativeQuery = true)
  public Set<AccountApplicationUsageLimits> findAccountApplicationUsageByJoinAndMonth(String month);

//  public AccountApplicationUsageLimits findByAccountApplicationMapping_IdAndMonth(
//      int accountApplicationMappingId, String month);
}
