package com.hexaware.cms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cms.entity.ClaimDetails;
import com.hexaware.cms.entity.PlanDetails;
import com.hexaware.cms.service.PlanDetailsService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/ClaimManagementSystem")
public class PlanDetailsController {
	@Autowired
	PlanDetailsService planDetailsService;
	
	@GetMapping("/getallplans")
	public List<PlanDetails> getAllPlans(){
		return planDetailsService.findAllPlans();
	}
	
	@GetMapping("/getplan/{planname}/{insuredamount}")
	@ApiOperation(value = "Get an plan by name and insured amount")
	List<PlanDetails> getPlanByPlanNameAndInsuredAmount(
			@PathVariable("planname") String planName,@PathVariable("insuredamount") Long insuredAmount){
		return planDetailsService.findByPlanNameAndInsuredAmount(planName, insuredAmount);
	}
	
	@PostMapping("/addplans")
	public String savePlans(@RequestBody PlanDetails planDetail) {
		return planDetailsService.savePlan(planDetail) + "plans added Successfully";
	}
	
	@DeleteMapping("/deleteplan/{planid}")
	public String deletePlans(@PathVariable("planid") Long planId) {
		planDetailsService.deletePlanById(planId);
		return "ClaimDetails Deleted Successfully";
	}
	
	@GetMapping("/getplan/{planid}")
	public Optional<PlanDetails> getPlans(@PathVariable("planid") Long planId) {
		return planDetailsService.findPlanById(planId);
	}
	
	@PutMapping("/updateplan/{planid}")
	@ApiOperation(value = "update plan details")
	public String Update(@RequestBody PlanDetails planDetails,@PathVariable("planid") Long planId) throws Exception {
		
		PlanDetails existingPlanDetail =  planDetailsService.findPlanById(planId).
				orElseThrow(() -> new Exception("planDetails not found with id" + planId));
		existingPlanDetail.setPlanId(planDetails.getPlanId());
		existingPlanDetail.setInsuredAmount(planDetails.getInsuredAmount());
		existingPlanDetail.setPlanStartDate(planDetails.getPlanStartDate());
		existingPlanDetail.setPlanEndDate(planDetails.getPlanEndDate());
		existingPlanDetail.setPlanName(planDetails.getPlanName());
		
		return planDetailsService.updatePlan(planDetails) + " PLan updated successfully";
	}
	

}
