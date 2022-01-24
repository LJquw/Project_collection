package gas;

public class Gas {

	private String name;
	private String region;
	private String gastype;
	private String deep;
	private double  reserves;
	
	public Gas() {
		
	}
	public Gas(String name, String region, String gastype,  String deep,  double  reserves) {
		this.deep=deep;
		this.gastype=gastype;
		this.name=name;
		this.region=region;
		this.reserves=reserves;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGastype() {
		return gastype;
	}
	public void setGastype(String gastype) {
		this.gastype = gastype;
	}
	public String getDeep() {
		return deep;
	}
	public void setDeep(String deep) {
		this.deep = deep;
	}
	public double getReserves() {
		return reserves;
	}
	public void setReserves(double reserves) {
		this.reserves = reserves;
	}
	

}
