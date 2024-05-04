package in.ineuron.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao {
	
	private static final String GET_STUDENT_BY_NO = "SELECT id,name,age,address,grade FROM students WHERE id=?";
	private static final String GET_STUDENT_BY_NAME = "SELECT id,name,age,address,grade FROM students WHERE name IN (?,?)";
	private static final String GET_STUDENT_BY_ADDRESS = "SELECT id,name,age,address,grade FROM students WHERE address IN (?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Override
//	public StudentBO getStudentByNo(int sno) {
//		StudentBO bo=null;
//		bo=jdbcTemplate.queryForObject(GET_STUDENT_BY_NO,new StudentMapper(), sno);
//		return bo;
//		
//	}
	
//	@Override
//	public StudentBO getStudentByNo(int sno) {
//		return jdbcTemplate.queryForObject(GET_STUDENT_BY_NO,(rs,num)->{
//			StudentBO bo=new StudentBO();
//			bo.setId(rs.getInt(1));
//			bo.setName(rs.getString(2));
//			bo.setAge(rs.getInt(3));
//			bo.setAddress(rs.getString(4));
//			bo.setGrade(rs.getString(5));
//			return bo;
//		}, sno);
//		
//	}
	
	@Override
	public StudentBO getStudentByNo(int sno) {

		return jdbcTemplate.queryForObject(GET_STUDENT_BY_NO,new BeanPropertyRowMapper<StudentBO>(StudentBO.class), sno);
		
	}
	
	private static class StudentMapper implements RowMapper<StudentBO>{

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBO bo=new StudentBO();
			bo.setId(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAge(rs.getInt(3));
			bo.setAddress(rs.getString(4));
			bo.setGrade(rs.getString(5));
			return bo;
		}
		
	}

	@Override
	public List<StudentBO> fetchStudentByName(String name1, String name2) {
		return jdbcTemplate.query(GET_STUDENT_BY_NAME,new RowMapper<StudentBO>() {
			@Override
			public StudentBO mapRow(ResultSet rs,int rowNum) throws SQLException{
				System.out.println("StudentDaoImpl.fetchStudentByName(...).new RowMapper() {...}.mapRow()");
				StudentBO bo=new StudentBO();
					bo.setId(rs.getInt(1));
					bo.setName(rs.getString(2));
					bo.setAge(rs.getInt(3));
					bo.setAddress(rs.getString(4));
					bo.setGrade(rs.getString(5));
				return bo;
			}
		}, name1,name2);
	}@Override
	public List<StudentBO> fetchStudentByAddress(String add1, String add2, String add3) {
		List<StudentBO> listBO= new ArrayList<StudentBO>();
		jdbcTemplate.query(GET_STUDENT_BY_ADDRESS,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException{
				System.out.println(
						"StudentDaoImpl.fetchStudentByAddress(...).new RowCallbackHandler() {...}.processRow()");
				StudentBO bo=new StudentBO();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setAddress(rs.getString(4));
				bo.setGrade(rs.getString(5));
				listBO.add(bo);
			}
		},add1,add2,add3);
		return listBO;
	}
	
	
	
//	@Override
//	public List<StudentBO> fetchStudentByAddress(String add1, String add2, String add3) {
//		return jdbcTemplate.query(GET_STUDENT_BY_ADDRESS,new RowMapperResultSetExtractor<StudentBO>
//		(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)),add1,add2,add3);
//	}

//	@Override
//	public List<StudentBO> fetchStudentByAddress(String add1, String add2, String add3) {
//		return jdbcTemplate.query(GET_STUDENT_BY_ADDRESS,new ResultSetExtractor<List<StudentBO>>() {
//			@Override
//			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				System.out.println(
//						"StudentDaoImpl.fetchStudentByAddress(...).new ResultSetExtractor() {...}.extractData()");
//				List<StudentBO> bo=null;
//				bo=new ArrayList<StudentBO>();
//				StudentBO stdBO=null;
//				while(rs.next()) {
//					stdBO=new StudentBO();
//					stdBO.setId(rs.getInt(1));
//					stdBO.setName(rs.getString(2));
//					stdBO.setAge(rs.getInt(3));
//					stdBO.setAddress(rs.getString(4));
//					stdBO.setGrade(rs.getString(5));
//					bo.add(stdBO);
//				}
//				return bo;
//			}
//		},add1,add2,add3);
//	}

}
