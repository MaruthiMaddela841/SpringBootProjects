package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	//@RequestMapping(value="/",method=RequestMethod.GET)
//	@RequestMapping
//	public String showHome() {
//		return	 "home";
//	}
	
//	@RequestMapping(value="/REPORT",method=RequestMethod.GET)
//	public String showReport(Map<String,Object> map) {
//		System.out.println("TestController.showReport()");
//		return "";
//	}
//	@PostMapping(value="/report")
//	//@RequestMapping(value="/report",method=RequestMethod.POST)
//	public String showReport(Map<String,Object> map) {
//		System.out.println("TestController.showReport()");
//		return "display";
//	}
//	@GetMapping(value="/report")
//	//@RequestMapping(value="/report",method=RequestMethod.GET)
//	public String showReport1(Map<String,Object> map) {
//		System.out.println("TestController.showReport1()");
//		
//		return "display1";
//	}
//	@GetMapping(value="/report")
//	//@GetMapping(value={"/report3","/report1","/report2"})
//	//@RequestMapping(value="/report",method=RequestMethod.GET)
//	public String showReport1(Map<String,Object> map) {
//		System.out.println("TestController.showReport1()");
//		//return "display1";
//		return "display";
//	}
	@GetMapping(value="/report")
	public String showReport1(Map<String,Object> map) {
		System.out.println("TestController.showReport1()");
		return "display1";
	}

}
