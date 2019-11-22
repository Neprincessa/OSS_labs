package ru.khudoyarova.spring.auth.controllers;


import ru.khudoyarova.spring.auth.entities.User;

import ru.khudoyarova.spring.auth.repos.UserRepo;
import ru.khudoyarova.spring.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UsersController
{
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String notes(Principal principal, Model model)
	{
		User user = (User) userService.loadUserByUsername(principal.getName());

		List<User> userList = userRepo.findAllByActiveTrue();
		model.addAttribute("list", userList);
		model.addAttribute("user", user);

		return "home";
	}
}
