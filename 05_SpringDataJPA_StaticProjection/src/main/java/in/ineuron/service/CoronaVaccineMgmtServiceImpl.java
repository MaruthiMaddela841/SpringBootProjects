package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.dao.ResultView;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronavaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<ResultView> searchVaccineByStartPrice(Double price) {
		System.out.println("InMemory::"+repo.getClass().getName());
		return repo.findByPriceGreaterThanEqualOrderByPrice(price);
	}

	
}
