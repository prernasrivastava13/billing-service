package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QAccountApplicationMapping;
import com.test.billingservice.entity.QAccountApplicationUsageLimits;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountApplicationUsageLimitsPredicate {

  public static Predicate getAccountApplicationUsageByMappingId(int accountApplicationMappingId) {
    return QAccountApplicationMapping.accountApplicationMapping
        .accountId
        .eq(accountApplicationMappingId)
        .and(
            QAccountApplicationMapping.accountApplicationMapping.applicationId.eq(
                accountApplicationMappingId));
  }

  public static Predicate getAccountApplicationUsageByAccountAppMappingIdAndMonth(
      int accountApplicationMappingId, String month) {
    return QAccountApplicationUsageLimits.accountApplicationUsageLimits
        .accountApplicationMapping
        .id
        .eq(accountApplicationMappingId)
        .and(QAccountApplicationUsageLimits.accountApplicationUsageLimits.month.eq(month));
  }
}
