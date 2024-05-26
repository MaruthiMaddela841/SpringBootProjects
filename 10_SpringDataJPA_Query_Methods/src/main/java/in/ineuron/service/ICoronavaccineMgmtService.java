package in.ineuron.service;

import java.util.Date;
import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronavaccineMgmtService {
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	public List<CoronaVaccine> fetchVaccinesByCompanies(String company1,String company2);
	public List<Object[]> fetchVaccinesByPriceRange(double min,double max);
	public List<CoronaVaccine> fetchVaccinesByNames(String name1,String name2);
	public int updatePriceByCountry(double newPrice,String country);
	public int deleteRecordByPrice(double min,double max);
	public int registerVaccine(String company,String name,String country,Double price,Integer required_dose_count);
	public Date fetchSystemDate();
}
