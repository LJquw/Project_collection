package com;

import java.util.Scanner;

public class BankAccount {
    private static final int amount = 0;
	private static int balance;
    
    public BankAccount(){//һ���޲ι��췽�������˻�����ʼ��Ϊ0
        balance=0;
    }
    
    public BankAccount(int balance) {//һ����һ�������Ĺ��췽�������˻�����ʼ��Ϊ������Ĳ���
		BankAccount.balance = balance;
	}  

	public static int getBalance() {
		return balance;
	}                                    
	public static int setBalance(int balance) {
		return BankAccount.balance = balance;
    }
    
    public static  int withdraw (int amount) { //���˻���ȡ�ض�����
		return BankAccount.balance = getBalance()-amount;
	}                                  
	public static int deposit(int camount) { //���˻��洢�ض�����
		return BankAccount.balance = withdraw(amount)+camount;
	}     
	
	public static void main(String[] args) {
		
		Scanner zhanghu=new Scanner(System.in);
		int balance=zhanghu.nextInt();
		int amount=zhanghu.nextInt();
		int camount=zhanghu.nextInt();
		int balance1=setBalance(balance);
		int balance2=withdraw(amount);
		int balance3=deposit(camount);
		System.out.println(""+balance1+"\n"+""+balance2+"\n"+""+balance3);
	}
}



