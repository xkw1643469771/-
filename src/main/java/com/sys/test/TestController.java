package com.sys.test;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public String test() {
		return "/html/index.html";
	}

	@RequestMapping("/goto/**")
	public String test2(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (Pattern.matches("/goto[/]{0,1}", uri)) {
			return "/html/index.html";
		}
		return "/html/" + uri.substring(6) + ".html";
	}
}
