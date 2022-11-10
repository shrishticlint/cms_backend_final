package com.hexaware.cms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.hexaware.cms.entity.ClaimDetails;

@Repository
@EnableJpaRepositories
public interface ClaimDetailsRepository extends JpaRepository<ClaimDetails, Long> {
   public List<ClaimDetails> findByClaimType(String claimType);
}
//findbybalance