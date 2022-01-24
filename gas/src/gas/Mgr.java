package gas;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;

public class Mgr {
	ArrayList<Gas> list = new ArrayList<Gas>();	
	/*����������Ȼ��*/
	public void initial() {
		Gas gas1 = new Gas("�����","�¸������","������","��ǳ����",5336.52);
		Gas gas2 = new Gas("����","����ľ���","�ǹ���","�����",2285.00);
		list.add(gas1);
		list.add(gas2);
	}
	public void startMenu() {
		System.out.println("��ӭʹ����Ȼ������ϵͳ");
		System.out.println("***************************");
		System.out.println("1.��������");
		System.out.println("2.ɾ������");
		System.out.println("3.��ѯ");
		System.out.println("4.�����������ͻ���");
		System.out.println("5.�����������ͻ���");
		System.out.println("6.�˳�");
		System.out.println("***************************");
		System.out.print("��ѡ�� ");	
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		switch(choice) {
		case 1 :
			add();
			break;
		case 2 :
			delete();
			break;
		case 3 :
			search();
			break;
		case 4 :
			typesum();
			break;
		case 5 :
			deepsum();
			break;
		case 6 :
			System.out.println("\nллʹ�ã�");
			break;		
		}
	}//startMenu
	public void returnMain() {
		Scanner in = new Scanner (System.in);
		System.out.print("����0����: ");
		if(in.nextInt()==0) {
			startMenu();
		}else {
			System.out.println("��������쳣��ֹ��");
		}
	}
	public void add() {
		Gas gas3 = new Gas();
		Scanner in= new Scanner (System.in);
		System.out.print("��������");
		String name3=in.next();
		gas3.setName(name3);
		System.out.print("������");
		String region3=in.next();
		gas3.setRegion(region3);
		System.out.print("�������ͣ�");
		String type3 = in.next();
		gas3.setGastype(type3);
		System.out.print("�������ͣ�");
		String deep3=in.next();
		gas3.setDeep(deep3);
		System.out.print("������");
		double re3 = in.nextDouble();
		gas3.setReserves(re3);
		
		list.add(gas3);
		returnMain();
	}
	public void delete() {
		Scanner in= new Scanner (System.in);
		System.out.print("��������������");
		String name = in.next();
		Iterator<Gas> itor = list.iterator();
		while(itor.hasNext()) {
			Gas iter=itor.next();
			if(name.equals(iter.getName())) {
				itor.remove();
			}
		}
		returnMain();
	}
	public void search() {
		Scanner in= new Scanner (System.in);
		System.out.print("������Ҫ��ѯ��������");
		String region = in.next();
		Iterator<Gas> itor = list.iterator();
		while(itor.hasNext()) {
			Gas iter=itor.next();
			if(region.equals(iter.getRegion())) {
				System.out.print(iter.getName()+"   "+iter.getGastype()+"   "+iter.getDeep()+"   "+iter.getReserves()
			);
			}
		}
		returnMain();
	}
	public ArrayList<String> notsame(ArrayList<String> list){
		ArrayList<String> newlist=new ArrayList<String>();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String iter=it.next();
			if(!newlist.contains(iter)) {
				newlist.add(iter);
			}
		}
		return newlist;
	}
	public void typesum() {
		ArrayList<String> typelist = new ArrayList<String>();
		Iterator<Gas> itor = list.iterator();
		while(itor.hasNext()) {
			Gas iter=itor.next();
			typelist.add(iter.getGastype());
		}
		//�õ�list�����в��ظ�����������
		ArrayList<String> newtypelist = notsame(typelist); 
		double[] sum = new double[newtypelist.size()+1];
		for(int i = 0; i<newtypelist.size()+1; i++) {
			sum[i]=0;
		}
		
		for(int i = 0; i<newtypelist.size();i++) {
			Iterator<Gas> it = list.iterator();
			while(it.hasNext()) {
				Gas it1=it.next();	
				if(newtypelist.get(i).equals(it1.getGastype())) {
					sum[i]+=it1.getReserves();
				}
				
			}
		}	
		for(int i = 0; i<newtypelist.size();i++) {
			sum[newtypelist.size()]+=sum[i];
		}
		for(String s : newtypelist){
			System.out.print(s);
			System.out.print("\t");
		}
		System.out.print("�й���Ȼ������");
		System.out.print("\n");
		for(double s : sum){
			System.out.print(s);
			System.out.print("\t");
		}
		System.out.print("\n");
		returnMain();
	}
	public void deepsum() {
		ArrayList<String> deeplist = new ArrayList<String>();
		Iterator<Gas> itor = list.iterator();
		while(itor.hasNext()) {
			Gas iter=itor.next();
			deeplist.add(iter.getDeep());
		}
		//�õ�list�����в��ظ�����������
		ArrayList<String> newdeeplist = notsame(deeplist); 
		double[] sum = new double[newdeeplist.size()+1];
		for(int i = 0; i<newdeeplist.size()+1; i++) {
			sum[i]=0;
		}
		
		for(int i = 0; i<newdeeplist.size();i++) {
			Iterator<Gas> it = list.iterator();
			while(it.hasNext()) {
				Gas it1=it.next();	
				if(newdeeplist.get(i).equals(it1.getDeep())) {
					sum[i]+=it1.getReserves();
				}
				
			}
		}	
		for(int i = 0; i<newdeeplist.size();i++) {
			sum[newdeeplist.size()]+=sum[i];
		}
		for(String s : newdeeplist){
			System.out.print(s);
			System.out.print("\t");
		}
		System.out.print("�й���Ȼ������");
		System.out.print("\n");
		for(double s : sum){
			System.out.print(s);
			System.out.print("\t");
		}
		System.out.print("\n");
		returnMain();
		
	}
	
}
