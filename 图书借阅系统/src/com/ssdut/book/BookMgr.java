package com.ssdut.book;

import java.util.Scanner;

public class BookMgr {
	BookSet book = new BookSet();//����ͼ�����
	
	public void initial(){//��ʼ������ͼ��
		
		book.name[0] = "���ݽṹ";
		book.state[0] = 0;
		book.date[0] = "2018-7-1";
		book.count[0] = 15;
		
		book.name[1] = "���ݿ�";
		book.state[1] =1;
		book.count[1] = 12;
		
		book.name[2] = "��ɢ��ѧ";
		book.state[2] = 1;
		book.count[2] = 30;
	}
	
	public void startMenu() {
		System.out.println("��ӭʹ��ͼ�����ϵͳ");
		System.out.println("-------------------------------------");
		System.out.println("0. ��     ��");     
		System.out.println("1.������а�");	 
		System.out.println("2.����ͼ��");
		System.out.println("3.�鿴ͼ��");
		System.out.println("4.ɾ��ͼ��");
		System.out.println("5.���ͼ��");
		System.out.println("6.�黹ͼ��");
		System.out.print("--------------------------------------\n");
		
		System.out.println("��ѡ��");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
			case 0:	
				System.out.println("\nллʹ�ã�");
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
			System.out.println("���� 0 ���أ�");
			if(input.nextInt() == 0) {
				startMenu();
			}else {
				System.out.println("�������, �쳣��ֹ��");
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
			
			System.out.println("---> ���а�\n");
	    	System.out.println("**************************");
	    	System.out.println("����\t����");
	    	
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
			
			System.out.println("---> ����ͼ��\n");    	
			System.out.print("������ͼ�����ƣ� ");
			String name = getInputData();
			
			for(int i = 0; i < book.name.length; i++){   		 
		   		 if(book.name[i] == null){    	
		    		
		   			book.name[i] = name;
		   			book.state[i] = 1;
		   			book.count[i] = 0;
					System.out.println("������"+name+"���ɹ���");
					break;
				 }
			 }
			System.out.println("**************************");
		   	returnMain();
		}
		
		public void search() {
			System.out.println("---> �鿴ͼ��\n");
	    	System.out.println("���\t״ ̬\t����\t\t�������");
	    	//TODO ����ͼ����Ϣ����˳�����,��Ŵ�1��ʼ�����ͼ��δ���������������"----"��ʾ��״̬�ֶ���"���"��"δ���"��ʶ
	    	for(int i = 0; i < book.name.length; i++){   
				if(book.name[i] == null){	
					break;
				}
				else if(book.state[i] == 1){		
					System.out.println(i+1+"\t"+"δ���"+"\t"+book.name[i]+"\t\t"+"----");
				}
				else if(book.state[i] == 0){		
					System.out.println(i+1+"\t"+"���"+"\t"+book.name[i]+"\t\t"+book.date[i]);
				}
			}
	    	returnMain();
		}
		
		public void delete() {
			System.out.println("---> ɾ��ͼ��\n");
	    	System.out.print("������ͼ�����ƣ� ");
	        String name = getInputData();
	        
	        boolean flag = false;		//��ʶɾ���ɹ����
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
					System.out.println("ɾ����"+name+"���ɹ���");
	                flag=true;//��λ����ʾɾ���ɹ�
	                break;
	      		}else if(book.name[i].equals(name) && book.state[i] == 0){		/*TODO �жϲ�ѯ�����鼮�ѱ����*/
					System.out.println("��"+name+"��Ϊ���״̬������ɾ����"); 
	                flag=true;//��λ
	                break;
	            }
			}
			if(!flag){
				System.out.println("û���ҵ�ƥ����Ϣ��");
	        }
			System.out.println("**************************");
	        returnMain();
		}
		
		public void lend() {
			System.out.println("---> ���ͼ��\n");
		   	Scanner input = new Scanner(System.in);
		   	System.out.print("������ͼ�����ƣ� ");
		   	String want = input.next();  //Ҫ�����ͼ������ 
		   	System.out.print("�����������ڣ���-��-�գ���");
		   	String lendDate = input.next();  //�������
		   	
		   	for(int i = 0; i < book.name.length; i++){   		 
				 if(book.name[i] == null){    //��ƥ��
					 System.out.println("û���ҵ�ƥ����Ϣ��");
					 break;
				 }else if(book.name[i].equals(want) && book.state[i]==1){ 	 
					 book.state[i] = 0;
					 book.date[i] = lendDate;
					 book.count[i]++;
					 System.out.println("��"+want+"�����Խ����");
					 break;
				 }else if(book.name[i].equals(want) && book.state[i]==0){  
					 System.out.println("��"+want+"���ѱ������");
					 break;
				 }   		 
			 }

		   	System.out.println("**************************");
		   	returnMain();
		}
		
		public void returnbook() {
	        System.out.println("---> �黹ͼ��\n");
	        Scanner input = new Scanner(System.in);
	        System.out.print("������ͼ�����ƣ� ");
	        String want = input.next();
	        System.out.print("������黹���ڣ���-��-�գ���");
	        String redate = input.next();
	        //this.setCharge(0);
	        for (int i = 0; i < book.name.length; i++) {
	            if (book.name[i] == null) {    //��ƥ��
	                System.out.println("û���ҵ�ƥ����Ϣ��");
	                break;
				 }else if(book.name[i].equals(want) && book.state[i] == 0){  //�ҵ�ƥ��	 
	                /*��ȫ�黹���� 1.����Ϊδ���״̬ 2.�������*/
					book.state[i] = 1;
	                System.out.println("\n�黹��" + want + "���ɹ�!");
	                System.out.println("�������Ϊ��" + book.date[i]);
	                System.out.println("�黹����Ϊ��" + redate);
	               // System.out.println("Ӧ�����Ԫ����" + charge(book.date[i],redate));
	                break;
				 }else if(book.name[i].equals(want) && book.state[i] == 1){ 		//�ҵ�ƥ�䵫û�н��  
	                System.out.println("��ͼ��û�б�������޷����й黹������");
	                break;
	            }
	        }

	        System.out.println("**************************");
	        returnMain();
	    }
}
