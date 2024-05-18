package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value="java")
public class JavaCourseMaterial implements ICourse {
	
	private Logger logger=LoggerFactory.getLogger(JavaCourseMaterial.class);
	
	static {
		System.out.println("JavaCourseMaterial .class file is loading...");
	}
	
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial zero param constrcutor...");
	}

	@Override
	public String courseContent() {
		logger.debug("JavaCourseMaterial==>courseContent() entered...");
		System.out.println("JavaCourseMaterial.courseContent()");
		return "1. OOPS 2. ExceptionHandling 3. Strings 4. Arrays";
	}

	@Override
	public Float price() {
		System.out.println("JavaCourseMaterial.price()");
		return 400.0f;
	}

}
