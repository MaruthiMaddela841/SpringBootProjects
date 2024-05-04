package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.EmployeeBO;

public interface IEmployeeDao {
	public List<EmployeeBO> fetchEmployeeByJob(String j1,String j2);
	public String registerEmployee(EmployeeBO bo);
	public String fetchEmployeeByNo(int no);

}
