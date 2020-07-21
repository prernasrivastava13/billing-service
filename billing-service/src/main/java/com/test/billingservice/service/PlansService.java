package com.test.billingservice.service;

import com.test.billingservice.entity.Plans;

import java.util.Optional;

public interface PlansService {

  public Optional<Plans> findPlanByCredits(int credits, int applicationId);
}
