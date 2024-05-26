package in.ineuron.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import jakarta.transaction.Transactional;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronavaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		
		return repo.searchVaccinesByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String company1, String company2) {
		return repo.searchVaccinesByCompanies(company1, company2);
	}

	@Override
	public List<Object[]> fetchVaccinesByPriceRange(double min, double max) {
		return repo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNames(String name1, String name2) {
		return repo.searchVaccinesByNames(name1, name2);
	}

	@Override
	@Transactional
	public int updatePriceByCountry(double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}

	@Override
	public int deleteRecordByPrice(double min, double max) {
		return repo.deleteVaccineByPrice(min, max);
	}

	@Override
	public int registerVaccine(String company, String name, String country, Double price, Integer required_dose_count) {
		return repo.insertVaccine(company, name, country, price, required_dose_count);
	}

	@Override
	public Date fetchSystemDate() {
		return repo.getSystemDate();
	}



	
}
