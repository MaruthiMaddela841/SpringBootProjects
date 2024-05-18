package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.binding.Books;

@Controller
public class BooksController {
	
	@GetMapping("/loadingform")
	public String loadingForm() {
		return "index";
	}
	@PostMapping("/save")
	public String afterSubmissionDisplay(Books bo,Model model) {
		model.addAttribute("bo",bo);
		return "books";
	}

}
