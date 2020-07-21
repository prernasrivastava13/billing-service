package com.test.billingservice.dao;

import com.test.billingservice.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepository
    extends JpaRepository<Plans, Integer>, QuerydslPredicateExecutor<Plans> {

  @Query(
      value =
          "select * from `demo-billing-service`.plans where (?1 between min_credits and max_credits) and application_id=?2",
      nativeQuery = true)
  public Plans findPlanByCredits(int credits, int applicationId);
}
