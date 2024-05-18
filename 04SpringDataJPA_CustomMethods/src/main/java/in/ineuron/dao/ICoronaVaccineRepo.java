package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	
	public List<CoronaVaccine> findByCompany(String company);
//	public List<CoronaVaccine> findByCompanyEquals(String company);
//	public List<CoronaVaccine> findByCompanyIs(String company);
	public List<CoronaVaccine> findByPriceLessThan(Double price);
}
