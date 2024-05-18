package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private Logger logger=LoggerFactory.getLogger(Student.class);
	
	@Autowired(required=true)
	@Qualifier("courseId")
	private ICourse iCourse;
	
	static {
		System.out.println("Student .class file is loading...");
	}
	
	public Student() {
		System.out.println("Student zero param constrcutor...");
	}
	
	public void preparation(String examName) {
		logger.debug("Student==>preparation() entered...");
		System.out.println("Student.preparation()");
		System.out.println("Course chosen is::"+iCourse.getClass().getName());
		
		
		String courseContent=iCourse.courseContent();
		logger.info("Course content is chosen::"+courseContent);
		Float price=iCourse.price();
		logger.info("Course price is::"+price);
		System.out.println("Preparation content is ::{"+courseContent+"} with price ::"+price);
		System.out.println("Preparation is completed..");
		logger.debug("Control exiting from preparation()...");
	}

	@Override
	public String toString() {
		return "Student [iCourse=" + iCourse + "]";
	}

}
