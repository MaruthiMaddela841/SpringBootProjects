package in.ineuron.dto;

public class StudentDTO {

	private Integer sid;
	private String city;
	private String country;
	private Integer sage;
	private String sname;
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "StudentDTO [sid=" + sid + ", city=" + city + ", country=" + country + ", sage=" + sage + ", sname=" + sname
				+ "]";
	}
	

}
