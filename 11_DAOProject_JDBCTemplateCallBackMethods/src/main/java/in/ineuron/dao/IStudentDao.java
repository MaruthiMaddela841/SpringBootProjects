package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.StudentBO;
import in.ineuron.dto.StudentDTO;

public interface IStudentDao {
	
	public StudentBO getStudentByNo(int sno);
	public List<StudentBO> fetchStudentByName(String name1,String name2);
	public List<StudentBO> fetchStudentByAddress(String add1,String add2,String add3);

}
