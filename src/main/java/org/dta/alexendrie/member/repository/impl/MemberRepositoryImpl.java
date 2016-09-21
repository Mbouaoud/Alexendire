package org.dta.alexendrie.member.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.member.model.Member;
import org.dta.alexendrie.member.repository.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl extends JpaRepositoryImpl<Member> implements MemberRepository{
	
	@Override
	protected Class<Member> getEntityClass() {
		return Member.class;
	}
}