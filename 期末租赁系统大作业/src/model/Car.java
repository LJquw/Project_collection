package model;

public class Car {//车辆信息
	private int id;         //车辆编号
	private String name;    //车辆名称
	private String color;   //车辆颜色
	private String type;    //车辆类型
	private float price;    //车辆价格
	
	public Car() {
	}
	public Car(int id,String name,String color,String type,float price) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.type = type;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
