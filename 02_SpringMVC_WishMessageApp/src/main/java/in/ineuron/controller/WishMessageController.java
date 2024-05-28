package in.ineuron.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.ineuron.service.IWIshMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private IWIshMessageService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
//	@RequestMapping(value="/wish",method=RequestMethod.GET)
//	public ModelAndView showWishMessage() {
//		String msg=service.generateWishMessage();
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("msg",msg);
//		mav.setViewName("display");
//		return mav;
//	}
	
//	@RequestMapping(value="/wish",method=RequestMethod.GET)
//	public String showWishMessage(Model model) {
//		String msg=service.generateWishMessage();
//		System.out.println("Implementation class name is::"+model.getClass().getName());
//		model.addAttribute("msg",msg);
//		return "display";
//	}
	
//	@RequestMapping(value="/wish",method=RequestMethod.GET)
//	public String showWishMessage(Map<String,Object> model) {
//		String msg=service.generateWishMessage();
//		System.out.println("Implementation class name is::"+model.getClass().getName());
//		model.put("msg",msg);
//		return "display";
//	}
	
//	@RequestMapping(value="/wish",method=RequestMethod.GET)
//	public void showWishMessage(Map<String,Object> model) {
//		String msg=service.generateWishMessage();
//		System.out.println("Implementation class name is::"+model.getClass().getName());
//		model.put("msg",msg);
//	}
	
//	@RequestMapping(value="/wish",method=RequestMethod.GET)
//	public void showWishMessage(HttpServletResponse response) throws IOException {
//		String msg=service.generateWishMessage();
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("<b>WishMessage is::"+msg+"</b>");
//	}
	
	@RequestMapping(value="/wish",method=RequestMethod.GET)
	public Map<String,Object> showWishMessage(){
		String msg=service.generateWishMessage();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("msg", msg);
		
		return map;
	}
}
