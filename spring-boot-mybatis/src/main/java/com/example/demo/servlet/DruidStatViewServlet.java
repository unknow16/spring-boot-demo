package com.example.demo.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns={"/druid/*"},
		initParams={
				@WebInitParam(name="loginUsername", value="admin"),
				@WebInitParam(name="loginPassword", value="admin")
		})
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = -2137202861484925756L;

}
