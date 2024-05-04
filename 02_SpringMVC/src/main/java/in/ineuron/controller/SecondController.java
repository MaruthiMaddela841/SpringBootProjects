package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {
	
	@GetMapping("/second")
	public String someWork(Model model) {
		model.addAttribute("message","Second Controller...");
		return "index";
	}
	
	@GetMapping
	public String someName(Model model) {
		model.addAttribute("message","Maruthi...");
		return "index";
	}
	
	@PostMapping
	public String someAddr(Model model) {
		model.addAttribute("message","Mancherial...");
		return "index";
	}

}
