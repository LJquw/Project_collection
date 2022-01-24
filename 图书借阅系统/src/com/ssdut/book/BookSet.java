package com.ssdut.book;

public class BookSet {
	String[] name = new String[1000];       //名称
	int[] state = new int[1000];            //借出状态
	String[] date = new String[1000];       //借出日期
	int[] count = new int[1000];            //借出次数
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getState() {
		return state;
	}
	public void setState(int[] state) {
		this.state = state;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public int[] getCount() {
		return count;
	}
	public void setCount(int[] count) {
		this.count = count;
	}

}
