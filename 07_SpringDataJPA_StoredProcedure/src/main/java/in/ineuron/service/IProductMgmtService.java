package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.Product;

public interface IProductMgmtService {
	public List<Product> fetchProductsByName(String p1,String p2);
}
