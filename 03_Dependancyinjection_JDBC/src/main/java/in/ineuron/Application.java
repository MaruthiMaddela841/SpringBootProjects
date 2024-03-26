package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dao.IEmployeeDAO;
import in.ineuron.dao.IEmployeeDaoimpl;
import in.ineuron.model.Employee;

@SpringBootApplication
public class Application {
	
	static {
		System.out.println("Application .class file is loading...");
	}
	
	public Application() {
		System.out.println("Application zero param constrcutor...");
	}

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		System.out.println(context.getClass().getName());
		IEmployeeDAO dao=context.getBean(IEmployeeDaoimpl.class);
		try{
			List<Employee> employees=dao.findAllEmployees();
			employees.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}

}
