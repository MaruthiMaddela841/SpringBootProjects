package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="dotNet")
public class DotNetCourseMaterial implements ICourse {
	
	static {
		System.out.println("DotNetCourseMaterial .class file is loading...");
	}
	
	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial zero param constrcutor...");
	}

	@Override
	public String courseContent() {
		System.out.println("DotNetCourseMaterial.courseContent()");
		return "1. C# OOPS 2. C#Exceptionhandling";
	}

	@Override
	public Float price() {
		System.out.println("DotNetCourseMaterial.price()");
		return 300.0f;
	}

}
