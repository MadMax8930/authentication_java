package com.max.safetyalerts.auth.services;


import com.max.safetyalerts.model.Person;
import com.max.safetyalerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	PersonRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Person user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return UserDetailsImpl.build(user);
	}


}
