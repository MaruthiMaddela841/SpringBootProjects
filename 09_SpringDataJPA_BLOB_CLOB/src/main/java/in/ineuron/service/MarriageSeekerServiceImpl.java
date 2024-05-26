package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.dao.IMarriageSeekerRepo;

@Service("service")
public class MarriageSeekerServiceImpl implements IMatrimonyServiceMgmt {
	
	@Autowired
	private IMarriageSeekerRepo repo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "MarriageSeeker is saved with ID::"+repo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerId(Long id) {
		return repo.findById(id);
	}

}
