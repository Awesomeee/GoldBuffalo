package com.goldbuffalo.springapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebView {
	
	@GetMapping("/portalView")
	public String MainPortal() {
		System.out.println("hello");
		return "portal";
	}

}
