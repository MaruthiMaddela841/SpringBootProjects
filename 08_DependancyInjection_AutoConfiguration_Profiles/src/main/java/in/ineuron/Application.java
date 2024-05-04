package in.ineuron;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.controller.MainController;
import in.ineuron.vo.EmployeeVO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the size of the Array::");
		Integer size=sc.nextInt();
		String jobs[]=new String[size];
		for(int i=0;i<size;i++) {
			System.out.print("Enter the Job["+i+"]::");
			jobs[i]=sc.next();
		}
		
		ApplicationContext context=SpringApplication.run(Application.class, args);
		MainController controller=context.getBean(MainController.class);
		System.out.println(controller);
		List<EmployeeVO> employee=controller.getEmployee(jobs);
		employee.forEach(System.out::println);
		((AbstractApplicationContext) context).close();
	}

}
