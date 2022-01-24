package model;

public class RepayCar {//还车
	private int id;                 //还车编号
	private String repayDate;       //还车时间
	private String users;           //还车用户
	private int carID;           //车辆ID
	private String state;           //还车状态
	
	public RepayCar() {
	}
	public RepayCar(int id,String repayDate,String users,String state,int carID) {
		this.id = id;
		this.repayDate = repayDate;
		this.users = users;
		this.carID = carID;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
