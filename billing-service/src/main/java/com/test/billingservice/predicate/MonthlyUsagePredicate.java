package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QMonthlyUsage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MonthlyUsagePredicate {

  public static Predicate getMonthlyUsageByAccountIdAndMonth(int accountId, String month) {
    return QMonthlyUsage.monthlyUsage
        .accountId
        .eq(accountId)
        .and(QMonthlyUsage.monthlyUsage.month.eq(month));
  }
}
