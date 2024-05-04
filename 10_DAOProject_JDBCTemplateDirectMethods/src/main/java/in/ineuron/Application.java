package in.ineuron;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IEmployeeManagementService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		IEmployeeManagementService service=context.getBean(IEmployeeManagementService.class);
		System.out.println(service.fetchEmpCount());
    	System.out.println(service.getEmployeeNameByNo(2));
    	Map<String,Object> map=service.getEmployeeDetailsByNo(1);
    	System.out.println(map);
    	service.getEmployeeDetailsByJob("SE", "QE").forEach(System.out::println);
    	int result=service.insertEmp("Ramya", "QE", 24000);
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
		((ConfigurableApplicationContext) context).close();
	}

}
