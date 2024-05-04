package in.ineuron;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IProductServiceMgmt;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SprongbootApplication.
		ApplicationContext context=SpringApplication.run(Application.class, args);
		IProductServiceMgmt service=context.getBean(IProductServiceMgmt.class);
		service.getProductByNames("fossil", "tissot").forEach(System.out::println);;
		((ConfigurableApplicationContext) context).close();
	}

}
