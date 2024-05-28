package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/demo")
public class DemoController {
	
	@Autowired
	private ServletContext  sc;
	@Autowired
	private ServletConfig cg;
	@Autowired
	private HttpSession ses;
	
//	@GetMapping(value="/report")
//	public String showReport1(Map<String,Object> map) {
//		System.out.println("DemoController.showReport1()");
//		return "display1";
//	}
	
	@GetMapping(value="/report")
	public String showReport1(Map<String,Object> map) {
		System.out.println("DemoController.showReport1()");
		System.out.println("WebApp name is::"+sc.getContextPath());
		System.out.println("DS Logical Name is::"+cg.getServletName());
		System.out.println("Session Id is::"+ses.getId());
		return "display1";
	}

}
