package com;

import java.util.Scanner;

public class BankAccount {
    private static final int amount = 0;
	private static int balance;
    
    public BankAccount(){//一个无参构造方法，将账户余额初始化为0
        balance=0;
    }
    
    public BankAccount(int balance) {//一个带一个参数的构造方法，将账户余额初始化为该输入的参数
		BankAccount.balance = balance;
	}  

	public static int getBalance() {
		return balance;
	}                                    
	public static int setBalance(int balance) {
		return BankAccount.balance = balance;
    }
    
    public static  int withdraw (int amount) { //从账户提取特定数额
		return BankAccount.balance = getBalance()-amount;
	}                                  
	public static int deposit(int camount) { //向账户存储特定数额
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



