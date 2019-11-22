package ru.khudoyarova.spring.auth.controllers;

import org.hibernate.annotations.Parameter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import ru.khudoyarova.spring.auth.entities.Role;
import ru.khudoyarova.spring.auth.entities.User;
import ru.khudoyarova.spring.auth.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import java.util.Collections;

@Controller
public class RegistrationController
{
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/registration")
	public String registration(Model model)
	{
		model.addAttribute("error", "");
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(String name, String username, String password, Model model)
	{
		User userExists = userRepo.findByUsername(username);
		if (userExists != null){
			model.addAttribute("error", "This email already exists");
			return "registration";
		} else
		{
			User user = new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setActive(true);
			user.setRoles(Collections.singleton(Role.USER));

			userRepo.save(user);
			return "redirect:/login";
		}
	}
}