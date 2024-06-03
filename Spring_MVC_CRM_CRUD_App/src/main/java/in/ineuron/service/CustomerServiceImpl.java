package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerDAO;
import in.ineuron.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDAO dao;

	@Override
	public List<Customer> getCustomers() {
		
		return (List<Customer>) dao.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		dao.save(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		Customer customer=new Customer();
		Optional<Customer> optional=dao.findById(customerId);
		return optional.get();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		dao.deleteById(customerId);
	}

}
