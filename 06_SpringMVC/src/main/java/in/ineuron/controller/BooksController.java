package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController {
	
	@GetMapping(value="/book/{bname}/{authorName}")
	public String getBookDetails(@PathVariable("bname")String bname,@PathVariable("authorName") String authorName,Model model) {
		String message=authorName+" is the author of "+bname;
		model.addAttribute("message",message);
		return "index";
	}

}
