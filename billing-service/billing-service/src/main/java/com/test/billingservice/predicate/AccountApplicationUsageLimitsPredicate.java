package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QAccountApplicationMapping;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountApplicationUsageLimitsPredicate {

  private static Predicate getAccountApplicationUsageByMappingId(int accountApplicationMappingId) {
    return QAccountApplicationMapping.accountApplicationMapping
        .accountId
        .eq(accountApplicationMappingId)
        .and(
            QAccountApplicationMapping.accountApplicationMapping.applicationId.eq(
                accountApplicationMappingId));
  }
}
