package com.pdfdoctor.demobillingservice.dao;

import com.pdfdoctor.demobillingservice.entity.OutputMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputMediaRepository extends JpaRepository<OutputMedia, Integer>
//        , QuerydslPredicateExecutor<OutputMedia>
{}
