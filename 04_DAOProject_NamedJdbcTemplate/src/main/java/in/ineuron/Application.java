package in.ineuron;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		IEmployeeMgmtService service=context.getBean(IEmployeeMgmtService.class);
		System.out.println(service.fetchEmployeeByNo(1));
		List<EmployeeDTO> dto=service.fetchEmployeeByJob("SE", "QE");
		dto.forEach(System.out::println);
		
		EmployeeDTO empDTO=new EmployeeDTO();
		empDTO.setEname("IMC");
		empDTO.setJob("SSE");
		empDTO.setSalary(4500);
		String status=service.registerEmployee(empDTO);
		System.out.println(status);
		((ConfigurableApplicationContext) context).close();
	}

}
