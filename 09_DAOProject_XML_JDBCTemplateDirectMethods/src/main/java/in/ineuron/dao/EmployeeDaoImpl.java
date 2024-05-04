package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements IEmployeeDAO {
	
	private static final String SQL_SELECT_QUERY = "SELECT count(*) FROM employee";
	private static final String SQL_SELECT_QUERY_BY_ID = "SELECT ename FROM employee WHERE empno=?";
	private static final String SQL_SELECT_QUERY_MAP = "SELECT empno,ename,job,salary FROM employee WHERE empno=?";
	private static final String SQL_SELECT_QUERY_LIST = "SELECT empno,ename,job,salary FROM employee WHERE job IN (?,?) ORDER BY salary" ;
	private static final String SQL_INSERT_QUERY = "INSERT INTO employee(ename, job, salary) VALUES (?,?,?);";
	private static final String SQL_ADD_BONUS = "UPDATE employee set salary=salary+? where job=?;";
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public int getEmpCount() {
		return jdbcTemplate.queryForObject(SQL_SELECT_QUERY,Integer.class);
	}



	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return jdbcTemplate.queryForObject(SQL_SELECT_QUERY_BY_ID,String.class,eno);
	}



	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return jdbcTemplate.queryForMap(SQL_SELECT_QUERY_MAP,eno);
	}



	@Override
	public List<Map<String, Object>> getEmployeeDetailsByJob(String j1, String j2) {
		return jdbcTemplate.queryForList(SQL_SELECT_QUERY_LIST,j1,j2);
	}



	@Override
	public int insertEmp(String ename, String job, Integer salary) {
		return jdbcTemplate.update(SQL_INSERT_QUERY,ename,job,salary);
	}



	@Override
	public int addBonusByJob(String job, int bonus) {
		return jdbcTemplate.update(SQL_ADD_BONUS,bonus,job);
	}

}
