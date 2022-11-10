package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.cms.entity.PlanDetails;


public interface PlanDetailsService {
	public List<PlanDetails> findAllPlans();
	public Optional<PlanDetails> findPlanById(Long planId);
	public void deletePlanById(Long planId);
	public PlanDetails savePlan(PlanDetails planDetails);
	public PlanDetails updatePlan(PlanDetails planDetails);
	public List<PlanDetails> findByPlanNameAndInsuredAmount(String planName,Long insuredAmount);
}
