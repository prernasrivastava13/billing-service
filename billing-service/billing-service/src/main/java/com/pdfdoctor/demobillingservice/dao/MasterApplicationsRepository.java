package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.MasterApplications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterApplicationsRepository extends JpaRepository<MasterApplications, Integer>
//        ,QuerydslPredicateExecutor<MasterApplications>
{}
