package org.dta.alexendrie.repository;

import java.util.List;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Member;

public interface MemberRepository extends JpaRepository<Member>{
	
	List<Member> findMemberBy(String id,String nom);

}
