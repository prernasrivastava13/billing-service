package com.test.billingservice.service;

import com.test.billingservice.dao.InvoicesRepository;
import com.test.billingservice.entity.Invoices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

  @Resource private InvoicesRepository invoicesRepository;

  @Override
  public Invoices saveInvoiceService(Invoices invoices) {
    Invoices createdInvoices = invoicesRepository.save(invoices);
    if (createdInvoices != null) {
      return createdInvoices;
    }
    log.info("Error saving Invoices!");
    return null;
  }

  @Override
  public Invoices updateInvoiceService(Invoices invoices) {
    Invoices updatedInvoices = invoicesRepository.save(invoices);
    if (updatedInvoices != null) {
      return updatedInvoices;
    }
    log.info("Error updating Invoices!");
    return null;
  }
}
