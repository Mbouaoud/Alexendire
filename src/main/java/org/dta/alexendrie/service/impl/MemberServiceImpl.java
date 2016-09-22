package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.repository.MemberRepository;
import org.dta.alexendrie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired private MemberRepository memberRepository;
}