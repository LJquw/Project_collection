package cars;

import java.util.Scanner;
	
public class Car {
	private static final int brandId = 0;
	private static final int carTypeId = 0;
	private String type;
	private String vehicleld;//���ƺ�
	private String brand;//Ʒ��
	private int perRent;//�����
	
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

	public String getType() {//��ȡtype
		return type;
	}

	public void setType(String type) {//����type
		this.type = type;
	}
	
	public Car(){
		//car���޲ι��취
	}
	public Car(String vehicleld,String brand,int perRent,String type){
		//Car�Ĵ��ι��취
		this.vehicleld=vehicleld;
		this.brand=brand;
		this.perRent=perRent;
		this.type=type;
	}
	
	public float calRent(int days){//�������
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
	public void leaseOutFlow() {//�⳵����
		Scanner input = new Scanner(System.in);//�õ�һ����׼����������������һ���µĻ����������Ķ���
		System.out.print("��ѡ����Ҫ���޵���������:");
		int typeId = input.nextInt();		// ѡ����������
		System.out.println("1.����\t2.���");
		int carTypeId = 0;//�γ��ͺű��
		int brandId=0;//Ʒ�Ʊ��
		int days=0;//��������
		float price=0;//���
		switch (typeId) {
		case 1:			// ѡ����Ʒ��ʱ
			this.setBrand("����");
			System.out.print("��ѡ����Ҫ���޵Ľγ�Ʒ��:");
			brandId = input.nextInt();		// �����Ʒ�Ʊ��
			System.out.println("1.550i\t2.X6");
			
			System.out.print("��ѡ����Ҫ���޵Ľγ��ͺ�:");
			carTypeId = input.nextInt();
			System.out.print("��������Ҫ���޵�����:");
			days=input.nextInt();
				
			this.rentVehicleFlow(brandId, carTypeId);//����rentVehicleFlow�������з��䳵�ƺź͵õ��ó��������
			System.out.println("����������������ƺ���:"+getVehicleld());
			
			price=calRent(days);//����calRent�����������
			System.out.println("����Ҫ֧�������޷�����:"+price+"Ԫ��");
			
			break;
		case 2:
			this.setBrand("���");		// ѡ����Ʒ��ʱ
			System.out.print("��ѡ����Ҫ���޵Ľγ�Ʒ��:");
			brandId = input.nextInt();		// ��˵�Ʒ�Ʊ��
			System.out.println("1.������\t2.GL8");
			
			System.out.print("��ѡ����Ҫ���޵Ľγ��ͺ�:");
			carTypeId = input.nextInt();
			System.out.print("��������Ҫ���޵�����:");
			days=input.nextInt();
				
			this.rentVehicleFlow(brandId, carTypeId);
			System.out.println("����������������ƺ���:"+getVehicleld());
			
			price=calRent(days);
			System.out.println("����Ҫ֧�������޷�����:"+price+"Ԫ��");
			
			break;
		default:
			System.out.println("�Բ���û�д�Ʒ�ƵĽγ���");
	    }
	}
	public void rentVehicleFlow(int brandId, int cartypeId) {
		switch (brandId) {
		case 1:
			this.setBrand("����");		// ѡ����Ʒ��ʱ
			if (cartypeId == 1) {			// ���ѡ�����ͺ�550i
				this.setType("550i");
				this.setPerRent(600);
				this.setVehicleld("��CNY3284"); // ���ó��ƺ�
			} else if (cartypeId == 2) {			// ���ѡ�����ͺ�X6
				this.setType("X6");
				this.setPerRent(800);
				this.setVehicleld("��NY28588"); // ���ó��ƺ�
			} else
				System.out.println("�Բ���û�д��ͺŵĽγ���");
			break;
		case 2:
			this.setBrand("���");		// ѡ����Ʒ��ʱ
			if (cartypeId == 1) {			// ���ѡ�����ͺš���������
				this.setType("������");
				this.setPerRent(300);
				this.setVehicleld("��NT37465"); // ���ó��ƺ�
			} else if (cartypeId == 2) {	// ���ѡ�����ͺš�GL8��
				this.setType("GL8");
				this.setPerRent(600);
				this.setVehicleld("��NT96968");	// ���ó��ƺ�
			} else
				System.out.println("�Բ���û�д��ͺŵĽγ���");
			break;
		}
	}

}

