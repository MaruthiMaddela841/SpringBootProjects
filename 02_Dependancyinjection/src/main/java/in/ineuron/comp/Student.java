package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired(required=true)
	@Qualifier("java")
	private ICourse iCourse;
	
	static {
		System.out.println("Student .class file is loading...");
	}
	
	public Student() {
		System.out.println("Student zero param constrcutor...");
	}
	
	public void preparation(String examName) {
		System.out.println("Student.preparation()");
		System.out.println("Course chosen is::"+iCourse.getClass().getName());
		String courseContent=iCourse.courseContent();
		Float price=iCourse.price();
		System.out.println("Preparation content is ::{"+courseContent+"} with price ::"+price);
	}

	@Override
	public String toString() {
		return "Student [iCourse=" + iCourse + "]";
	}

}
