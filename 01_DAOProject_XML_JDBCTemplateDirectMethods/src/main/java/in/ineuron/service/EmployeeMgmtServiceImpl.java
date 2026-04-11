package in.ineuron.service;

import java.util.List;
import java.util.Map;

import in.ineuron.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeManagementService {
	
	private IEmployeeDAO dao;
	

	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public int fetchEmpCount() {
		System.out.println("DAO name is::"+dao.getClass().getName());
		return dao.getEmpCount();
	}


	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return dao.getEmployeeNameByNo(eno);
	}


	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}


	@Override
	public List<Map<String, Object>> getEmployeeDetailsByJob(String j1, String j2) {
		return dao.getEmployeeDetailsByJob(j1, j2);
	}


	@Override
	public int insertEmp(String ename, String job, Integer salary) {
		return dao.insertEmp(ename, job, salary);
	}


	@Override
	public int addBonusByJob(String job, int bonus) {
		return dao.addBonusByJob(job, bonus);
	}
	
	

}
