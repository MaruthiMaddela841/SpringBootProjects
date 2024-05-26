package in.ineuron.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.bo.CoronaVaccine;
import jakarta.transaction.Transactional;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	
	//@Query("FROM CoronaVaccine WHERE company=:comp")
	//public List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);
	//@Query("FROM CoronaVaccine WHERE company=?1")
	@Query("FROM CoronaVaccine WHERE company=:vendor")
	public List<CoronaVaccine> searchVaccinesByCompany(String vendor);
	
	@Query("FROM CoronaVaccine WHERE name IN (:name1,:name2)")
	public List<CoronaVaccine> searchVaccinesByNames(String name1,String name2);
	
	@Query("SELECT name,company,price FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public List<Object[]> searchVaccinesByPriceRange(double min, double max);
	
	@Query("FROM CoronaVaccine WHERE company IN (:comp1,:comp2)")
	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1,String comp2);
	
	@Modifying
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:country")
	public int updatePriceByCountry(double newPrice,String country);
	
	@Modifying
	@Transactional
	@Query("DELETE CoronaVaccine WHERE price BETWEEN :min AND :max")
	public int deleteVaccineByPrice(double min,double max);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO corona_vaccine(`company`,`name`,`country`,`price`,`required_dose_count`) values(?,?,?,?,?)",nativeQuery=true)
	public int insertVaccine(String company,String name,String country,Double price,Integer required_dose_count);
	
	@Query(value="SELECT NOW() FROM DUAL",nativeQuery=true)
	public Date getSystemDate();
}
