package com.ssdut.book;

import java.util.Scanner;

public class BookMgr {
	BookSet book = new BookSet();//创建图书对象
	
	public void initial(){//初始化三个图书
		
		book.name[0] = "数据结构";
		book.state[0] = 0;
		book.date[0] = "2018-7-1";
		book.count[0] = 15;
		
		book.name[1] = "数据库";
		book.state[1] =1;
		book.count[1] = 12;
		
		book.name[2] = "离散数学";
		book.state[2] = 1;
		book.count[2] = 30;
	}
	
	public void startMenu() {
		System.out.println("欢迎使用图书借阅系统");
		System.out.println("-------------------------------------");
		System.out.println("0. 退     出");     
		System.out.println("1.借出排行榜");	 
		System.out.println("2.新增图书");
		System.out.println("3.查看图书");
		System.out.println("4.删除图书");
		System.out.println("5.借出图书");
		System.out.println("6.归还图书");
		System.out.print("--------------------------------------\n");
		
		System.out.println("请选择：");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
			case 0:	
				System.out.println("\n谢谢使用！");
				break;
			case 1:			
				list();
				break;
			case 2:
				add();
				break;
			case 3:
				search();
				break;
			case 4:
				delete();
				break;
			case 5:
				lend();
				break;
			case 6:
				returnbook();
				break;
		}	
	}
		public void returnMain() {
			Scanner input = new Scanner(System.in);
			System.out.println("输入 0 返回：");
			if(input.nextInt() == 0) {
				startMenu();
			}else {
				System.out.println("输入错误, 异常终止！");
			}
		}
		
		public void list() {
		
			String[] newname = new String[1000];
			int[] newcount = new int[1000];
			for(int k=0;k<book.name.length;k++) {
				newname[k] = book.name[k];
				newcount[k] = book.count[k];
			}
			
			for(int i=0;i<newname.length;i++){
				for(int j=i+1;j<newname.length;j++){
					if(newcount[i]>newcount[j]){
						int tempc=newcount[i];
						newcount[i]=newcount[j];
						newcount[j]=tempc;
						
						String tempn=newname[i];
						newname[i]=newname[j];
						newname[j]=tempn;
					}//end if
				}//for j
			}//for i
			
			System.out.println("---> 排行榜\n");
	    	System.out.println("**************************");
	    	System.out.println("次数\t名称");
	    	
	    	for(int i=newname.length-1;i>=0;i--) {
	    		if(newname[i] != null) {
	    			System.out.println(newcount[i]+"\t<<"+ newname[i]+ ">>" );
	    		}
	    	}
	    	System.out.println("**************************");
	    	returnMain();
		}
		
		private String getInputData() {
			Scanner input = new Scanner(System.in);
			String name = input.next();
			return name;
		}
		
		public void add() {
			
			System.out.println("---> 新增图书\n");    	
			System.out.print("请输入图书名称： ");
			String name = getInputData();
			
			for(int i = 0; i < book.name.length; i++){   		 
		   		 if(book.name[i] == null){    	
		    		
		   			book.name[i] = name;
		   			book.state[i] = 1;
		   			book.count[i] = 0;
					System.out.println("新增《"+name+"》成功！");
					break;
				 }
			 }
			System.out.println("**************************");
		   	returnMain();
		}
		
		public void search() {
			System.out.println("---> 查看图书\n");
	    	System.out.println("序号\t状 态\t名称\t\t借出日期");
	    	//TODO 遍历图书信息并按顺序输出,序号从1开始，如果图书未借出，则借出日期用"----"表示，状态字段用"借出"和"未借出"标识
	    	for(int i = 0; i < book.name.length; i++){   
				if(book.name[i] == null){	
					break;
				}
				else if(book.state[i] == 1){		
					System.out.println(i+1+"\t"+"未借出"+"\t"+book.name[i]+"\t\t"+"----");
				}
				else if(book.state[i] == 0){		
					System.out.println(i+1+"\t"+"借出"+"\t"+book.name[i]+"\t\t"+book.date[i]);
				}
			}
	    	returnMain();
		}
		
		public void delete() {
			System.out.println("---> 删除图书\n");
	    	System.out.print("请输入图书名称： ");
	        String name = getInputData();
	        
	        boolean flag = false;		//标识删除成功与否
			for(int i=0;i<book.name.length;i++) {
				if(book.name[i].equals(name) && book.state[i]==1){		
	      			int j=i;
	      			for(;j<book.name.length-1;j++) {
	      				book.name[j] = book.name[j+1];
	      				book.state[j] = book.state[j+1];
	      				book.date[j] = book.date[j+1];
	      				book.count[j] = book.count[j+1];
	      			}
	               
	                book.name[j]=null;
	                book.date[j]=null;
					System.out.println("删除《"+name+"》成功！");
	                flag=true;//置位，表示删除成功
	                break;
	      		}else if(book.name[i].equals(name) && book.state[i] == 0){		/*TODO 判断查询到的书籍已被借出*/
					System.out.println("《"+name+"》为借出状态，不能删除！"); 
	                flag=true;//置位
	                break;
	            }
			}
			if(!flag){
				System.out.println("没有找到匹配信息！");
	        }
			System.out.println("**************************");
	        returnMain();
		}
		
		public void lend() {
			System.out.println("---> 借出图书\n");
		   	Scanner input = new Scanner(System.in);
		   	System.out.print("请输入图书名称： ");
		   	String want = input.next();  //要借出的图书名称 
		   	System.out.print("请输入借出日期（年-月-日）：");
		   	String lendDate = input.next();  //借出日期
		   	
		   	for(int i = 0; i < book.name.length; i++){   		 
				 if(book.name[i] == null){    //无匹配
					 System.out.println("没有找到匹配信息！");
					 break;
				 }else if(book.name[i].equals(want) && book.state[i]==1){ 	 
					 book.state[i] = 0;
					 book.date[i] = lendDate;
					 book.count[i]++;
					 System.out.println("《"+want+"》可以借出！");
					 break;
				 }else if(book.name[i].equals(want) && book.state[i]==0){  
					 System.out.println("《"+want+"》已被借出！");
					 break;
				 }   		 
			 }

		   	System.out.println("**************************");
		   	returnMain();
		}
		
		public void returnbook() {
	        System.out.println("---> 归还图书\n");
	        Scanner input = new Scanner(System.in);
	        System.out.print("请输入图书名称： ");
	        String want = input.next();
	        System.out.print("请输入归还日期（年-月-日）：");
	        String redate = input.next();
	        //this.setCharge(0);
	        for (int i = 0; i < book.name.length; i++) {
	            if (book.name[i] == null) {    //无匹配
	                System.out.println("没有找到匹配信息！");
	                break;
				 }else if(book.name[i].equals(want) && book.state[i] == 0){  //找到匹配	 
	                /*补全归还操作 1.设置为未借出状态 2.计算租金*/
					book.state[i] = 1;
	                System.out.println("\n归还《" + want + "》成功!");
	                System.out.println("借出日期为：" + book.date[i]);
	                System.out.println("归还日期为：" + redate);
	               // System.out.println("应付租金（元）：" + charge(book.date[i],redate));
	                break;
				 }else if(book.name[i].equals(want) && book.state[i] == 1){ 		//找到匹配但没有借出  
	                System.out.println("该图书没有被借出！无法进行归还操作。");
	                break;
	            }
	        }

	        System.out.println("**************************");
	        returnMain();
	    }
}
