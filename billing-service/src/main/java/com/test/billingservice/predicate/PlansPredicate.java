package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QPlans;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlansPredicate {

  public static Predicate getPlanByCreditAndApplicationId(int credits, int applicationId) {
    return (QPlans.plans.maxCredits.goe(credits).and(QPlans.plans.minCredits.loe(credits)))
        .and(QPlans.plans.applicationId.eq(applicationId));
  }
}
