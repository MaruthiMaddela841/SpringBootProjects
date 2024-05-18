package in.ineuron;

import java.util.ArrayList;
import java.util.List;

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
		
		//service.fetchDetailsByCompany("moderena").forEach(System.out::println);
		service.fetchVaccineByPriceLessThan(450.5).forEach(System.out::print);
		((ConfigurableApplicationContext) factory).close();
	}

}
