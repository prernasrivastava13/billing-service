package com.test.billingservice.service;

import com.test.billingservice.entity.CreditInformation;

public interface CreditInformationService {

  public CreditInformation getCreditInformationByApiId(int applicationId);
}
