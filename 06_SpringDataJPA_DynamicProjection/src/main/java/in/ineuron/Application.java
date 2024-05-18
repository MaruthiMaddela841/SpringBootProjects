package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dao.ResultView1;
import in.ineuron.dao.ResultView2;
import in.ineuron.service.ICoronavaccineMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		ICoronavaccineMgmtService service=factory.getBean(ICoronavaccineMgmtService.class);
		
		service.searchVaccineByCompany("Serum",ResultView2.class).forEach(view->{
			System.out.println(view.getPrice()+"==>"+view.getCountry()+"==>"+view.getRegNo());
		});;
		
		service.searchVaccineByCompany("Serum",ResultView1.class).forEach(view->{
			System.out.println(view.getName()+"==>"+view.getCompany());
		});;
		
		((ConfigurableApplicationContext) factory).close();
	}

}
