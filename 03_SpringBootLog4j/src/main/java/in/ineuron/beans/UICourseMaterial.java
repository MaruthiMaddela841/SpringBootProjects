package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value="uiCourse")
public class UICourseMaterial implements ICourse {
	
	private Logger logger=LoggerFactory.getLogger(UICourseMaterial.class);
	
	static {
		System.out.println("UICourseMaterial .class file is loading...");
	}
	
	public UICourseMaterial() {
		System.out.println("UICourseMaterial zero param constrcutor...");
	}

	@Override
	public String courseContent() {
		logger.debug("UICourseMaterial==>courseContent() entered...");
		System.out.println("UICourseMaterial.courseContent()");
		return "1. HTML 2. CSS 3. JS";
	}

	@Override
	public Float price() {
		System.out.println("UICourseMaterial.price()");
		return 450.0f;
	}

}
