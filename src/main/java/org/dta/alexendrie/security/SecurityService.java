package org.dta.alexendrie.security;

import java.util.ArrayList;
import java.util.List;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityService implements UserDetailsService{

	@Autowired
	private UsrRepository usrRepository;
	
	@Override
	public UserDetails loadUserByUsername(final String username) {
		Usr usr = usrRepository.findByLogin(username);
	
		if (usr != null) {
			List<GrantedAuthority> rules = this.getUserCredentials(usr);
	
			return new org.springframework.security.core.userdetails.User(usr.getLogin(), usr.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}
	
	public List<GrantedAuthority> getUserCredentials(Usr user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN_ROLE"));
		return authorities;
	}
}
