package in.ineuron.service;

import java.util.Optional;

import in.ineuron.bo.MarriageSeeker;


public interface IMatrimonyServiceMgmt {
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchSeekerId(Long i);
}
