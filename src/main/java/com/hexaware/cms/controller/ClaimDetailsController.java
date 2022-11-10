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
import com.hexaware.cms.service.ClaimDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/ClaimManagementSystem")
@Api(value = "Claim Management System",description = "Managing Claims of Insured Customers")
public class ClaimDetailsController {
	@Autowired
	ClaimDetailsService claimDetailsService;
	
	@GetMapping("/getclaimdetails")
	@ApiOperation(value = "view a list of Claims",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully retrieved list of claims"),
			@ApiResponse(code = 401,message = "you are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	
	List<ClaimDetails> getAllClaims(){
		return claimDetailsService.findAllClaims();
	}
	
//	@GetMapping("/getallclaims")
//	public List<ClaimDetails> getAllClaims(){
//		return claimDetailsService.findAllClaims();
//	}
	
	@PostMapping("/addclaims")
	public String saveClaimDetails(@RequestBody ClaimDetails claimDetails) {
		return claimDetailsService.saveClaimDetails(claimDetails) + "ClaimDetails added Successfully";
	}
	
	@DeleteMapping("/deleteclaimdetails/{claimid}")
	public String deleteClaimDetails(@PathVariable("claimid") Long claimsId) {
		 claimDetailsService.deleteClaimById(claimsId);
		 return "ClaimDetails Deleted Successfully";
	}
	
	@GetMapping("/getclaimdetailsbyid/{claimid}")
	public Optional<ClaimDetails> getClaimDetails(@PathVariable("claimid") Long claimId) {
		return claimDetailsService.findClaimById(claimId);
	}
	
	@PutMapping("/updateclaimdetails/{claimid}")
	@ApiOperation(value = "update an claimDetail.......")
	ClaimDetails updateClaimDetail(
			@RequestBody ClaimDetails claimDetails,
			@PathVariable("claimid") Long claimId) throws Exception {
		ClaimDetails existingClaimDetail =  claimDetailsService.findClaimById(claimId)
				.orElseThrow(() -> new Exception("claimDetails not found with id" + claimId));
//		existingClaimDetail.setClaimId(claimDetails.getClaimId());
//		existingClaimDetail.setClaimTotalAmount(claimDetails.getClaimTotalAmount());
//		existingClaimDetail.setClaimDate(claimDetails.getClaimDate());
		existingClaimDetail.setClaimStatus(claimDetails.getClaimStatus());
//		existingClaimDetail.setClaimDocuments(claimDetails.getClaimDocuments());
//		existingClaimDetail.setClaimType(claimDetails.getClaimType());
//		existingClaimDetail.setBillDetails(claimDetails.getBillDetails());
//		existingClaimDetail.setAmountToClaim(claimDetails.getAmountToClaim());
//		existingClaimDetail.setRemaining_amount(claimDetails.getRemaining_amount());
		
		return claimDetailsService.updateClaimDetails(existingClaimDetail);
	}
	
	
//@GetMapping("/getClaimDetails/{claimtype}")
//public List<ClaimDetails> getClaimdetailsByClaimType(@PathVariable("claimtype")ClaimDetails claimType)
//{
//		return claimDetailsService.findByType(claimType);
//}
	
    @GetMapping("/getclaimdetailsbyclaimtype/{claimtype}")
	List<ClaimDetails> getClaimdetailsByClaimType(
			@ApiParam (value="returns the claim details with claim type",required = true)
			@PathVariable("claimtype") String claimType){
		return claimDetailsService.findByClaimType(claimType);
	}
    
//    @GetMapping("/getClaimsRemainingAmount/{claimid}")
//	public Long getClaimsRemainingAmount(
//			@ApiParam (value="returns the remaining amount using claim id",required = true)
//			@PathVariable("claimid") String claimid){
//		return claimDetailsService.getClaimTotalAmount()-claimDetailsService.getAmountToClaim();
//	}
}

