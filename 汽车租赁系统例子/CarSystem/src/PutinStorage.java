import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class PutinStorage {
    // 得到数据库表数据
    public static Vector getRows(){
        final String DRIVER="com.mysql.jdbc.Driver";
        final String URL="jdbc:mysql://localhost:3306/students?userSSL=true&characterEncoding=utf-8";
        final String user="root";
        final String password="";
        Connection conn;
        PreparedStatement preparedStatement = null;

        Vector rows = null;
        Vector columnHeads = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");		//连接驱动
            conn = DriverManager.getConnection(URL,user, password);	//连接数据库

            preparedStatement = conn.prepareStatement("select * from allcar");
            ResultSet result1 = preparedStatement.executeQuery();

            if(result1.wasNull())
                JOptionPane.showMessageDialog(null, "结果集中无记录");

            rows = new Vector();

            ResultSetMetaData rsmd = result1.getMetaData();

            while(result1.next()){
                rows.addElement(getNextRow(result1,rsmd));
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        }
        return rows;
    }

    // 得到数据库表头
    public static Vector getHead(){
        final String DRIVER="com.mysql.jdbc.Driver";
        final String URL="jdbc:mysql://localhost:3306/students?userSSL=true&characterEncoding=utf-8";
        final String user="root";
        final String password="";
        Connection conn;
        PreparedStatement preparedStatement = null;

        Vector columnHeads = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");		//连接驱动
            conn = DriverManager.getConnection(URL,user, password);	//连接数据库

            preparedStatement = conn.prepareStatement("select * from allcar");
            ResultSet result1 = preparedStatement.executeQuery();

            boolean moreRecords = result1.next();
            if(!moreRecords)
                JOptionPane.showMessageDialog(null, "结果集中无记录");

            columnHeads = new Vector();
            ResultSetMetaData rsmd = result1.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++)
                columnHeads.addElement(rsmd.getColumnName(i));

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        }
        return columnHeads;
    }

    // 得到数据库中下一行数据
    private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
        Vector currentRow = new Vector();
        for(int i = 1; i <= rsmd.getColumnCount(); i++){
            currentRow.addElement(rs.getString(i));
        }
        return currentRow;
    }

}