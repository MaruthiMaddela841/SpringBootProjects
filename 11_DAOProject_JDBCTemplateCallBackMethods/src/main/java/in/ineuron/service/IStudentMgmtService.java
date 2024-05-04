package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.StudentDTO;

public interface IStudentMgmtService {

	public StudentDTO fetchStudentByNo(int sno);
	public List<StudentDTO> fetchStudentByName(String name1,String name2);
	public List<StudentDTO> fetchStudentByAddress(String add1,String add2,String add3);
}
