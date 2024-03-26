package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Employee;

@Repository("empDao")
public class IEmployeeDaoimpl implements IEmployeeDAO {
	
	private static final String SQL_SELECT_QUERY="SELECT * FROM employee";
	List<Employee> empList=null;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Employee> findAllEmployees() {
		System.out.println("DataSource Name::"+dataSource.getClass().getName());
		try(Connection connection=dataSource.getConnection();
				PreparedStatement ps=connection.prepareStatement(SQL_SELECT_QUERY);
				ResultSet rs=ps.executeQuery();){
			empList=new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEage(rs.getInt(3));
				emp.setEaddress(rs.getString(4));
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

}
