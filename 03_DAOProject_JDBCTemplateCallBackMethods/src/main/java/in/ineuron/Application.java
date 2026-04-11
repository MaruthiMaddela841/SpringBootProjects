package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		IStudentMgmtService service=context.getBean(IStudentMgmtService.class);
		StudentDTO dto=service.fetchStudentByNo(6);
		System.out.println(dto);
		List<StudentDTO> listDto=service.fetchStudentByName("reshu", "mj");
		listDto.forEach(System.out::println);
		List<StudentDTO> listDto2=service.fetchStudentByAddress("hnk", "uk","ssp");
		listDto2.forEach(System.out::println);
		((ConfigurableApplicationContext) context).close();
	}

}
