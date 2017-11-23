package com.example.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/index")
	public String index(Model model, HttpSession session) {
		model.addAttribute("name", "第一个应用： sessionID = " + session.getId());
		System.out.println("第一个应用： sessionID = " + session.getId());
		return "index";
	}
}
