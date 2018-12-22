package com.sys.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("")
	public String test() {
		return "index";
	}

	@RequestMapping("/goto/**")
	public String test2(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (Pattern.matches("/goto[/]{0,1}", uri)) {
			return "/html/index.html";
		}
		return "/html/" + uri.substring(6) + ".html";
	}

	@ResponseBody
	@GetMapping("test3")
	public void test3() throws Exception {
		List<String> str = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			str.add("" + Math.random());
			Thread.sleep(100);
		}
	}
}
