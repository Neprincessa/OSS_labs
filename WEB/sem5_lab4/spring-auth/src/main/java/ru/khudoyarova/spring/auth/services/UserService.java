package ru.khudoyarova.spring.auth.services;

import ru.khudoyarova.spring.auth.entities.User;
import ru.khudoyarova.spring.auth.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User userFindByUsername = userRepo.findByUsername(username);
		User userFindByName = userRepo.findByName(username);

		if(userFindByUsername != null)
		{
			return userFindByUsername;
		}

		if(userFindByName != null)
		{
			return userFindByName;
		}

		return null;
	}
}

