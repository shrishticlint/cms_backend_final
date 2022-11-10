package com.hexaware.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PlanDetails {
	@Id
	@Column(name="plan_id")
	private Long planId;
	@Column(name="plan_startdate")
	private String planStartDate;
	@Column(name="plan_enddate")
	private String planEndDate;
	@Column(name="plan_name")
	private String planName;
	@Column(name="plan_insuredamount")
	private Long insuredAmount;	
	public PlanDetails() {
		
	}
	
	@OneToMany(fetch =FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name= "plan_id_fk",referencedColumnName="plan_id")
	private List<ClaimDetails> CLAIMS =new ArrayList<>();
	
	//@OneToMany(fetch =FetchType.EAGER, cascade=CascadeType.ALL)
	//@JoinColumn(name= "plan_id_fk",referencedColumnName="plan_id")
	//private List<Member> member =new ArrayList<>();
	

	public List<ClaimDetails> getCLAIMS() {
		return CLAIMS;
	}

	public void setCLAIMS(List<ClaimDetails> CLAIMS) {
		this.CLAIMS = CLAIMS;
	}


	public PlanDetails(Long planId, String planStartDate, String planEndDate, String planName, Long insuredAmount) {
		super();
		this.planId = planId;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.planName = planName;
		this.insuredAmount = insuredAmount;
	}

	public PlanDetails(String planStartDate, String planEndDate, String planName, Long insuredAmount) {
		super();
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.planName = planName;
		this.insuredAmount = insuredAmount;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(Long insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	
	
	

}
