package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import in.ineuron.service.ICoronavaccineMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		ICoronavaccineMgmtService service=factory.getBean(ICoronavaccineMgmtService.class);
		
//		service.fetchDetails(true, "price","name").forEach(System.out::println);;
//		service.fetchDetailsByPageNo(2, 3, true, "price","name")
//		.forEach((vaccine)->System.out.println(vaccine.getPrice()+"=="+vaccine.getCountry()));
		
		service.fetchDetailsBypagination(3);
		
		((ConfigurableApplicationContext) factory).close();
	}

}
