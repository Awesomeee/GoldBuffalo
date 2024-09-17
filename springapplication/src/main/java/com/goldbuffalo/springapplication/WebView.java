package com.goldbuffalo.springapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebView {
	
	@GetMapping("/portalView")
	public String MainPortal() {
		//System.out.println("hello");
		return "portal";
	}
	
	@GetMapping("/layoutFlexbox")
	public String layoutFlexbox() {
		//System.out.println("hello");
		return "layout_flexbox.html";
	}
	
	@GetMapping("/basicHTMLStructure")
	public String basicHTMLStructure() {
		return "Exercise_basicHTMLStructure";
	}
	
	@GetMapping("/Contact")
	public String contact() {
		return "Exercise_HTMLForm";
	}
	
	@PostMapping(path = "/handleSubmit2")
	public String handleSubmit2(@ModelAttribute FormObject formObject, Model model) {
		model.addAttribute("name", formObject.getName());
		model.addAttribute("email", formObject.getEmail());
		model.addAttribute("password", formObject.getPassword());
		model.addAttribute("gender", formObject.isGender());
		model.addAttribute("hobbies", formObject.isHobbies());
		System.out.println(formObject.getName());
		System.out.println(formObject.getEmail());
		System.out.println(formObject.getPassword());
		System.out.println(formObject.isGender());
		System.out.println(formObject.isHobbies());
		return "formSuccess";
	}
	
	@GetMapping(path = "/exerciseListAndTable")
	public String exerciseListAndTable() {
		return "Exercise_HTMLListAndTable";
	}
	
	@GetMapping(path = "/exerciseSemanticHTML")
	public String exerciseSemanticHTML() {
		return "Exercise_semanticHTML";
	}
	
	@GetMapping(path = "/exerciseCssLayout")
	public String exerciseCssLayout() {
		return "Exercise_HTML_CSSLayout";
	}
	
	@GetMapping(path = "/exerciseCssSelector")
	public String exerciseCssSelector() {
		return "Exercise_CSSSelector";
	}
	
	@GetMapping("/Form1")
	public String getForm1() {
		return "Form1";
	}

}
