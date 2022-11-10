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
import com.hexaware.cms.entity.Member;
import com.hexaware.cms.entity.PlanDetails;
import com.hexaware.cms.service.MemberService;

import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ClaimManagementSystem")
public class MemberController {
	@Autowired
	MemberService memberService;
	@CrossOrigin(origins = "*")
	@GetMapping("/getallmembers")
	public List<Member> getAllMembers(){
		return memberService.findAllMembers();
	}
	
	@GetMapping("/getmemberdetailsbymembername/{membername}")
	List<Member> getClaimdetailsByMemberName(
			@ApiParam (value="returns the member details with member name",required = true)
			@PathVariable("membername") String memberName){
		return memberService.findByMemberName(memberName);
	}
	
	@PostMapping("/addmember")
	public String saveMember(@RequestBody Member member) {
		return memberService.saveMember(member) + "member added Successfully";
	}
	
	@DeleteMapping("/deletemember/{memberid}")
	public String deleteMember(@PathVariable("memberid") Long memberId) {
		 memberService.deleteMemberById(memberId);
		 return "ClaimDetails Deleted Successfully";
	}
	
	@GetMapping("/getmember/{memberid}")
	public Optional<Member> getMember(@PathVariable("memberid") Long memberId) {
		return memberService.findMemberById(memberId);
	}
	
	@PutMapping("/updatemember/{memberid}")
	
	public String Update(@RequestBody Member memberDetails,@PathVariable("memberid") Long memberId) throws Exception {
		
		Member existingMemberDetail =  memberService.findMemberById(memberId).
				orElseThrow(() -> new Exception("memberDetails not found with id" + memberId));
//		existingMemberDetail.setMemberId(memberDetails.getMemberId());
		existingMemberDetail.setMemberName(memberDetails.getMemberName());
		existingMemberDetail.setMemberEmail(memberDetails.getMemberEmail());
		existingMemberDetail.setMemberAddress(memberDetails.getMemberAddress());
		existingMemberDetail.setMemberContact(memberDetails.getMemberContact());
		existingMemberDetail.setMemberPass(memberDetails.getMemberPass());
		
		return memberService.updateMember(existingMemberDetail) + " member updated successfully";
	}
	

}
