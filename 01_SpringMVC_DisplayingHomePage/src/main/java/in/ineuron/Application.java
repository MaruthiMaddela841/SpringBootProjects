package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		ApplicationContext context=SpringApplication.run(Application.class, args);
//		System.out.println("Container name is::"+context.getClass().getName());
//		
//		((ConfigurableApplicationContext) context).close();
	}

}
