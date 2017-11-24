package com.example.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserLogMapper;
import com.example.demo.domain.UserLog;

@Controller
@RequestMapping("/api")
public class WebController {

	@Autowired
	private UserLogMapper userLogMapper;
	
	@RequestMapping("/home")
	public String index(Model model, HttpSession session) {
		model.addAttribute("name", "第一个应用： sessionID = " + session.getId());
		System.out.println("第一个应用： sessionID = " + session.getId());
		UserLog ul = userLogMapper.selectByPrimaryKey(6);
		model.addAttribute("userLog", ul);
		return "index";
	}
}
