package org.dta.alexendrie.service;

import org.dta.alexendrie.model.Member;
import java.util.List;

public interface MemberService extends GenericService<Member>{

	public List<Member> getMemberAll();
	public List<Member> getMemberBy(String id, String nom);
	public Member getMemberById(long id);
}