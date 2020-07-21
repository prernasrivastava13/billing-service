package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QCreditInformation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditInformationPredicate {

  public static Predicate getCreditInformationByApplicationId(int applicationId) {
    return QCreditInformation.creditInformation.applicationId.eq(applicationId);
  }
}
