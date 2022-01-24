package util;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;



import model.Car;
import model.FixCar;
import model.RentCar;
import model.RepayCar;

public class Database {
	//数据库连接字符串
	private String URL="jdbc:sqlserver://localhost:1433;DatabaseName=car";
	//数据连接用户名
	private String URER="Queen";
	//数据连接密码
	private String PWD="123456";
	//数据连接对象
	private static Connection con=null;
	static PreparedStatement ps=null;
	public Database() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("[驱动加载成功]");
			con=DriverManager.getConnection(URL, URER, PWD);
			System.out.println("[数据库连接成功]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception ex) {
		  ex.printStackTrace();
     	}
	}
	
	public static Connection getCon() {
		return con;
	}
	
	//管理员登录
	public static boolean adminLogin(String username,String password) {
		String sql="select * from admin where UserName=? and Password=?";
		boolean flag =false;
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			ps= con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
//			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			rs.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//删除车辆信息
	public static boolean deleteCarInfo(int id) {
		String sql="delete from car where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,id);
			int rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//查询车辆信息
	public static List<Car> queryCarInfo(){
	
		String sql="select * from car";
		List<Car> list=new ArrayList<Car>();
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
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
			rs.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//添加车辆信息
	public  boolean addCarInfo(Car car) {
		 String sql="insert into car(ID,Name,Color,Type,Price) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,car.getId());
			ps.setString(2,car.getName());
			ps.setString(3,car.getColor());
			ps.setString(4,car.getType());
			ps.setFloat(5,car.getPrice());
			int rs=0;
			rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//修改车辆信息
	public static boolean updateCarInfo(Car car) {
		String sql="update car set Name=?,Color=?,Type=?,Price=? where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(5,car.getId());
			ps.setString(1,car.getName());
			ps.setString(2,car.getColor());
			ps.setString(3,car.getType());
			ps.setFloat(4,car.getPrice());
			int rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//添加修车信息
	public static boolean addFixCarInfo(FixCar fixcar) {
		String sql="insert into fixcar(ID,FixDate,Question,Price,CarID) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,fixcar.getId());
			ps.setString(2,fixcar.getFixDate());
			ps.setString(3,fixcar.getQuestion());
			ps.setFloat(4,fixcar.getPrice());
			ps.setInt(5,fixcar.getCarID());
			int rs=0;
			rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//删除修车信息
		public static boolean deleteFixCarInfo(int id) {
			String sql="delete from fixCar where ID=?";
			try {
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1,id);
				int rs=ps.executeUpdate();
				ps.close();
				return rs!=0;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	
		//查询修车信息
		public static List<FixCar> queryFixCarInfo(){
			String sql="select *from fixCar";
			List<FixCar> list=new ArrayList<FixCar>();
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		//修改修车信息
		public static boolean updateFixCarInfo(FixCar fixcar) {
			String sql="update fixCar set FixDate=?,Question=?,Price=?,CarID=? where ID=? ";
			try {
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setInt(5,fixcar.getId());
				ps.setString(1,fixcar.getFixDate());
				ps.setString(2,fixcar.getQuestion());
				ps.setFloat(3,fixcar.getPrice());
				ps.setInt(4,fixcar.getCarID());
				int rs=ps.executeUpdate();
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//添加租车信息
		public static boolean addRentCarInfo(RentCar rentcar) {
			String sql="insert into rentcar(ID,RentDate,Users,Price,CarID) values(?,?,?,?,?)";
			try {
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1,rentcar.getId());
				ps.setString(2,rentcar.getRentDate());
				ps.setString(3,rentcar.getUsers());
				ps.setFloat(4,rentcar.getPrice());
				ps.setInt(5,rentcar.getCarID());
				int rs=0;
				rs=ps.executeUpdate();
				ps.close();
				return rs!=0;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//删除租车信息
	public static boolean deleteRentCarInfo(int id) {
		String sql="delete from rentCar where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,id);
			int rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//查询租车信息
	public static List<RentCar> queryRentCarInfo(){
		String sql="select *from rentCar";
		List<RentCar> list=new ArrayList<RentCar>();
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//修改租车信息
	public static boolean updateRentCarInfo(RentCar rentcar) {
		String sql="update rentCar set RentDate=?,Users=?,Price=?,CarID=? where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(5,rentcar.getId());
			ps.setString(1,rentcar.getRentDate());
			ps.setString(2,rentcar.getUsers());
			ps.setFloat(3,rentcar.getPrice());
			ps.setInt(4,rentcar.getCarID());
			int rs=ps.executeUpdate();
			ps.close();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//添加还车信息
	public static boolean addRepayCarInfo(RepayCar repaycar) {
		String sql="insert into repaycar(ID,RepayDate,Users,State,CarID) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,repaycar.getId());
			ps.setString(2,repaycar.getRepayDate());
			ps.setString(3,repaycar.getUsers());
			ps.setString(4,repaycar.getState());
			ps.setInt(5,repaycar.getCarID());
			int rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//删除还车信息
	public static boolean deleteRapayCarInfo(int id) {
		String sql="delete from repayCar where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,id);
			int rs=ps.executeUpdate();
			ps.close();
			return rs!=0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//查询还车信息
	public static List<RepayCar> queryRepayCarInfo(){
		String sql="select *from repayCar ";
		List<RepayCar> list=new ArrayList<RepayCar>();
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//修改还车信息
	public static boolean updateRepayCarInfo(RepayCar repaycar) {
		String sql="update repayCar set RepayDate=?,Users=?,State=?,CarID=? where ID=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(5,repaycar.getId());
			ps.setString(1,repaycar.getRepayDate());
			ps.setString(2,repaycar.getUsers());
			ps.setString(3,repaycar.getState());
			ps.setInt(4,repaycar.getCarID());
			int rs=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//租车收入
	public float rentcar() {
		String sql="select sum(Price) from RentCar";
		float rentprice = 0;
		List<RentCar> list=new ArrayList<RentCar>();
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				rentprice=rs.getFloat(1);
			}
			System.out.println(rentprice);
			rs.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rentprice;
	}
	
	//修车支出
	public float fixcar() {
		String sql="select sum(Price) from FixCar";
		float fixprice = 0;
		List<RentCar> list=new ArrayList<RentCar>();
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "Bob", "123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				fixprice=rs.getFloat(1);
			}
			System.out.println(fixprice);
			rs.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return fixprice;
	}
}


