package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<EmployeeDTO> fetchEmployeeByJob(String j1, String j2) {
		List<EmployeeBO> employeeBO=dao.fetchEmployeeByJob(j1, j2);
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		employeeBO.forEach(b->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEmpno(b.getEmpno());
			dto.setEname(b.getEname());
			dto.setJob(b.getJob());
			dto.setSalary(b.getSalary());
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		String status=dao.registerEmployee(bo);
		return status;
	}

	@Override
	public String fetchEmployeeByNo(int no) {
		return dao.fetchEmployeeByNo(no);
	}

}
