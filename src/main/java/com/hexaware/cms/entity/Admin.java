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
public class Admin {
	@Id
	@Column(name = "admin_id")
	private Long adminId;
	@Column(name = "admin_password")
	private String adminPass;
	
	public Admin() {
		
	}
	@OneToMany(fetch =FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name= "admin_id_fk",referencedColumnName="admin_id")
	private List<PlanDetails> plandetaillist =new ArrayList<>();	


	public List<PlanDetails> getPlandetaillist() {
		return plandetaillist;
	}

	public void setPlandetaillist(List<PlanDetails> plandetaillist) {
		this.plandetaillist = plandetaillist;
	}

	public Admin(Long adminId, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	

}
