package in.ineuron.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int insert(StudentBO s) {
		int result=(int) hibernateTemplate.save(s);
		return result;
	}

	@Override
	public void delete(int id) {
		
		StudentBO bo=hibernateTemplate.get(StudentBO.class, id);
		if(bo!=null) {
			hibernateTemplate.delete(bo);	
			System.out.println("Record deleted Successfully with ID::"+id);
		}
		else {
			System.out.println("Record not available for deletion with ID::"+id);
		}
	}

	@Override
	public void delete(StudentBO s) {
		
		StudentBO bo=hibernateTemplate.get(StudentBO.class, s.getSid());
		if(bo!=null) {
			hibernateTemplate.delete(bo);	
			System.out.println("Record deleted Successfully with ID::"+s.getSid());
		}
		else {
			System.out.println("Record not available for deletion with ID::"+s.getSid());
		}
	}

	@Override
	public void update(StudentBO s) {
		
		hibernateTemplate.update(s);
		System.out.println("Record Updated/Inserted Successfully..");
		}

	@Override
	public StudentBO getStudent(int id) {
		StudentBO bo=hibernateTemplate.get(StudentBO.class,id);
		return bo;
	}

	@Override
	public List<StudentBO> getAllStudents() {
		List<StudentBO> bo=hibernateTemplate.loadAll(StudentBO.class);
		return bo;
	}

	@Override
	public String toString() {
		return "StudentDaoImpl [hibernateTemplate=" + hibernateTemplate + "]";
	}
	
	

}
