package in.ineuron;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.EmployeeMgmtServiceImpl;
import in.ineuron.service.IEmployeeManagementService;

public class JdbcTemplateDirectMethodTestApp 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(
    			"in/ineuron/cfg/applicationContext.xml");
    	IEmployeeManagementService service=applicationContext.getBean(EmployeeMgmtServiceImpl.class);
    try {
    	System.out.println(service.fetchEmpCount());
    	System.out.println(service.getEmployeeNameByNo(2));
    	Map<String,Object> map=service.getEmployeeDetailsByNo(1);
    	System.out.println(map);
    	service.getEmployeeDetailsByJob("SE", "QE").forEach(System.out::println);
    	int result=service.insertEmp("Anu", "QA", 24000);
    	if(result>0) {
    		System.out.println("Employee Inserted");
    	}
    	else {
    		System.out.println("Employee Not Inserted");
    	}
    	int updation=service.addBonusByJob("QE",12);
    	if(updation>0) {
    		System.out.println("Employee Updated");
    	}
    	else {
    		System.out.println("Employee Not Updated");
    	}
    }
    catch(Exception e) {
    	System.err.println(e.getMessage());
    }
    	applicationContext.close();
    }
}
