package model;

public class FixCar {//�޳�
	private int id;            //�޳����
	private String fixDate;    //�޳�ʱ��
	private String question;   //��������
	private float price;       //�޳�����
	private int carID;         //����ID
	
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
