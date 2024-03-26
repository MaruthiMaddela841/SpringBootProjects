package in.ineuron;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.ineuron.comp.WishMessageGenerator;

@SpringBootApplication
public class Application {
	
	static {
		System.out.println("Application .class file is loading...");
	}
	
	public Application() {
		System.out.println("Application zero param constrcutor...");
	}
	
	@Bean
	public LocalDateTime createObj() {
		System.out.println("createObj()..");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		System.out.println(context.getClass().getName());
		WishMessageGenerator wmg=context.getBean(WishMessageGenerator.class);
		System.out.println(wmg);
		String result=wmg.greetUser("Maruthi");
		System.out.println(result);
		((ConfigurableApplicationContext) context).close();
	}

}
