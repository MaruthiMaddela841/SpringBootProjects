package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.ResultView;

public interface ICoronavaccineMgmtService {
	
		public List<ResultView> searchVaccineByStartPrice(Double price);
}
