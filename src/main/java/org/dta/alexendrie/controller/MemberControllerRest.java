package org.dta.alexendrie.controller;

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

	@RequestMapping(value = "/resource/member.accession", method = RequestMethod.GET)
	public Member rechercheMember(@RequestParam("id") long id) {
		return memberService.getMemberById(id);
	}

}
