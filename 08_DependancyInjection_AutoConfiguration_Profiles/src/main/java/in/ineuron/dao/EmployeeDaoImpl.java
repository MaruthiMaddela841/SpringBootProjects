package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository("empDao")
@Profile({"dev","test"})
public class EmployeeDaoImpl implements IEmployeeDao{
	
	
	
	private static String SQL_SELECT_QUERY = "Select * from employee where job in (";
	List<EmployeeBO> boList=new ArrayList<EmployeeBO>();
	
	@Autowired
	private DataSource datasource;
	
	static {
		System.out.println("EmployeeDaoImpl .class file is loading...");
	}
	
	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl :: zero param constructor...");
	}

	@Override
	public List<EmployeeBO> getEmpByJob(String[] jobs) {
		System.out.println("DataSource Class::"+datasource.getClass().getName());
		
		 String SQL_SELECT_QUERY = "SELECT empno, ename, job, salary FROM employee WHERE job IN (?, ?)";

		    try (Connection connection = datasource.getConnection();
		         PreparedStatement ps = connection.prepareStatement(SQL_SELECT_QUERY)) {
		        ps.setString(1, jobs[0]);
		        ps.setString(2, jobs[1]);

		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            EmployeeBO bo = new EmployeeBO();
		            bo.setEmpno(rs.getInt("empno"));
		            bo.setEname(rs.getString("ename"));
		            bo.setJob(rs.getString("job"));
		            bo.setSalary(rs.getInt("salary"));
		            boList.add(bo);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return boList;
	}

}
