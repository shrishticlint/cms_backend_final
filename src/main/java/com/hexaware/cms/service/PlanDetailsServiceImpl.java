package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cms.entity.PlanDetails;
import com.hexaware.cms.repository.PlanDetailsRepository;
@Service
public class PlanDetailsServiceImpl implements PlanDetailsService {
	@Autowired
	PlanDetailsRepository planRepo;
	@Override
	public List<PlanDetails> findAllPlans() {
		// TODO Auto-generated method stub
		return planRepo.findAll();
	}

	@Override
	public Optional<PlanDetails> findPlanById(Long planId) {
		// TODO Auto-generated method stub
		return planRepo.findById(planId);
	}

	@Override
	public void deletePlanById(Long planId) {
		planRepo.deleteById(planId);
		
	}

	@Override
	public PlanDetails savePlan(PlanDetails planDetails) {
		// TODO Auto-generated method stub
		return planRepo.save(planDetails);
	}

    @Override
    public PlanDetails updatePlan(PlanDetails planDetails) {
        // TODO Auto-generated method stub
        return planRepo.save(planDetails);
    }

    @Override
    public List<PlanDetails> findByPlanNameAndInsuredAmount(String planName, Long insuredAmount) {
        // TODO Auto-generated method stub
        return planRepo.findByPlanNameAndInsuredAmount(planName, insuredAmount);
    }


}
