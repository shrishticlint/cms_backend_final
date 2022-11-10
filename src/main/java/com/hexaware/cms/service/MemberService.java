package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.cms.entity.Member;

public interface MemberService {
	public List<Member> findAllMembers();
	public Optional<Member> findMemberById(Long memberId);
	public void deleteMemberById(Long memberId);
	public Member saveMember(Member member);
	public Member updateMember(Member member);
	public List<Member> findByMemberName(String memberName);

}
