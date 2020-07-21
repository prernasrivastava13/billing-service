package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QAccountApplicationMapping;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountApplicationMappingPredicate {

  public static Predicate getIdByAccountIdAndApplicationId(int accountId, int applicationId) {
    return QAccountApplicationMapping.accountApplicationMapping
        .accountId
        .eq(accountId)
        .and(QAccountApplicationMapping.accountApplicationMapping.applicationId.eq(applicationId));
  }

  public static Predicate getAccountApplicationMappingByAccountIdAndApplicationId(
      int accountId, int applicationId) {
    return QAccountApplicationMapping.accountApplicationMapping
        .accountId
        .eq(accountId)
        .and(QAccountApplicationMapping.accountApplicationMapping.applicationId.eq(applicationId));
  }
}
