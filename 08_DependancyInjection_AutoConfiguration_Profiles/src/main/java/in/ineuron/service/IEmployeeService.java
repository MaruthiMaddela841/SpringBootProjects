package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeService {
	
	public List<EmployeeDTO> getEmployeeByJob(String[] jobs);

}
