package in.ineuron.bo;

public class StudentBO {
	
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private String grade;
	
	
	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "StudentBO [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", grade=" + grade
				+ "]";
	}
	
	

}
