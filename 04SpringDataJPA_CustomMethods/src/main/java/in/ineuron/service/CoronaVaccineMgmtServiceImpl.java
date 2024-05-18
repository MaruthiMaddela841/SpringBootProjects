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

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronavaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchDetailsByCompany(String company) {
		List<CoronaVaccine> listEntities=repo.findByCompany(company);
		return listEntities;
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPriceLessThan(Double price) {
		List<CoronaVaccine> listEntities=repo.findByPriceLessThan(price);
		return listEntities;
	}

}
