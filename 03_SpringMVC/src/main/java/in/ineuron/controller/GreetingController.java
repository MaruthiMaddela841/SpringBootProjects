package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String someWork(Model model) {
		model.addAttribute("message","Second Controller...");
		return "index";
	}
}
