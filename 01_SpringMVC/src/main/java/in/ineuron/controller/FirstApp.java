package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstApp {
	
	@RequestMapping("/welcome")
	public ModelAndView displayMsg() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Welcome to First Application...");
		mv.setViewName("index");
		return mv;
	}
	
	//recommended
	@GetMapping("/java")
	public String display(Model model) {
		model.addAttribute("message","Spring Boot is awesome...");
		return "index";
	}

}
