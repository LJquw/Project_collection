package gas;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;

public class Mgr {
	ArrayList<Gas> list = new ArrayList<Gas>();	
	/*创建两个天然气*/
	public void initial() {
		Gas gas1 = new Gas("苏里格","陕甘宁盆地","常规气","中浅层气",5336.52);
		Gas gas2 = new Gas("克深","塔里木盆地","非规气","深层气",2285.00);
		list.add(gas1);
		list.add(gas2);
	}
	public void startMenu() {
		System.out.println("欢迎使用天然气管理系统");
		System.out.println("***************************");
		System.out.println("1.增加气田");
		System.out.println("2.删除气田");
		System.out.println("3.查询");
		System.out.println("4.按照气藏类型汇总");
		System.out.println("5.按照埋深类型汇总");
		System.out.println("6.退出");
		System.out.println("***************************");
		System.out.print("请选择： ");	
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
			System.out.println("\n谢谢使用！");
			break;		
		}
	}//startMenu
	public void returnMain() {
		Scanner in = new Scanner (System.in);
		System.out.print("输入0返回: ");
		if(in.nextInt()==0) {
			startMenu();
		}else {
			System.out.println("输入错误，异常终止！");
		}
	}
	public void add() {
		Gas gas3 = new Gas();
		Scanner in= new Scanner (System.in);
		System.out.print("气田名：");
		String name3=in.next();
		gas3.setName(name3);
		System.out.print("气区：");
		String region3=in.next();
		gas3.setRegion(region3);
		System.out.print("气藏类型：");
		String type3 = in.next();
		gas3.setGastype(type3);
		System.out.print("埋深类型：");
		String deep3=in.next();
		gas3.setDeep(deep3);
		System.out.print("储量：");
		double re3 = in.nextDouble();
		gas3.setReserves(re3);
		
		list.add(gas3);
		returnMain();
	}
	public void delete() {
		Scanner in= new Scanner (System.in);
		System.out.print("请输入气田名：");
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
		System.out.print("请输入要查询的气区：");
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
		//得到list中所有不重复的气藏类型
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
		System.out.print("中国天然气储量");
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
		//得到list中所有不重复的气藏类型
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
		System.out.print("中国天然气储量");
		System.out.print("\n");
		for(double s : sum){
			System.out.print(s);
			System.out.print("\t");
		}
		System.out.print("\n");
		returnMain();
		
	}
	
}
