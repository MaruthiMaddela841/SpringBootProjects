package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepo repo;
	Customer document=null;

	@Override
	public String registerCustomer(CustomerDTO dto) {
		System.out.println("Proxy class name is::"+repo.getClass().getName());
		Customer document=new Customer();
		document.setCid(IdGenerator.generateID());
		//document.setCid("b67b04ddcd");
		BeanUtils.copyProperties(dto, document);
		//document=repo.insert(document);
		return "Document is saved/updated with ID::"+repo.save(document).getCid();
	}

	@Override
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
		Optional<Customer> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Document is deleted..";
		}
		else
			return "Document is not deleted..";
		
	}

	@Override
	public String updateCustomer(CustomerDTO dto) {
		System.out.println("Proxy class name is::"+repo.getClass().getName());
		document=new Customer();
		BeanUtils.copyProperties(dto, document);
		List<Customer> listCustomer=repo.findAll();
		listCustomer.forEach(cust->{
			if(cust.getCno()==dto.getCno()) {
				document.setCid(cust.getCid());
			}
		});
		return "Document is updated with ID::"+repo.save(document).getCid();
	}

	@Override
	public List<Customer> fetchCustomerByBillAmt(float min, float max) {
		return repo.findByBillAmtBetween(min, max);
	}

	@Override
	public List<Customer> fetchCustomerByUsingAddressAndHavingmobileNo(String... address) {
		
		return repo.findByCaddrInAndMobileNoIsNotNull(address);
	}

}
