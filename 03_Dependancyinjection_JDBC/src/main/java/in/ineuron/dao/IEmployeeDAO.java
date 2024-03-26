package in.ineuron.dao;

import java.util.List;

import in.ineuron.model.Employee;

public interface IEmployeeDAO {
	
	public List<Employee> findAllEmployees();

}
