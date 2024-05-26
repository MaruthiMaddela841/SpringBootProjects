package in.ineuron;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.service.IMatrimonyServiceMgmt;


@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext factory=SpringApplication.run(Application.class, args);
		IMatrimonyServiceMgmt service=factory.getBean(IMatrimonyServiceMgmt.class);
		
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Enter the Name::");
//		String name=sc.next();
//		
//		System.out.println("Enter the address::");
//		String address=sc.next();
//		
//		System.out.println("Enter the Photo Path::");
//		String photoPath=sc.next();
//		
//		System.out.println("Enter the BioData Path::");
//		String bioDataPath=sc.next();
//		
//		System.out.println("Enter Indian or not::");
//		Boolean indianOrNot=sc.nextBoolean();
//		
//		InputStream fis= new FileInputStream(photoPath);
//		byte[] photoData=new byte[fis.available()];
//		fis.read(photoData);
//		
//		File file= new File(bioDataPath);
//		Reader reader=new FileReader(file);
//		char[] bioDataContent = new char[(int)file.length()];
//		reader.read(bioDataContent);
//		
//		MarriageSeeker seeker= new MarriageSeeker(name, address, photoData, LocalDateTime.of(1993, 1,3,20,15), bioDataContent, indianOrNot);
//		System.out.println(service.registerMarriageSeeker(seeker));
//		fis.close();
//		reader.close();
//		sc.close();
		
		Optional<MarriageSeeker> optional=service.searchSeekerId(1L);
		if(optional.isPresent()) {
			MarriageSeeker seeker=optional.get();
			System.out.println(seeker);
			
			OutputStream os= new FileOutputStream("pic_db.jpg");
			os.write(seeker.getPhoto());
			os.flush();
			
			Writer writer=new FileWriter("test_db.txt");
			writer.write(seeker.getBioData());
			writer.flush();
			
			os.close();
			writer.close();
		}
		else {
			System.out.println("Record Not Available");
		}
		
		((ConfigurableApplicationContext) factory).close();
	}

}
