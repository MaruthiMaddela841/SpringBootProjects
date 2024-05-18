package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronavaccineMgmtService {
	
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("In Memory Proxy class is::"+repo.getClass().getName());
		CoronaVaccine saveVaccine=null;
		if(vaccine!=null) {
			saveVaccine=repo.save(vaccine);
		}
		return saveVaccine!=null?"Vaccine registered successfully with "+saveVaccine.getRegNo():"Vaccine registration failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
			if(vaccines!=null)
				return repo.saveAll(vaccines);
			else
				throw new IllegalArgumentException("Batch Insertion not done...");
	}

	@Override
	public Long getVaccineCount() {
		return repo.count();
	}

	@Override
	public boolean checkAvailabilityByRegNo(Long regNo) {
		return repo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids) {
		
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long id) {
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Long id) {
		Optional<CoronaVaccine> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Record deleted with ID::"+id;
		}	else {
			return "Record not deleted with ID::"+id;
		}
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> optional=repo.findById(vaccine.getRegNo());
		if(optional.isPresent()) {
			repo.delete(vaccine);
			return "Record deleted with ID::"+vaccine.getRegNo();
		}
		else {
			return "Record not deleted with ID::"+vaccine.getRegNo();
		}
	}

	@Override
	public String removeVaccinesById(List<Long> ids) {
		Iterable<CoronaVaccine> listEntities = repo.findAllById(ids);
		if(ids.size()==((List) listEntities).size()) {
			repo.deleteAllById(ids);
			return "All records deleted";
		}
		return "Problem in deleting records..";
	}

}
