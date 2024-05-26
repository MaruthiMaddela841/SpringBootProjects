package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaMongoDbCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DaoSpringDataJpaMongoDbCrudAppApplication.class, args);
		
		ICustomerMgmtService service=context.getBean(ICustomerMgmtService.class);
		//System.out.println(service.registerCustomer(new CustomerDTO(18,"kohli",118.8f)));
		//service.findAllCustomers().forEach(System.out::println);
		//System.out.println(service.removeCustomer("6652ee5cc048176151861642"));
		//System.out.println(service.registerCustomer(new CustomerDTO(18,"Kohli",430.45f,"Bengaluru",3207826898L)));
		//System.out.println(service.updateCustomer(new CustomerDTO(18,"Kohli",500.8f,"Bangalore",3207826898L)));
		//service.fetchCustomerByBillAmt(10f,300f).forEach(System.out::println);;
		service.fetchCustomerByUsingAddressAndHavingmobileNo("SSP","Chennai").forEach(System.out::println);;
	}

}
