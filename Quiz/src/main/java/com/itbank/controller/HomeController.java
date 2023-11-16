package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.model.vo.AccountVO;
import com.itbank.service.AccountService;
@Controller
public class HomeController {
	@Autowired private AccountService as;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", as.getAccounts());
		
		return "home";
	}
}