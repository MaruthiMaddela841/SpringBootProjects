package in.ineuron.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
	
	private Integer eno;
	private String ename="sachin";
	private String edesg;
	private Double salary;

}
