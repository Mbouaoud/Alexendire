package org.dta.alexendrie.controller;

import java.util.List;

import org.dta.alexendrie.model.Member;
import org.dta.alexendrie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberControllerRest {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member_recherche", method=RequestMethod.GET)
	public List<Member> rechercheMember(@RequestParam("id") String id, @RequestParam("nom") String nom){
		List<Member> member= null;
		if(id.equals("") && nom.equals("")){
			member = memberService.getMemberAll();
		} else {
			member = memberService.getMemberBy(id, nom);
		}
		return member;		
	}

	@RequestMapping(value = "/resource/member.accession", method = RequestMethod.GET)
	public Member rechercheMember(@RequestParam("id") long id) {
		return memberService.getMemberById(id);
	}

}

