package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cms.entity.ClaimDetails;
import com.hexaware.cms.repository.ClaimDetailsRepository;

@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {
	@Autowired
	ClaimDetailsRepository claimRepo;

	@Override
	public List<ClaimDetails> findAllClaims() {
		// TODO Auto-generated method stub
		return claimRepo.findAll();
	}

	@Override
	public Optional<ClaimDetails> findClaimById(Long claimId) {
		// TODO Auto-generated method stub
		return claimRepo.findById(claimId);
	}

	@Override
	public void deleteClaimById(Long claimId) {
		claimRepo.deleteById(claimId);
		
	}

	@Override
	public ClaimDetails saveClaimDetails(ClaimDetails claimDetails) {
		// TODO Auto-generated method stub
		return claimRepo.save(claimDetails);
	}

	@Override
	public List <ClaimDetails> findByClaimType(String claimType) {
		// TODO Auto-generated method stub
		return claimRepo.findByClaimType(claimType);

	}

	@Override
	public ClaimDetails updateClaimDetails(ClaimDetails claimDetails) {
		// TODO Auto-generated method stub
		return claimRepo.save(claimDetails);
	}





}
