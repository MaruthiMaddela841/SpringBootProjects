package in.ineuron.generator;

import java.util.UUID;

public class IdGenerator {
	
	public static String generateID() {
		System.out.println("IdGenerator.generateID()");
		return UUID.randomUUID().toString().replace("-","").substring(0,10);
	}

}
