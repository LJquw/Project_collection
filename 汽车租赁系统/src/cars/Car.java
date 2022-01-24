package cars;

import java.util.Scanner;
	
public class Car {
	private static final int brandId = 0;
	private static final int carTypeId = 0;
	private String type;
	private String vehicleld;//车牌号
	private String brand;//品牌
	private int perRent;//日租金
	
	public String getVehicleld() {
		return vehicleld;
	}
	public void setVehicleld(String vehicleld) {
		this.vehicleld = vehicleld;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPerRent() {
		return perRent;
	}
	public void setPerRent(int perRent) {
		this.perRent = perRent;
	}

	public String getType() {//获取type
		return type;
	}

	public void setType(String type) {//设置type
		this.type = type;
	}
	
	public Car(){
		//car的无参构造法
	}
	public Car(String vehicleld,String brand,int perRent,String type){
		//Car的带参构造法
		this.vehicleld=vehicleld;
		this.brand=brand;
		this.perRent=perRent;
		this.type=type;
	}
	
	public float calRent(int days){//计算租金
		this.rentVehicleFlow(brandId, carTypeId);
		float price=this.getPerRent()*days;
		if(days>7 && days<=30){
			price *= 0.9;
		}else if(days>30 && days<=150){
			price *= 0.8;
		}else if(days>150){
			price *= 0.7;
		}
		return price;
	}
	public void leaseOutFlow() {//租车过程
		Scanner input = new Scanner(System.in);//得到一个标准的输入流，并创建一个新的基于输入流的对象
		System.out.print("请选择你要租赁的汽车类型:");
		int typeId = input.nextInt();		// 选择汽车类型
		System.out.println("1.宝马\t2.别克");
		int carTypeId = 0;//轿车型号编号
		int brandId=0;//品牌编号
		int days=0;//租用天数
		float price=0;//租金
		switch (typeId) {
		case 1:			// 选择宝马品牌时
			this.setBrand("宝马");
			System.out.print("请选择你要租赁的轿车品牌:");
			brandId = input.nextInt();		// 宝马的品牌编号
			System.out.println("1.550i\t2.X6");
			
			System.out.print("请选择你要租赁的轿车型号:");
			carTypeId = input.nextInt();
			System.out.print("请输入您要租赁的天数:");
			days=input.nextInt();
				
			this.rentVehicleFlow(brandId, carTypeId);//调用rentVehicleFlow方法进行分配车牌号和得到该车的日租金
			System.out.println("分配给您的汽车车牌号是:"+getVehicleld());
			
			price=calRent(days);//调用calRent方法计算租金
			System.out.println("您需要支付的租赁费用是:"+price+"元。");
			
			break;
		case 2:
			this.setBrand("别克");		// 选择别克品牌时
			System.out.print("请选择你要租赁的轿车品牌:");
			brandId = input.nextInt();		// 别克的品牌编号
			System.out.println("1.林荫大道\t2.GL8");
			
			System.out.print("请选择你要租赁的轿车型号:");
			carTypeId = input.nextInt();
			System.out.print("请输入您要租赁的天数:");
			days=input.nextInt();
				
			this.rentVehicleFlow(brandId, carTypeId);
			System.out.println("分配给您的汽车车牌号是:"+getVehicleld());
			
			price=calRent(days);
			System.out.println("您需要支付的租赁费用是:"+price+"元。");
			
			break;
		default:
			System.out.println("对不起，没有此品牌的轿车。");
	    }
	}
	public void rentVehicleFlow(int brandId, int cartypeId) {
		switch (brandId) {
		case 1:
			this.setBrand("宝马");		// 选择宝马品牌时
			if (cartypeId == 1) {			// 如果选择了型号550i
				this.setType("550i");
				this.setPerRent(600);
				this.setVehicleld("京CNY3284"); // 设置车牌号
			} else if (cartypeId == 2) {			// 如果选择了型号X6
				this.setType("X6");
				this.setPerRent(800);
				this.setVehicleld("京NY28588"); // 设置车牌号
			} else
				System.out.println("对不起，没有此型号的轿车！");
			break;
		case 2:
			this.setBrand("别克");		// 选择别克品牌时
			if (cartypeId == 1) {			// 如果选择了型号“林荫大道”
				this.setType("林荫大道");
				this.setPerRent(300);
				this.setVehicleld("京NT37465"); // 设置车牌号
			} else if (cartypeId == 2) {	// 如果选择了型号“GL8”
				this.setType("GL8");
				this.setPerRent(600);
				this.setVehicleld("京NT96968");	// 设置车牌号
			} else
				System.out.println("对不起，没有此型号的轿车！");
			break;
		}
	}

}

