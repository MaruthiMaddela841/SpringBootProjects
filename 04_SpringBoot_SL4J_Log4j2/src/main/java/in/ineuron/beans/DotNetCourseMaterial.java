package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value="dotNet")
public class DotNetCourseMaterial implements ICourse {
	
	private Logger logger=LoggerFactory.getLogger(DotNetCourseMaterial.class);
	
	static {
		System.out.println("DotNetCourseMaterial .class file is loading...");
	}
	
	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial zero param constrcutor...");
	}

	@Override
	public String courseContent() {
		logger.debug("DotNetCourseMaterial==>courseContent() entered...");
		System.out.println("DotNetCourseMaterial.courseContent()");
		return "1. C# OOPS 2. C#Exceptionhandling";
	}

	@Override
	public Float price() {
		System.out.println("DotNetCourseMaterial.price()");
		return 300.0f;
	}

}
