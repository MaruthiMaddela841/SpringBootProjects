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
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean asc, String... properties) {
		System.out.println("System Proxy is ::"+repo.getClass().getName());
		Example<CoronaVaccine> example=Example.of(vaccine);
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		List<CoronaVaccine> listEntities=repo.findAll(example, sort);
		return listEntities;
	}

	@Override
	public CoronaVaccine getVaccineById(Long regId) {
		CoronaVaccine vaccine=repo.getReferenceById(regId);
		return vaccine;
	}

	@Override
	public String removeVaccinesByRegNo(Iterable<Long> regNo) {
		List<CoronaVaccine> listEntities=repo.findAllById(regNo);
		if(listEntities.size()>0) {
			repo.deleteAllByIdInBatch(regNo);
			return listEntities.size()+":: No of records Deleted...";
		}
		else {
			return "Record not found for deletion";
		}
		
	}



}
