package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.View;

public interface ICoronavaccineMgmtService {
	
		public <T extends View> List<T> searchVaccineByCompany(String company,Class<T> clazz);
}
