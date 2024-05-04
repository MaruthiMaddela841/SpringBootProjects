package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	static {
		System.out.println("MainController .class file is loading...");
	}
	
	public MainController() {
		System.out.println("MainController :: zero param constructor...");
	}
	
	@Autowired
	private IEmployeeService service;
	
	
	
	public List<EmployeeVO> getEmployee(String[] jobs){
		List<EmployeeDTO> list=service.getEmployeeByJob(jobs);
		List<EmployeeVO> empVo=new ArrayList<EmployeeVO>();
		list.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setEmpno(String.valueOf(dto.getEmpno()));
			vo.setEname(String.valueOf(dto.getEname()));
			vo.setJob(String.valueOf(dto.getJob()));
			vo.setSalary(String.valueOf(dto.getSalary()));
			empVo.add(vo);
		});
		return empVo;
	}

}
