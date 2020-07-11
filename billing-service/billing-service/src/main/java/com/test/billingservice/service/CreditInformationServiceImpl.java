package com.test.billingservice.service;

import com.test.billingservice.dao.CreditInformationRepository;
import com.test.billingservice.entity.CreditInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class CreditInformationServiceImpl implements CreditInformationService {

  @Resource CreditInformationRepository creditInformationRepository;

  @Override
  public CreditInformation getCreditInformationByApiId(int applicationId) {
    CreditInformation creditInformation =
        creditInformationRepository.getByApplicationId(applicationId);
    if (creditInformation != null) {
      return creditInformation;
    }
    log.info("Error retreiving credit information with api id: " + applicationId);
    return null;
  }
}
