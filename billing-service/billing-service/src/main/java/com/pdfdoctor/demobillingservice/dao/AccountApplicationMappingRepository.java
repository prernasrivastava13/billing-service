package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.AccountApplicationMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountApplicationMappingRepository
    extends JpaRepository<AccountApplicationMapping, Integer>
//        , QuerydslPredicateExecutor
{}
