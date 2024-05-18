package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronavaccineMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		ICoronavaccineMgmtService service=factory.getBean(ICoronavaccineMgmtService.class);
		
//		CoronaVaccine vaccine=new CoronaVaccine(null, "covaxin", "Bharath-biotech", "IND", 234.0, 3);
//		CoronaVaccine vaccine=new CoronaVaccine(null, "covishield", "Serum", "IND", 750.0, 2);
//		System.out.println(service.registerVaccine(vaccine));
		
//		List<CoronaVaccine> vaccines= new ArrayList<CoronaVaccine>();
//		vaccines.add(new CoronaVaccine(null, "sputnik", "russie", "Russia", 567.0, 2));
//		vaccines.add(new CoronaVaccine(null, "pyzer", "pyzer", "USA", 678.5, 3));
//		vaccines.add(new CoronaVaccine(null, "moderena", "moderena", "USA", 455.7, 1));
//		Iterable<CoronaVaccine> listVaccines=service.registerInBatch(vaccines);
//		listVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		
//		System.out.println("Count is::"+service.getVaccineCount());
//		System.out.println("Checking Availability::"+service.checkAvailabilityByRegNo(3L));
		
//		Iterable<CoronaVaccine> vaccine=service.fetchAllDetails();
//		vaccine.forEach(System.out::println);
		
//		List<Long> ids=new ArrayList<Long>();
//		ids.add(1L);
//		ids.add(3L);
//		ids.add(2L);
//		ids.add(5L);
//		Iterable<CoronaVaccine> records=service.fetchAllDetailsById(ids);
//		records.forEach(System.out::println);
		
//		Optional<CoronaVaccine> vaccine=service.fetchVaccineById(6L);
//		if(vaccine.isPresent())
//			System.out.println(vaccine.get());
//		vaccine.orElseThrow(()->new IllegalArgumentException("Record not found..."));
		
//		System.out.println(service.removeVaccineById(5L));
//		

		
//		Optional<CoronaVaccine> vaccine=service.fetchVaccineById(5L);
//		if(vaccine.isPresent()) {
//			service.removeVaccineByObject(vaccine.get());
//		}
//		else {
//			System.out.println("Record not deleted with ID::"+vaccine.get().getRegNo());
//		}
		
		
//		List<Long> list=new ArrayList<Long>();
//		list.add(1L);
//		list.add(2L);
//		list.add(3L);
//		list.add(4L);
//		System.out.println(service.removeVaccinesById(list));
		
		
		((ConfigurableApplicationContext) factory).close();
	}

}
