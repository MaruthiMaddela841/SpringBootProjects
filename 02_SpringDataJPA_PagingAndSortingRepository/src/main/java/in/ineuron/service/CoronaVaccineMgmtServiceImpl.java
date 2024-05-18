package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		System.out.println("Proxy Class Implementation Name is::" + repo.getClass().getName());
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntites = repo.findAll(sort);
		return listEntites;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsBypagination(int pageSize) {

		long count = repo.count();
		long pagesCount=count/pageSize;
		pagesCount=count%pageSize==0?pagesCount:++pagesCount;
		
		for(int i=0;i<pagesCount;i++) {
			Pageable pageable=PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page=repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
		}

	}

}
