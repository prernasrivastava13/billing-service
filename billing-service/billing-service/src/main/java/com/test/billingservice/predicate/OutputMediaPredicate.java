package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QOutputMedia;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputMediaPredicate {

  public static Predicate getOutputMediaByMediaId(int mediaId) {
    return QOutputMedia.outputMedia.mediaId.eq(mediaId);
  }

  public static Predicate getOutputMediaByAccountId(final int accountId) {
    return QOutputMedia.outputMedia.accountId.eq(accountId);
  }

  public static Predicate getOutputMediaBySize(final int maxSize, final int minSize) {
    return QOutputMedia.outputMedia.size.between(minSize, maxSize);
  }

  public static Predicate getOutputMediaByApi(final String api) {
    return QOutputMedia.outputMedia.api.eq(api);
  }

  public static Predicate getOutputMediaCreditConsumed(
      final int minCreditConsumed, final int maxCreditConsumed) {
    return QOutputMedia.outputMedia.creditsConsumed.between(minCreditConsumed, maxCreditConsumed);
  }

  public static Predicate getOutputMediaApplicationId(final int applicationId) {
    return QOutputMedia.outputMedia.applicationId.eq(applicationId);
  }
}
