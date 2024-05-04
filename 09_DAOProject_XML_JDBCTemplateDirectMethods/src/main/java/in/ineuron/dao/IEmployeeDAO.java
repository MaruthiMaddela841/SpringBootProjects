package in.ineuron.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {

	public int getEmpCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
	List<Map<String,Object>> getEmployeeDetailsByJob(String j1,String j2);
	public int insertEmp(String ename,String job,Integer salary);
	public int addBonusByJob(String job,int bonus);
}