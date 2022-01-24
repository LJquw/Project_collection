import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
public class Retnrncar extends JFrame {
    JButton AddBtn,save,del,exit;
    DefaultTableModel tableModel,model;        // 默认显示的表格
    JTable table1;
    JTable table;
    int column,row;
    // value数组存放表格中的所有数据


    Object[][] value1;

    /**
     * 创建按钮和其他组件
     */
    // 创建品牌输入框
    public Retnrncar() {
        ImageIcon icon1=new ImageIcon("D:\\CarSystem\\pic\\20.jpg" );
        //添加JLabel 放置图片
        JLabel labelp=new JLabel(icon1);
        //设置label的位置、大小，label大小为图片的大小
        labelp.setBounds(-100, 0, 1200, 450);

        JLabel NumLable = new JLabel("品牌：");
        JTextField NumTextField = new JTextField();
        NumLable.setBounds(30, 250, 40, 30);
        NumTextField.setBounds(72, 250, 65, 30);

        // 创建型号输入框
        JLabel NameLable = new JLabel("型号：");
        JTextField NameTextField = new JTextField();
        NameLable.setBounds(150, 250, 40, 30);
        NameTextField.setBounds(192, 250, 65, 30);

        //创建车牌号
        JLabel SexLable = new JLabel("车牌号：");
        JTextField SexTextField = new JTextField();
        SexLable.setBounds(270, 250, 70, 30);
        SexTextField.setBounds(322, 250, 70, 30);


        // 创建是否租赁
        JLabel AgeLable = new JLabel("是否租赁：");
        JTextField AgeTextField = new JTextField();
        AgeLable.setBounds(410, 250, 70, 30);
        AgeTextField.setBounds(472, 250, 70, 30);

        JLabel lease = new JLabel("日租金：");
        JTextField leaseField = new JTextField();
        lease.setBounds(560, 250, 70, 30);
        leaseField.setBounds(612, 250, 70, 30);

        JLabel yLable = new JLabel("租出日期：");
        JTextField yTextField = new JTextField();
        yLable.setBounds(700, 250, 70, 30);
        yTextField.setBounds(762, 250, 70, 30);



        //创建按钮

        del = new JButton("删除");
        del.setBounds(205, 200, 100, 30);

        save = new JButton("保存");
        save.setBounds(330, 200, 100, 30);

        exit = new JButton("返回");
        exit.setBounds(465, 200, 100, 30);


        MyEvent();
        // 取得haha数据库的aa表的各行数据
        Vector rowData = PutinStorage.getRows();
        // 取得haha数据库的aa表的表头数据
        Vector columnNames = PutinStorage.getHead();
        tableModel = new DefaultTableModel(rowData,columnNames);
        table1 = new JTable(tableModel);
        column = table1.getColumnCount();        // 表格列数
        row = table1.getRowCount();        // 表格行数

        Object[][] values = new String[row][column];
        for (int i = 0; i < table1.getRowCount(); i++) {
            for (int j = 0; j < table1.getColumnCount(); j++) {
                values[i][j] = table1.getValueAt(i, j);
            }
        }
        value1=values;
        //只显示已租出车辆
        Object[][] value = new String[row][column];

        int k=0,l=0;
        for (int i = 0; i < table1.getRowCount(); i++,k++) {
            for (int j = 0; j < table1.getColumnCount(); j++) {
                if (values[k][l].equals("否")){
                    i--;
                    value[i+1][0]="";
                    value[i+1][1]="";
                    value[i+1][2]="";
                    break;
                }else{
                    value[i][j]=values[k][l];
                    l++;
                }
            }
            l=0;
            if (i==-1&&k==table1.getRowCount()-1) {
                JOptionPane.showMessageDialog(null, "结果无记录");
                break;
            }
            if (k==table1.getRowCount()-1){
                break;
            }
        }

        // 创建表头的数据容器
        Object[] title = new Object[]{"品牌" ,"型号","车牌号","是否租赁"," 日租金"," 租出日期","维修金"};
        // 创建DefaultTableMode模型 管理数据容器
        model = new DefaultTableModel(value, title);
        // 创建表格
        table = new JTable(model);
        // 创建table滚动窗体
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30, 800,table.getRowHeight()*(row+4));

        // 创建container
        Container container = this.getContentPane();
        container.add(scrollPane);
        container.add(del);
        container.add(save);
        container.add(exit);
        container.add(labelp);
        // 设置布局管理器
        this.setLayout(null);
        /**
         * 设置窗体属性
         */
        this.setTitle("已租赁车辆");
        this.setVisible(true);
        this.setBounds(300, 200, 880, 400);
        this.setLocationRelativeTo(null);// 设置居中显示
        // 设置Jframe窗体关闭时 程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public void MyEvent() {


        // 删除
        del.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            // 删除指定行
            int rowcount = table.getSelectedRow();
            if (rowcount >= 0) {
                tableModel.removeRow(rowcount);
            }
        });

        save.addActionListener(e -> {
            int column = table.getColumnCount();        // 表格列数
            int row = table.getRowCount();        // 表格行数
            String[][] value2=new String[table.getRowCount()][table.getColumnCount()];
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    value2[i][j] = (String) table.getValueAt(i, j);
                }
            }
            // value数组存放表格中的所有数据
            Object[][] value3 = value1;
            //Object[][] value4 = new String[value2.length][];
            for (int i = 0; i < value1.length; i++) {
                for (int k=0;k<value2.length;k++){
                    if (value3[i][2]==value2[k][2]&&value3[i][3]!=value2[k][3]){
                        value3[i][0]=value2[k][0];
                        value3[i][1]=value2[k][1];
                        value3[i][2]=value2[k][2];
                        value3[i][3]=value2[k][3];
                        value3[i][4]=value2[k][4];
                        value3[i][5]=value2[k][5];
                    }
                }

            }



            // 以下均为对数据库的操作
            final String DRIVER = "com.mysql.jdbc.Driver";
            final String URL = "jdbc:mysql://localhost:3306/students?userSSL=true&characterEncoding=utf-8";
            final String user = "root";
            final String password = "";


            Connection conn;
            Statement sql;
            ResultSet rs;
            String sqlt1 = "delete from allcar where true";


            try {
                Class.forName("com.mysql.jdbc.Driver");        //连接驱动
                conn = DriverManager.getConnection(URL, user, password);    //连接数据库
                if (!conn.isClosed()) {
                    System.out.println("成功连接数据库");
                }


                // 删除表中所有数据
                sql = conn.createStatement();
                int ok = sql.executeUpdate(sqlt1);

                // 将value数组中的数据依次存放到表中

                try {
                    sql = conn.createStatement();
                    for (int i = 0; i <row ; i++) {
                        sql.executeUpdate("insert into allcar values(   ' " + value3[i][0] + " '   ,   '" + value3[i][1] + "'    ,   '" + value3[i][2] + "' ,   '" + value3[i][3] + "',   '" + value3[i][4] + "',   '" + value3[i][5] + "'     )");
                    }                }
                catch (SQLException se) {
                    System.out.println(se);
                }

            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                System.out.println("未成功加载驱动。");
                e1.printStackTrace();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                System.out.println("未成功打开数据库。");
                e1.printStackTrace();
            }
        });

        // 退出
        exit.addActionListener(e -> {
            // TODO Auto-generated method stub
            this.dispose();
        });
    }
}
