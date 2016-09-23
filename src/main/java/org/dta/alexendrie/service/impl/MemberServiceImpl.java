package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.core.JpaRepository;
import java.util.List;
import org.dta.alexendrie.model.Member;
import org.dta.alexendrie.repository.MemberRepository;
import org.dta.alexendrie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired private MemberRepository memberRepository;

	@Override	
	public JpaRepository getRepository() {
		return memberRepository;
	}

	@Override
	public List<Member> getMemberAll() {
		return memberRepository.findAll();
	}

	@Override
	public List<Member> getMemberBy(String id, String nom) {
		return memberRepository.findMemberBy(id, nom);
	}

	@Override
	public Member getMemberById(long id) {
		return memberRepository.findOne(id);
	}
}