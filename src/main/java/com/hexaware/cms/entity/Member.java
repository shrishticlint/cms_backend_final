package com.hexaware.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;
	@Column(name = "member_password")
	private String memberPass;
	@Column(name = "member_name")
	private String memberName;
	@Column(name = "member_email")
	private String memberEmail;
	@Column(name = "member_contactnumber")
	private String memberContact;
	@Column(name = "member_address")
	private String memberAddress;
	@Column(name = "member_dob")
	private String memberDOB;
	
	
	@OneToMany(fetch =FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name= "member_id_fk",referencedColumnName="member_id")
	private List<PlanDetails> planDetails =new ArrayList<>();
	

//	public List<ClaimDetails> getClaimDetails() {
//		return claimDetails;
//	}
//
//	public void setClaimDetails(List<ClaimDetails> claimDetails) {
//		this.claimDetails = claimDetails;
//	}

	public List<PlanDetails> getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(List<PlanDetails> planDetails) {
		this.planDetails = planDetails;
	}

	public Member() {
		
	}

	public Member(Long memberId, String memberPass, String memberName, String memberEmail, String memberContact,
			String memberAddress, String memberDOB) {
		super();
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberContact = memberContact;
		this.memberAddress = memberAddress;
		this.memberDOB = memberDOB;
	}

	public Member(String memberPass, String memberName, String memberEmail, String memberContact, String memberAddress,
			String memberDOB) {
		super();
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberContact = memberContact;
		this.memberAddress = memberAddress;
		this.memberDOB = memberDOB;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberContact() {
		return memberContact;
	}

	public void setMemberContact(String memberContact) {
		this.memberContact = memberContact;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberDOB() {
		return memberDOB;
	}

	public void setMemberDOB(String memberDOB) {
		this.memberDOB = memberDOB;
	}	

}
