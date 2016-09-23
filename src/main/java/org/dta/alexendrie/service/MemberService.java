package org.dta.alexendrie.service;

import java.util.List;

import org.dta.alexendrie.model.Member;

public interface MemberService {

	public List<Member> getMemberAll();
	public List<Member> getMemberBy(String id, String nom);

}
