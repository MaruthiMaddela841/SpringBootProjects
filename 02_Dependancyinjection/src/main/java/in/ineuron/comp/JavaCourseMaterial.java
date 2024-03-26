package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="java")
public class JavaCourseMaterial implements ICourse {
	
	static {
		System.out.println("JavaCourseMaterial .class file is loading...");
	}
	
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial zero param constrcutor...");
	}

	@Override
	public String courseContent() {
		System.out.println("JavaCourseMaterial.courseContent()");
		return "1. OOPS 2. ExceptionHandling 3. Strings 4. Arrays";
	}

	@Override
	public Float price() {
		System.out.println("JavaCourseMaterial.price()");
		return 400.0f;
	}

}
