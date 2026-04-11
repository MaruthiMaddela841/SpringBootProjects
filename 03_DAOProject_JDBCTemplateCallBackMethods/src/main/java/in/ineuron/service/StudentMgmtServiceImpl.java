package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDTO;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public StudentDTO fetchStudentByNo(int sno) {
		//BeanUtils.copyProperties(bo,dto);
		StudentBO bo=dao.getStudentByNo(sno);
		StudentDTO dto= new StudentDTO();
		dto.setId(bo.getId());
		dto.setName(bo.getName());
		dto.setGrade(bo.getGrade());
		dto.setAge(bo.getAge());
		dto.setAddress(bo.getAddress());
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentByName(String name1, String name2) {
		List<StudentBO> bo=dao.fetchStudentByName(name1, name2);
		List<StudentDTO> dto=new ArrayList<StudentDTO>();
		bo.forEach(b->{
			StudentDTO studentDto=new StudentDTO();
			BeanUtils.copyProperties(b, studentDto);
			studentDto.setSrNo(dto.size()+1);
			dto.add(studentDto);
		});
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentByAddress(String add1, String add2, String add3) {
		List<StudentBO> bo=dao.fetchStudentByAddress(add1, add2, add3);
		List<StudentDTO> dto=new ArrayList<StudentDTO>();
		bo.forEach(b->{
			StudentDTO studentDto=new StudentDTO();
			BeanUtils.copyProperties(b, studentDto);
			studentDto.setSrNo(dto.size()+1);
			dto.add(studentDto);
		});
		return dto;
	}

	

}
