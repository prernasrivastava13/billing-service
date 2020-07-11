package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.AccountApplicationUsageLimits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountApplicationUsageLimitsRepository
    extends JpaRepository<AccountApplicationUsageLimits, Integer> {}
