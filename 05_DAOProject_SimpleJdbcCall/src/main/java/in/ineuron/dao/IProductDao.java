package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.ProductBO;

public interface IProductDao {
	
	public List<ProductBO> getProductByNames(String s1,String s2);

}
