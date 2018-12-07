package com.sys.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test")
	public String test() {
		System.out.println("12312321313");
		return "";
	}

}
