package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Car;
import model.FixCar;
import model.RentCar;
import model.RepayCar;

public class Search {
	private static Connection con=null;
	
	//查询车辆信息
	public static List<Car> queryCarName(String name) throws SQLException{	
			String sql="select * from car where Name=?";
			List<Car> list=new ArrayList<Car>();
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Car car=new Car();
					car.setId(rs.getInt(1));
					car.setName(rs.getString(2));
					car.setColor(rs.getString(3));
					car.setType(rs.getString(4));
					car.setPrice(rs.getFloat(5));
					list.add(car);
					System.out.println(car.getId());
				}
				return list;		
		}
	
	public static List<Car> queryCarColor(String color)throws SQLException{
		
		String sql="select * from car where Color=?";
		List<Car> list=new ArrayList<Car>();
		Car car=new Car();
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,color);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2));
				car.setColor(rs.getString(3));
				car.setType(rs.getString(4));
				car.setPrice(rs.getFloat(5));
				list.add(car);
			}
			rs.close();
			rs.close();
		
		return list;
	}
	
	public static List<Car> queryCarType(String type)throws SQLException{
		
		String sql="select * from car where Type=?";
		List<Car> list=new ArrayList<Car>();
		
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Car car=new Car();
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2));
				car.setColor(rs.getString(3));
				car.setType(rs.getString(4));
				car.setPrice(rs.getFloat(5));
				list.add(car);
			}
			rs.close();
			rs.close();
		
		
		return list;
	}
		
	
		public static List<FixCar> queryFixCarDate(String date)throws SQLException{
			
			String sql="select * from fixcar where fixdate<?";
			List<FixCar> list=new ArrayList<FixCar>();
			
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,date);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					FixCar fixcar=new FixCar();
					fixcar.setId(rs.getInt(1));
					fixcar.setFixDate(rs.getString(2));
					fixcar.setQuestion(rs.getString(3));
					fixcar.setPrice(rs.getFloat(4));
					fixcar.setCarID(rs.getInt(5));
					list.add(fixcar);
				}
				rs.close();
				rs.close();
			
			
			return list;
		}
		
		public static List<RentCar> queryRentCardate(String date)throws SQLException{
			String sql="select *from rentCar where RentDate<?";
			List<RentCar> list=new ArrayList<RentCar>();
			
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,date);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					RentCar rentcar=new RentCar();
					rentcar.setId(rs.getInt(1));
					rentcar.setRentDate(rs.getString(2));
					rentcar.setUsers(rs.getString(3));
					rentcar.setPrice(rs.getFloat(4));
					rentcar.setCarID(rs.getInt(5));
					list.add(rentcar);
				}
				rs.close();
				rs.close();
			
			return list;
		}
		
		public static List<RepayCar> queryRepayCarDate(String date)throws SQLException{
			String sql="select *from repayCar where RepayDate<?";
			List<RepayCar> list=new ArrayList<RepayCar>();
			
//			String sql="select *from rentCar where RentDate<?";
//			String sql="select *from rentCar where Price<? and Price >?";
//			List<RentCar> list=new ArrayList<RentCar>();
			
//			String sql="select *from fixCar where FixDate<?";
//			String sql="select *from fixCar where Price<? and Price >?";
//			List<FixCar> list=new ArrayList<FixCar>();
			
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,date);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					RepayCar repaycar=new RepayCar();
					repaycar.setId(rs.getInt(1));
					repaycar.setRepayDate(rs.getString(2));
					repaycar.setUsers(rs.getString(3));
					repaycar.setState(rs.getString(4));
					repaycar.setCarID(rs.getInt(5));
					list.add(repaycar);
				}
				rs.close();
				rs.close();
	
			return list;
		}
		
		public static List<RepayCar> queryCarUsers(String users) throws SQLException{
			String sql="select *from repaycar  where Users=?";
			List<RepayCar> list=new ArrayList<RepayCar>();
			
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,users);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				RepayCar repaycar=new RepayCar();
				repaycar.setId(rs.getInt(1));
				repaycar.setRepayDate(rs.getString(2));
				repaycar.setUsers(rs.getString(3));
				repaycar.setState(rs.getString(4));
				repaycar.setCarID(rs.getInt(5));
				list.add(repaycar);
				System.out.println(repaycar.getId());
				
			}
			rs.close();
			rs.close();
		
		   return list;
		}
}
