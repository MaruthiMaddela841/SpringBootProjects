package in.ineuron.service;

import java.util.List;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmtService {
	
	public String registerCustomer(CustomerDTO dto);
	public List<Customer> findAllCustomers();
	public String removeCustomer(String id);
	public String updateCustomer(CustomerDTO dto);
	public List<Customer> fetchCustomerByBillAmt(float min,float max);
	public List<Customer> fetchCustomerByUsingAddressAndHavingmobileNo(String...address);
}
