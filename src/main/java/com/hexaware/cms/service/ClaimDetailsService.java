package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.cms.entity.ClaimDetails;
import com.hexaware.cms.exception.ResourceNotFoundException;


public interface ClaimDetailsService {
	public List<ClaimDetails> findAllClaims();
	public Optional<ClaimDetails> findClaimById(Long claimId);
	public void deleteClaimById(Long claimId);
	public ClaimDetails saveClaimDetails(ClaimDetails claimDetails);
	public ClaimDetails updateClaimDetails(ClaimDetails claimDetails) throws ResourceNotFoundException;
	public List<ClaimDetails> findByClaimType(String claimType);

}
