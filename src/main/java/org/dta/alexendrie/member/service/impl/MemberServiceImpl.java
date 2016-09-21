package org.dta.alexendrie.member.service.impl;

import org.dta.alexendrie.member.repository.MemberRepository;
import org.dta.alexendrie.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired private MemberRepository memberRepository;
}