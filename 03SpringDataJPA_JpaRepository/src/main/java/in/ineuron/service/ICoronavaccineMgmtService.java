package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronavaccineMgmtService {
	
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine,boolean asc,String...properties);
	public CoronaVaccine getVaccineById(Long regId);
	public String removeVaccinesByRegNo(Iterable<Long> regNo);
}
