package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController {
	
	@GetMapping("/service")
	public String displayQueryParam(@RequestParam("name") String str,Model model) {
		String str2=str.concat("! Welcome to iNeuron...");
		model.addAttribute("message",str2);
		return "index";
	}
	
	@GetMapping("/moreservice")
	public String displayMoreQueryParam(@RequestParam("name") String str,@RequestParam("age") int age,Model model) {
		String str2=str.concat("! Welcome to iNeuron...");
		model.addAttribute("message",str2);
		model.addAttribute("age",age);
		return "index";
	}

}
