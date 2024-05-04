package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	
	public List<EmployeeDTO> fetchEmployeeByJob(String j1,String j2);
	public String registerEmployee(EmployeeDTO dto);
	public String fetchEmployeeByNo(int no);

}
