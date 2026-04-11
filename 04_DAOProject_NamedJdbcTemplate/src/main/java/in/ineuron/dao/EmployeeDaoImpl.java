package in.ineuron.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	
	private static final String GET_EMPLOYEE_BY_NO = "SELECT ename FROM employee WHERE empno=:no";
	private static final String GET_EMPLOYEE_BY_JOB = "SELECT empno,ename,job,salary FROM employee WHERE job IN (:j1,:j2)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO employee(ename,job,salary)VALUES(:ename,:job,:salary)";
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<EmployeeBO> fetchEmployeeByJob(String j1, String j2) {
		MapSqlParameterSource map= new MapSqlParameterSource();
		map.addValue("j1", j1);
		map.addValue("j2", j2);
		return template.query(GET_EMPLOYEE_BY_JOB,map,
				//lambda expression of ResultSetExtractor ->extractData(ResultSet rs)
				rs->{
			List<EmployeeBO> listBO=new ArrayList<EmployeeBO>();
			while(rs.next()) {
				EmployeeBO bo= new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				listBO.add(bo);
			}
			return listBO;
		});
	}

	@Override
	public String registerEmployee(EmployeeBO bo) {
		BeanPropertySqlParameterSource map= new BeanPropertySqlParameterSource(bo);
		int result=template.update(INSERT_EMPLOYEE, map);
		if(result==1)
			return "Inserted Successfully";
		else
			return "Inserted Unsuccessfully";
	}

	@Override
	public String fetchEmployeeByNo(int no) {
		Map<String,Integer> map=Map.of("no",no);
		return template.queryForObject(GET_EMPLOYEE_BY_NO,map, String.class);
	}

}