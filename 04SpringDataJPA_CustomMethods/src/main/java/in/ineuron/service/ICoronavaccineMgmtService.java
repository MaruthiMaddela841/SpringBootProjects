package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronavaccineMgmtService {
	
	public List<CoronaVaccine> fetchDetailsByCompany(String company);
	public List<CoronaVaccine> fetchVaccineByPriceLessThan(Double price);
}
