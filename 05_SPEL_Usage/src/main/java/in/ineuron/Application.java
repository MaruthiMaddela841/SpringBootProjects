package in.ineuron;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.BillGenerator;

@SpringBootApplication
public class Application {
	
	static {
		System.out.println("Application .class file is loading...");
	}
	
	public Application() {
		System.out.println("Application zero param constrcutor...");
	}

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		System.out.println(context.getClass().getName());
		BillGenerator billGenerator=context.getBean(BillGenerator.class);
		System.out.println(billGenerator);
		
		((ConfigurableApplicationContext) context).close();
	}

}
