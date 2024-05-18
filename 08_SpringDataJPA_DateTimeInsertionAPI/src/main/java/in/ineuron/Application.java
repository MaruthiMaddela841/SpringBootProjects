package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmtService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		
		System.out.println("Factory::"+Arrays.toString(factory.getBeanDefinitionNames()));
		ICustomerMgmtService service=factory.getBean(ICustomerMgmtService.class);
		Customer customer=new Customer("dhoni","MI",LocalDateTime.of(1998,01,21,15,0,12),LocalTime.of(10, 40),LocalDate.now());
		System.out.println(service.registerCustomer(customer));
		service.getAllCustomers().forEach(System.out::println);
		((ConfigurableApplicationContext) factory).close();
	}

}
