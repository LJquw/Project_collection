import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class Profit extends JFrame {
    DefaultTableModel tableModel;        // 默认显示的表格
    JTable table1;
     public Profit(){

         ImageIcon icon1=new ImageIcon("D:\\CarSystem\\pic\\21.jpg" );
         //添加JLabel 放置图片
         JLabel labelp=new JLabel(icon1);
         //设置label的位置、大小，label大小为图片的大小
         labelp.setBounds(0, 0, 600, 450);

         //JFram 为一个窗口，参数名字为窗口名称。
         JFrame frame=new JFrame("利润分析");



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
         int[] getmoney=new int[row];
         int[] cost=new int[row];
         int sumg=0,sumc=0;
         for (int i = 0; i < table1.getRowCount(); i++){
             getmoney[i]=Integer.parseInt(values[i][4]+"");
             sumg=sumg+getmoney[i];
         }
         for (int i = 0; i < table1.getRowCount(); i++){
             cost[i]= Integer.parseInt(values[i][6]+"");
             sumc=sumc+cost[i];
         }
         //向内容面板添加控件，如JLabel，JButton
         JLabel label=new JLabel("利润分析");
         label.setFont(new Font("隶书",Font.BOLD,50));
         label.setForeground(Color.BLACK);
         label.setBounds(175,10,500,80);

         JLabel label2=new JLabel("总租金");
         label2.setFont(new Font("微软黑体",Font.BOLD,30));
         label2.setForeground(Color.red);
         label2.setBounds(135,90,500,80);

         JLabel label3=new JLabel();
         label3.setText(String.valueOf(sumg));
         label3.setFont(new Font("微软黑体",Font.BOLD,30));
         label3.setForeground(Color.red);
         label3.setBounds(375,90,500,80);

         JLabel label4=new JLabel("总维修金");
         label4.setFont(new Font("微软黑体",Font.BOLD,30));
         label4.setForeground(Color.red);
         label4.setBounds(135,170,500,80);

         JLabel label5=new JLabel();
         label5.setText(String.valueOf(sumc));
         label5.setFont(new Font("微软黑体",Font.BOLD,30));
         label5.setForeground(Color.red);
         label5.setBounds(375,170,500,80);

         JLabel label6=new JLabel();
         label6.setText("利润");
         label6.setFont(new Font("微软黑体",Font.BOLD,30));
         label6.setForeground(Color.red);
         label6.setBounds(135,260,500,80);

         JLabel label7=new JLabel();
         label7.setText(String.valueOf(sumg-sumc));
         label7.setFont(new Font("微软黑体",Font.BOLD,30));
         label7.setForeground(Color.red);
         label7.setBounds(375,260,500,80);




         Container contentPane=frame.getContentPane();
         contentPane.setLayout(null);
         contentPane.add(label);

         contentPane.add(label2);
         contentPane.add(label3);
         contentPane.add(label4);
         contentPane.add(label5);
         contentPane.add(label6);
         contentPane.add(label7);
         contentPane.add(labelp);
         //设置窗口其他参数，如大小。
         frame.setBounds(300, 200, 600, 450);
         //关闭方式
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         //显示窗口
         frame.setVisible(true);

    }

}
