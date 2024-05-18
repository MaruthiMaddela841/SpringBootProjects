package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronavaccineMgmtService {
	
	public Iterable<CoronaVaccine> fetchDetails(boolean asc,String...properties);
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc,String...properties);
	public void fetchDetailsBypagination(int pageSize);
}
