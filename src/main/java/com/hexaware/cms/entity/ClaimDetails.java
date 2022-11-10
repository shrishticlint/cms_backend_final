package com.hexaware.cms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClaimDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claim_id")
	private Long claimId;
	@Column(name = "claim_total_amount")
	private Long claimTotalAmount;
	@Column(name = "claim_date")
	private String claimDate;
	@Column(name = "claim_status")
	private String claimStatus;
	@Column(name = "claim_bill_details")
	private String billDetails;
	@Column(name = "claim_documents")
	private String claimDocuments;
	@Column(name="claim_Type")
	private String claimType;
	@Column(name="amount_to_claim")
	private Long amountToClaim;
	@Column(name="remaining_amount")
	private Long remaining_amount;
	
	public Long getRemaining_amount() {
		return remaining_amount;
	}

	public Long getAmountToClaim() {
		return amountToClaim;
	}

	public void setAmountToClaim(Long amountToClaim) {
		this.amountToClaim = amountToClaim;
	}

	public ClaimDetails() {
		
	}

	public ClaimDetails(Long claimId, Long claimTotalAmount, String claimDate, String claimStatus, String billDetails,
			String claimDocuments,String claimType,Long amountToClaim) {
		super();
		this.claimId = claimId;
		this.claimTotalAmount = claimTotalAmount;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.billDetails = billDetails;
		this.claimDocuments = claimDocuments;
		this.claimType=claimType;
		this.amountToClaim=amountToClaim;
	}

	public ClaimDetails(Long claimTotalAmount, String claimDate, String claimStatus, String billDetails,
			String claimDocuments,String claimType,Long amountToClaim) {
		super();
		this.claimTotalAmount = claimTotalAmount;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.billDetails = billDetails;
		this.claimDocuments = claimDocuments;
		this.claimType=claimType;
		this.amountToClaim=amountToClaim;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public Long getClaimTotalAmount() {
		return claimTotalAmount;
	}

	public void setClaimTotalAmount(Long claimTotalAmount) {
		this.claimTotalAmount = claimTotalAmount;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(String billDetails) {
		this.billDetails = billDetails;
	}

	public String getClaimDocuments() {
		return claimDocuments;
	}

	public void setClaimDocuments(String claimDocuments) {
		this.claimDocuments = claimDocuments;
	}
	
	public String getClaimType()
	{
		return claimType;
	}
	
	public void setClaimType(String claimType)
	{
		this.claimType=claimType;
	}
	
	//calculating the remaining Amount
	
	public void setRemaining_amount(Long remaining_amount) {
		this.remaining_amount=this.claimTotalAmount-this.amountToClaim;
	}

}
