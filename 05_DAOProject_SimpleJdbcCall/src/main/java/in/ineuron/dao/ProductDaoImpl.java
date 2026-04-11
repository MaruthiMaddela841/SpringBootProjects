package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.ProductBO;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	@Autowired
	private DataSource datasource;

	@Override
	public List<ProductBO> getProductByNames(String s1, String s2) {
		SimpleJdbcCall jdbc=new SimpleJdbcCall(datasource).withProcedureName("SP_GET_PRODUCT_BY_NAME")
		.returningResultSet("products", new BeanPropertyRowMapper<ProductBO>(ProductBO.class));
		Map<String,Object> out=jdbc.execute(Map.of("name1",s1,"name2",s2));
		List<ProductBO> listProducts=(List<ProductBO>) out.get("products");
		return listProducts;
	}

//	@Override
//	public List<ProductBO> getProductByNames(String s1, String s2) {
//		sjc.setProcedureName("SP_GET_PRODUCT_BY_NAME");
//		sjc.returningResultSet("products", new RowMapper<ProductBO>() {
//
//			@Override
//			public ProductBO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				ProductBO bo=new ProductBO();
//				bo.setPid(rs.getInt(1));
//				bo.setPname(rs.getString(2));
//				bo.setQty(rs.getInt(3));
//				bo.setPrice(rs.getInt(4));
//				return bo;
//			}
//		});
//		Map<String,Object> out=sjc.execute(Map.of("s1",s1,"s2",s2));
//		List<ProductBO> listProducts=(List<ProductBO>) out.get("products");
//		return listProducts;
//	}

}
