package in.ineuron.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages= {"in.ineuron"})
public class AppConfig {
	
	static {
		System.out.println("AppConfig .class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig :: zero param constructor...");
	}

}
