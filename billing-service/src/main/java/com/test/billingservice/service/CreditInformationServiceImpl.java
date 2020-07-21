package com.test.billingservice.service;

import com.test.billingservice.dao.CreditInformationRepository;
import com.test.billingservice.entity.CreditInformation;
import com.test.billingservice.predicate.CreditInformationPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class CreditInformationServiceImpl implements CreditInformationService {

  @Resource CreditInformationRepository creditInformationRepository;

  @Override
  public CreditInformation getCreditInformationByApiId(int applicationId) {
    Optional<CreditInformation> creditInformation =
        creditInformationRepository.findOne(
            CreditInformationPredicate.getCreditInformationByApplicationId(applicationId));
    if (creditInformation.isPresent()) {
      return creditInformation.get();
    }
    log.info("Error retrieving credit information with api id: " + applicationId);
    return null;
  }
}
