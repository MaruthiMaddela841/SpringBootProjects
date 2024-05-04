package in.ineuron.service;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Component("empService")
public class IEmployeeServiceImpl implements IEmployeeService{
	
	static {
		System.out.println("IEmployeeServiceImpl .class file is loading...");
	}
	
	public IEmployeeServiceImpl() {
		System.out.println("IEmployeeServiceImpl :: zero param constructor...");
	}
	
	@Autowired
	private IEmployeeDao empDao;

	@Override
	public List<EmployeeDTO> getEmployeeByJob(String[] jobs) {
		List<EmployeeBO> bolist=empDao.getEmpByJob(jobs);
		List<EmployeeDTO> dtoList=new ArrayList<EmployeeDTO>();
		bolist.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEmpno(bo.getEmpno());
			dto.setEname(bo.getEname());
			dto.setJob(bo.getJob());
			dto.setSalary(bo.getSalary());
			dtoList.add(dto);
		});
		return dtoList;
	}

}
