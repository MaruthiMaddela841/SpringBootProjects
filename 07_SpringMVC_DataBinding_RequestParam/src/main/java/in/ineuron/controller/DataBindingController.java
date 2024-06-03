package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {
	
	@GetMapping("/data")
	public String bindData(Map<String,Object> model,
			@RequestParam("sno") Integer sno,
			@RequestParam("sname") String sname) {
		
		return "show_data";
	}
	
	@GetMapping("/data2")
	public String bindData2(Map<String,Object> model,
			@RequestParam Integer sno,
			@RequestParam(defaultValue = "Maruthi") String sname) {
		return "show_data";
	}
	
	@GetMapping("/data1")
	public String bindData1(Map<String,Object> model,
			@RequestParam Integer sno,
			@RequestParam(required=false) String sname) {
		
		return "show_data";
	}

}
