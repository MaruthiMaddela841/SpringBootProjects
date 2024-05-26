package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.MarriageSeeker;

public interface IMarriageSeekerRepo extends JpaRepository<MarriageSeeker, Long> {

}
