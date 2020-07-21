package com.test.billingservice.service;

import com.test.billingservice.dao.PlansRepository;
import com.test.billingservice.entity.Plans;
import com.test.billingservice.predicate.PlansPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class PlansServiceImpl implements PlansService {

  @Resource private PlansRepository plansRepository;

  @Override
  public Optional<Plans> findPlanByCredits(int credits, int applicationId) {
    Optional<Plans> plans =
        plansRepository.findOne(
            PlansPredicate.getPlanByCreditAndApplicationId(credits, applicationId));
    return plans;
  }
}
