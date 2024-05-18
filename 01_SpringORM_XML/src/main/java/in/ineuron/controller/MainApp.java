package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.StaleStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentService;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService service=context.getBean(IStudentService.class);
		StudentDTO dto= new StudentDTO();
		String name=null;
		Integer age=null;
		String city=null;
		String country=null;
		Integer id=null;
		
		try {
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("****************************************************");
				System.out.println("1. INSERT");
				System.out.println("2. SELECT BY ID");
				System.out.println("3. SELECT ALL RECORDS");
				System.out.println("4. UPDATE");
				System.out.println("5. DELETE BY ID");
				System.out.println("6. DELETE BY BEAN");
				System.out.println("7. EXIT");
				System.out.println("Your Option::");
				Integer option =Integer.parseInt(br.readLine());
				
				switch(option) {
				case 1: 
					System.out.println("Enter Name::");
					name=br.readLine();
					System.out.println("Enter Age::");
					age=Integer.parseInt(br.readLine());
					System.out.println("Enter City::");
					city=br.readLine();
					System.out.println("Enter Country::");
					country=br.readLine();
					dto.setSname(name);
					dto.setSage(age);
					dto.setCity(city);
					dto.setCountry(country);
					int insertResult=service.insert(dto);
					System.out.println("Id of the record inserted::"+insertResult);
					break;
				case 2:
					System.out.println("Enter ID::");
					id=Integer.parseInt(br.readLine());
					dto=service.getStudent(id);
					if(dto!=null) {
						System.out.println("Record Info::"+dto);
					}
					else {
						System.out.println("Record not available for the given id..");
					}
					break;
				case 3:
					List<StudentDTO> students=service.getAllStudents();
					students.forEach(System.out::println);
					break;
				case 4:
					System.out.println("Enter ID::");
					id=Integer.parseInt(br.readLine());
					System.out.println("Enter Name::");
					name=br.readLine();
					System.out.println("Enter Age::");
					age=Integer.parseInt(br.readLine());
					System.out.println("Enter City::");
					city=br.readLine();
					System.out.println("Enter Country::");
					country=br.readLine();
					dto.setSid(id);
					dto.setSname(name);
					dto.setSage(age);
					dto.setCity(city);
					dto.setCountry(country);
					service.update(dto);
					break;
				case 5:
					System.out.println("Enter ID::");
					id=Integer.parseInt(br.readLine());
					service.delete(id);
					break;
				case 6:
					System.out.println("Enter ID::");
					id=Integer.parseInt(br.readLine());
					System.out.println("Enter Name::");
					name=br.readLine();
					System.out.println("Enter Age::");
					age=Integer.parseInt(br.readLine());
					System.out.println("Enter City::");
					city=br.readLine();
					System.out.println("Enter Country::");
					country=br.readLine();
					dto.setSid(id);
					dto.setSname(name);
					dto.setSage(age);
					dto.setCity(city);
					dto.setCountry(country);
					service.delete(dto);
					break;
				case 7:
					System.out.println("Thanks for using the application...");
					System.exit(0);
				default:
					System.out.println("Please enter valid option...");
					break;
				}
			}
		}
		catch(StaleStateException sse){
			System.out.println("Record not available for deletion with ID::"+id);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
		}
		catch(Exception e) {
			
		}
		finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

}
