package model;

public class RentCar {//�⳵
	private int id;               //�⳵���
	private String rentDate;      //�⳵ʱ��
	private String users;         //�⳵�û�
	private int carID;         //�⳵ID
	private float price;          //�⳵����
	
	public RentCar() {
	}
	public RentCar(int id,String rentDate,String users,float price,int carID) {
		this.id = id;
		this.rentDate = rentDate;
		this.users = users;
		this.carID = carID;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
