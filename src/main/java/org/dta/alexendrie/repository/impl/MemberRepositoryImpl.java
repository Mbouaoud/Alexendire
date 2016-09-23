package org.dta.alexendrie.repository.impl;

import java.util.List;

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

	@Override
	public List<Member> findMemberBy(String id, String nom) {
		String str = "select m from Member m where ";
		boolean et = false;
		if(!(id.equals(""))){
			str = str + "cast(m.id as string) like '"+id+"%'";
			et = true;
		}
		if(!(nom.equals(""))){
			if (et){
				str = str+" and ";
			}
			str = str + "(lower(m.lastname) like '%"+nom.toLowerCase()+"%' or lower(m.firstname) like '%"+nom.toLowerCase()+"%')";
		}
		return findBy(str);
	}
}