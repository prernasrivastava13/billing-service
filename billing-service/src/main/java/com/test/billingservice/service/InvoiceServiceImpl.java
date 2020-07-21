package com.test.billingservice.service;

import com.test.billingservice.dao.InvoicesRepository;
import com.test.billingservice.entity.Invoices;
import com.test.billingservice.predicate.InvoicesPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

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
  public Invoices updateInvoiceService(Invoices invoices, boolean status) {
    invoices.setInvoiceStatus(status);
    Invoices updatedInvoices = invoicesRepository.save(invoices);
    if (updatedInvoices != null) {
      return updatedInvoices;
    }
    log.info("Error updating Invoices!");
    return null;
  }

  @Override
  public Invoices getInvoiceById(int id) {
    Optional<Invoices> invoices = invoicesRepository.findById(id);
    if (invoices.isPresent()) {
      return invoices.get();
    }
    log.info("Error finding invoices with id: " + id);
    return null;
  }

  @Override
  public Invoices findByAccountIdAndMonth(int accountId, String month) {
    Optional<Invoices> invoices =
        invoicesRepository.findOne(
            InvoicesPredicate.getInvoicesByAccountIdAndMonth(accountId, month));
    if (invoices.isPresent()) {
      return invoices.get();
    }
    log.info("Error finding invoices for accountId: " + accountId + " and month: " + month);
    return null;
  }
}
