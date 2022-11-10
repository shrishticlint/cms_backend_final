package com.hexaware.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cms.entity.Member;
import com.hexaware.cms.repository.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepo;

	@Override
	public List<Member> findAllMembers() {
		return memberRepo.findAll();
	}

	@Override
	public Optional<Member> findMemberById(Long memberId) {		
		return memberRepo.findById(memberId);
	}

	@Override
	public void deleteMemberById(Long memberId) {
		memberRepo.deleteById(memberId);
		
	}

	@Override
	public Member saveMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepo.save(member);
	}

	@Override
	public Member updateMember(Member member) {
		return memberRepo.save(member);
	}

	@Override
	public List<Member> findByMemberName(String memberName) {
		// TODO Auto-generated method stub
		return memberRepo.findByMemberName(memberName);
	}

}
