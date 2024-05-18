package in.ineuron;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dao.ResultView;
import in.ineuron.service.ICoronavaccineMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		ICoronavaccineMgmtService service=factory.getBean(ICoronavaccineMgmtService.class);
		
		List<ResultView> listVaccines=service.searchVaccineByStartPrice(500.0);
		listVaccines.forEach(vaccine->{
			System.out.println("InMemory ListVaccines::"+vaccine.getClass().getName()+"==>"+Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			System.out.println(vaccine.getName()+"==>"+vaccine.getCountry());
		});
		
		((ConfigurableApplicationContext) factory).close();
	}

}
