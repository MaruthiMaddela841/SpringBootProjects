package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronavaccineMgmtService {
	
	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public Long getVaccineCount();
	public boolean checkAvailabilityByRegNo(Long regNo);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids);
	public Optional<CoronaVaccine> fetchVaccineById(Long id);
	public String removeVaccineById(Long id);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccinesById(List<Long> ids);

}
