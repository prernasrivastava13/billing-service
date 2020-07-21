package com.test.billingservice.controller;

import com.test.billingservice.entity.Invoices;
import com.test.billingservice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/billingService/invoice")
public class InvoiceController {

  @Resource private InvoiceService invoiceService;

  @PutMapping("/update/{invoiceId}/{status}")
  public ResponseEntity<Invoices> updateInvoices(
      @PathVariable int invoiceId, @PathVariable boolean status) {
    Invoices invoices = invoiceService.getInvoiceById(invoiceId);
    if (invoices == null) {
      return ResponseEntity.notFound().build();
    }
    Invoices updatedInvoices = invoiceService.updateInvoiceService(invoices, status);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{accountId}")
            .buildAndExpand(updatedInvoices.getId())
            .toUri();
    return ResponseEntity.created(uri).body(updatedInvoices);
  }
}
