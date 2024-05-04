package in.ineuron;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class JDBCApp {
	
	private static Logger logger=LoggerFactory.getLogger(JDBCApp.class);
	
	public static void main(String[] args) {
		logger.debug("Control entering main()...");
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.trace("Driver Loaded Successfully...");
			String url="jdbc:mysql://localhost:3306/jdbcsessions";
			String user="root";
			String password="Maru@841";
			connection=DriverManager.getConnection(url,user,password);
			logger.info("Connection established Successfully...");
			statement=connection.createStatement();
			logger.debug("Statement Object Created Successfully...");
			String SQL_SELECT_QUERY="SELECT * FROM employee";
			rs=statement.executeQuery(SQL_SELECT_QUERY);
			logger.info("Results object created by executing query...");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")+"\t"+rs.getInt("salary"));
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("ClassNotFoundException occured...");
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			logger.error("SQLException occured-->"+sqle.getMessage()+"-->"+sqle.getErrorCode());
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Unknown Exception occured...");
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
				logger.error("SQLException occured-->"+sqle.getMessage()+"-->"+sqle.getErrorCode());
			}
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
				logger.error("SQLException occured-->"+sqle.getMessage()+"-->"+sqle.getErrorCode());
			}
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
				logger.error("SQLException occured-->"+sqle.getMessage()+"-->"+sqle.getErrorCode());
			}
			
		}
		logger.trace("Control exiting main()...");
	}

}
