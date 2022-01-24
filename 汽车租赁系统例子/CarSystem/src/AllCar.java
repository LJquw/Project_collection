import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class AllCar extends JFrame {
    JButton AddBtn,save,del,exit;
    DefaultTableModel tableModel,model;        // 默认显示的表格
    JTable table1,table;

    /**
     * 创建按钮和其他组件
     */
    // 创建品牌输入框
    public AllCar() {

        ImageIcon icon1=new ImageIcon("D:\\CarSystem\\pic\\11.png" );
        //添加JLabel 放置图片
        JLabel labelp=new JLabel(icon1);
        //设置label的位置、大小，label大小为图片的大小
        labelp.setBounds(-20, 0, 1100, 450);

        JLabel NumLable = new JLabel("品牌：");
        NumLable.setForeground(Color.ORANGE);
        JTextField NumTextField = new JTextField();
        NumLable.setBounds(30, 250, 40, 30);
        NumTextField.setBounds(72, 250, 65, 30);

        // 创建型号输入框
        JLabel NameLable = new JLabel("型号：");
        NameLable.setForeground(Color.ORANGE);
        JTextField NameTextField = new JTextField();
        NameLable.setBounds(150, 250, 40, 30);
        NameTextField.setBounds(192, 250, 65, 30);

        //创建车牌号
        JLabel SexLable = new JLabel("车牌号：");
        SexLable.setForeground(Color.ORANGE);
        JTextField SexTextField = new JTextField();
        SexLable.setBounds(270, 250, 70, 30);
        SexTextField.setBounds(322, 250, 70, 30);


        // 创建是否租赁
        JLabel AgeLable = new JLabel("是否租赁：");
        AgeLable.setForeground(Color.ORANGE);
        JTextField AgeTextField = new JTextField();
        AgeLable.setBounds(410, 250, 70, 30);
        AgeTextField.setBounds(472, 250, 70, 30);

        JLabel lease = new JLabel("日租金：");
        lease.setForeground(Color.ORANGE);
        JTextField leaseField = new JTextField();
        lease.setBounds(560, 250, 70, 30);
        leaseField.setBounds(612, 250, 70, 30);

        JLabel yLable = new JLabel("租出日期：");
        yLable.setForeground(Color.ORANGE);
        JTextField yTextField = new JTextField();
        yLable.setBounds(700, 250, 70, 30);
        yTextField.setBounds(762, 250, 70, 30);

        JLabel xlable = new JLabel("维修金：");
        xlable.setForeground(Color.ORANGE);
        JTextField xTextField = new JTextField();
        xlable.setBounds(860, 250, 70, 30);
        xTextField.setBounds(910, 250, 70, 30);



        //创建增加按钮
        AddBtn = new JButton("增加");
        AddBtn.setBounds(205, 300, 100, 30);

        del = new JButton("删除");
        del.setBounds(355, 300, 100, 30);

        save = new JButton("保存");
        save.setBounds(505, 300, 100, 30);

        exit = new JButton("返回");
        exit.setBounds(655, 300, 100, 30);

        MyEvent();
        /**
         * 创建数据容器
         */
        // 创建表格内容的容器
        /*Object[][] context = new Object[][]{
                {"宝马 ",  "M1", "川A 12345","120 ","2001-08-21 "}
        };*/
        // 取得haha数据库的aa表的各行数据
        Vector rowData = PutinStorage.getRows();
        // 取得haha数据库的aa表的表头数据
        Vector columnNames = PutinStorage.getHead();
        tableModel = new DefaultTableModel(rowData,columnNames);
        table1 = new JTable(tableModel);
        int column = table1.getColumnCount();        // 表格列数
        int row = table1.getRowCount();        // 表格行数

        // value数组存放表格中的所有数据
        Object[][] values = new String[row][column];

        for (int i = 0; i < table1.getRowCount(); i++) {
            for (int j = 0; j < table1.getColumnCount(); j++) {
                values[i][j] = table1.getValueAt(i, j) + "";
            }
        }

        // 创建表头的数据容器
        Object[] title = new Object[]{"品牌" ,"型号","车牌号","是否租赁"," 日租金"," 租出日期","维修金"};
        // 创建DefaultTableMode模型 管理数据容器
         model = new DefaultTableModel(values, title);
        // 创建表格
        table = new JTable(model);
        // 创建table滚动窗体
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30, 1000,table.getRowHeight()*(row+4));
        //创建监听器
        AddBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String Num = NumTextField.getText();
                String Name = NameTextField.getText();
                String sex = SexTextField.getText();
                String Age = AgeTextField.getText();
                String jf = leaseField.getText();
                String yf = yTextField.getText();
                String xf=xTextField.getText();

                Object[] data = new Object[]{Num, Name, sex, Age,jf,yf,xf};
                //将数据放入数据容器中
                model.addRow(data);

                //增加后清空数据
                SexTextField.setText("");
                leaseField.setText("");
                yTextField.setText("");
                NumTextField.setText("");
                NameTextField.setText("");
                AgeTextField.setText("");
                xTextField.setText("");
            }
        });

        // 创建container
        Container container = this.getContentPane();
        container.add(scrollPane);
        container.add(NumLable);
        container.add(NumTextField);
        container.add(NameLable);
        container.add(NameTextField);
        container.add(SexLable);
        container.add(SexTextField);
        container.add(AgeLable);
        container.add(AgeTextField);
        container.add(lease);
        container.add(leaseField);
        container.add(yLable);
        container.add(yTextField);
        container.add(xlable);
        container.add(xTextField);
        container.add(AddBtn);
        container.add(del);
        container.add(save);
        container.add(exit);
        container.add(labelp);
        // 设置布局管理器
        this.setLayout(null);
        /**
         * 设置窗体属性
         */
        this.setTitle("所有车辆信息");
        this.setVisible(true);
        this.setBounds(300, 200, 1050, 450);
        this.setLocationRelativeTo(null);// 设置居中显示
        // 设置Jframe窗体关闭时 程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void MyEvent() {

        del.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            // 删除指定行
            int rowcount = table.getSelectedRow();
            if(rowcount >= 0){
                model.removeRow(rowcount);
            }
        });

        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int column = table.getColumnCount();		// 表格列数
                int row = table.getRowCount();		// 表格行数

                // value数组存放表格中的所有数据
                String[][] value = new String[row][column];

                for(int i = 0; i < row; i++){
                    for(int j = 0; j < column; j++){
                        value[i][j] = table.getValueAt(i, j).toString();
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
                    Class.forName("com.mysql.jdbc.Driver");		//连接驱动
                    conn = DriverManager.getConnection(URL, user, password);	//连接数据库
                    if(!conn.isClosed())
                        System.out.println("成功连接数据库");

                    // 删除aa表中所有数据
                    sql = conn.createStatement();
                    int ok = sql.executeUpdate(sqlt1);

                    // 将value数组中的数据依次存放到aa表中
                    for(int i = 0; i < row; i++){
                        sql.executeUpdate("insert into allcar values(   ' " + value[i][0] + " ' ,   '" + value[i][1] + "'    ,   '" + value[i][2] + "' , '" + value[i][3] + "',   '" + value[i][4] + "',   '" + value[i][5] + "',   '" + value[i][6] + "' )");
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
            }
        });

        // 退出
        exit.addActionListener(e -> {
            // TODO Auto-generated method stub
            this.dispose();
        });
    }


}

