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
		
//		CoronaVaccine vaccine=new CoronaVaccine("covishield","Serum","IND",750.8,2);
//		CoronaVaccine vaccine= new CoronaVaccine();
//		vaccine.setPrice(4500.5);
//		service.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
		
		
//		try{
//			CoronaVaccine vaccine=service.getVaccineById(3L);
//			System.out.println(vaccine);
//		}
//			
//		catch(DataAccessException e){
//			System.out.println("Record Not available...");
//		}
		
		List<Long> list= new ArrayList<Long>();
		list.add(8L);
		list.add(7L);
		list.add(9L);
		System.out.println(service.removeVaccinesByRegNo(list));
		
		((ConfigurableApplicationContext) factory).close();
	}

}
