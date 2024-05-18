package in.ineuron;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IProductMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		
		System.out.println("Factory::"+Arrays.toString(factory.getBeanDefinitionNames()));
		
		IProductMgmtService service=factory.getBean(IProductMgmtService.class);
		service.fetchProductsByName("fossil", "titan").forEach(System.out::println);;
		
		((ConfigurableApplicationContext) factory).close();
	}

}
