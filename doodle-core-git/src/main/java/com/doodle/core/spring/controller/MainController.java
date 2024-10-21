package com.doodle.core.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doodle.core.spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String showStart() {
		return "final";
	}
	
	@RequestMapping("/profile")
	public String showProfile() {
		return "profile";
	}
	
	@RequestMapping("/image")
	public String showImage() {
		return "image_view";
	}
	
	@RequestMapping("/start/{id}")
	public String showStartWithId(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUser(id));
		return "start";
	}
	
	@RequestMapping("/loginPage")
	public String showLoginPage() {
		return "loginPage";
	}
	
	@RequestMapping("/sign_up")
	public String showSignUp() {
		return "sign_up";
	}
	
}
