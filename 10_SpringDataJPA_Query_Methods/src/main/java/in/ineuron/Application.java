package in.ineuron;

import java.util.Date;

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
		
		//service.fetchVaccinesByCompany("Bharath-biotech").forEach(System.out::println);
		//service.fetchVaccinesByCompanies("Serum", "russie").forEach(System.out::println);
		//service.fetchVaccinesByNames("covishield", "german").forEach(System.out::println);
//		List<Object[]> objects=service.fetchVaccinesByPriceRange(400, 500);
//		for(Object[] object:objects) {
//			for(Object obj:object) {
//				System.out.print(obj+" ");
//			}
//			System.out.println();
//		}
		
//		System.out.println("No of records updated is::"+service.updatePriceByCountry(500.50, "IND"));
//		System.out.println("No of records deleted is::"+service.deleteRecordByPrice(400.0, 460.0));
		System.out.println("No of records inserted is::"+service.registerVaccine("Sputnik", "Russie", "Russia", 450.05, 2));
//		Date date=service.fetchSystemDate();
//		System.out.println(date);
		
		((ConfigurableApplicationContext) factory).close();
	}

}
