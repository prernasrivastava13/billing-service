package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.CreditInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditInformationRepository extends JpaRepository<CreditInformation, Integer>
//        ,QuerydslPredicateExecutor<CreditInformation>
{}
