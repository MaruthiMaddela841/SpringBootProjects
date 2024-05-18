package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ProductServiceMgmtImpl implements IProductMgmtService {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Product> fetchProductsByName(String p1, String p2) {
		System.out.println("manager==>"+manager.getClass().getName());
		StoredProcedureQuery query=manager.createStoredProcedureQuery("SP_GET_PRODUCT_BY_NAME",Product.class);
		query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);
		query.setParameter(1, p1);
		query.setParameter(2, p2);
		List<Product> listProducts=query.getResultList();
		return listProducts;
	}

}
