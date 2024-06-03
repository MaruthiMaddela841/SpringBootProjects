package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.model.Employee;

@Controller
public class TestController {
	
	@GetMapping
	public String showHome() {
		return "home";
	}
	@GetMapping("/report")
	public String showReport(Map<String,Object> model) {
		model.put("name", "Kohli");
		model.put("age", 49);
		model.put("address", "RCB");
		String[] countries=new String[] {"India","USA","Russia","UK"};
		model.put("countries", countries);
		List<String> subjectsList=List.of("Java","JEE","Spring","SpringBoot","Hibernate");
		model.put("subjectsList", subjectsList);
		Set<Long> mobileNumbers=Set.of(7893220868L,7893220888L,9676589647L);
		model.put("mobileNumbers", mobileNumbers);
		Map<String,Long>  details=Map.of("Aadhar",1234L,"Voter",9834L,"PAN",33498L);
		model.put("details", details);
		List<Employee> employees=List.of(new Employee(1,"Maruthi","SE",30000.0),
				new Employee(2,"Reshma","SSE",80000.0),
				new Employee(3,"Pruthwi","AE",20000.0)
				);
		model.put("employees", employees);
		return "show_report";
	}

}
