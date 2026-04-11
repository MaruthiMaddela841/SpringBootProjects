package in.ineuron.bo;

public class ProductBO {
	
	private Integer pid;
	private String pname;
	private Integer price;
	private Integer qty;
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ProductBO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}

}
