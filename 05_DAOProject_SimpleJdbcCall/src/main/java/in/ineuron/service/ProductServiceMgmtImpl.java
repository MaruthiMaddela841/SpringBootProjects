package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.ProductBO;
import in.ineuron.dao.IProductDao;
import in.ineuron.dto.ProductDTO;

@Service
public class ProductServiceMgmtImpl implements IProductServiceMgmt{
	
	@Autowired
	private IProductDao dao;

	@Override
	public List<ProductDTO> getProductByNames(String s1, String s2) {
		List<ProductBO> productBO=dao.getProductByNames(s1, s2);
		List<ProductDTO> listDTO=new ArrayList<ProductDTO>();
		productBO.forEach(bo->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	

}
