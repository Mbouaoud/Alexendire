package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Member;
import org.dta.alexendrie.repository.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl extends JpaRepositoryImpl<Member> implements MemberRepository{
	
	@Override
	protected Class<Member> getEntityClass() {
		return Member.class;
	}
}