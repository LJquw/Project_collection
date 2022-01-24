package model;

public class FixCar {//修车
	private int id;            //修车编号
	private String fixDate;    //修车时间
	private String question;   //车辆故障
	private float price;       //修车费用
	private int carID;         //车辆ID
	
	public FixCar() {
	}
	public FixCar(int id,String fixDate,String question,float price,int carID) {
		this.id = id;
		this.fixDate = fixDate;
		this.question = question;
		this.carID = carID;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFixDate() {
		return fixDate;
	}
	public void setFixDate(String fixDate) {
		this.fixDate = fixDate;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
