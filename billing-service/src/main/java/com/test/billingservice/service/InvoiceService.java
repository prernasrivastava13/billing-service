package com.test.billingservice.service;

import com.test.billingservice.entity.Invoices;

public interface InvoiceService {

  public Invoices saveInvoiceService(Invoices invoices);

  public Invoices updateInvoiceService(Invoices invoices, boolean status);

  public Invoices getInvoiceById(int id);

  Invoices findByAccountIdAndMonth(int accountId, String month);
}
