package com.test.billingservice.predicate;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.entity.QInvoices;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoicesPredicate {

  public static Predicate getInvoicesByAccountIdAndMonth(int accountId, String month) {
    return QInvoices.invoices.accountId.eq(accountId).and(QInvoices.invoices.month.eq(month));
  }
}
