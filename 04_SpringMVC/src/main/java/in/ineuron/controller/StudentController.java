package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/studentInfo")
	public String getStudentInfo(Model model) {
		Student std=new Student();
		std.setSid(1);
		std.setFirstName("Maruthi");
		std.setLastName("Maddela");
		std.setGender("Male");
		std.setCity("Mancherial");
		model.addAttribute("std",std);
		return "student";
	}

}
