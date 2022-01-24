/*
 * Created by JFormDesigner on Fri Dec 04 13:09:02 CST 2020
 */

package 视图;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.*;

import 租赁车辆管理系统.Car;
import 租赁车辆管理系统.DateBase;

/**
 * @author Brainrain
 */
public class CarView extends JFrame {

    public CarView() throws SQLException {
        initComponents();
    }
    private String headTitle[]=new String[]{"1","2","3","4","5"};
    private DefaultTableModel dtm=null;

    public Object[][] makeTable() throws SQLException {
        List<Car> list=DateBase.query() ;
        assert list != null;
        Object [][] data=new Object[list.size()][5];
        for(int i=0;i<list.size();i++){
            data[i][0]=list.get(i).getID();
            data[i][1]=list.get(i).getBrand();
            data[i][2]=list.get(i).getType();
            data[i][3]=list.get(i).getColor();
            data[i][4]=list.get(i).getDayPrice();

        }
        return data;
    }

    private void addButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        Car tempCar=new Car();
        tempCar.setID(textField1.getText());
        tempCar.setBrand(textField2.getText());
        tempCar.setType(textField3.getText());
        tempCar.setColor(textField4.getText());
        tempCar.setDayPrice(Float.parseFloat(textField5.getText()));
        DateBase.addCar(tempCar);
        refreshButton.doClick();
    }

    private void refreshButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        table1.removeAll();
        try {
            dtm=new DefaultTableModel(makeTable(),headTitle);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table1.setModel(dtm);
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table1MouseCliked(e);
            }
        });
    }

    private void updateButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null,"请在右边输入框输入修改之后的所有车辆信息！",
                "提示",JOptionPane.PLAIN_MESSAGE);
        String id=textField1.getText();
        Car tempCar=DateBase.searchCar(id);
        DateBase.deleteCar(id);
        tempCar.setID(textField1.getText());
        if(textField2!=null){
            tempCar.setBrand(textField2.getText());
        }
        if(textField3!=null){
            tempCar.setType(textField3.getText());
        }
        if(textField3!=null){
            tempCar.setColor(textField4.getText());
        }
        if(textField4!=null){
            tempCar.setDayPrice(Float.parseFloat(textField5.getText()));
        }
        DateBase.addCar(tempCar);
        refreshButton.doClick();
    }

    private void deletButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        boolean reslut=DateBase.deleteCar(textField1.getText());
        if(reslut){
            JOptionPane.showMessageDialog(null,"删除车辆成功！","提示",JOptionPane.PLAIN_MESSAGE);
            //刷新按钮；
            refreshButton.doClick();
            //
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"删除车辆失败！","提示",JOptionPane.ERROR_MESSAGE);
        }


    }





    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        deletButton2 = new JButton();
        updateButton = new JButton();
        refreshButton = new JButton();
        addButton = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("Car");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText("\u8f66\u8f86ID");
        contentPane.add(label2);
        label2.setBounds(435, 30, 60, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(430, 50, 80, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u8f66\u8f86\u54c1\u724c");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(435, 85), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(430, 105, 80, textField2.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u8f66\u8f86\u578b\u53f7");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(435, 140), label4.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(430, 160, 80, textField3.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u8f66\u8f86\u989c\u8272");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(435, 195), label5.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(430, 220, 80, textField4.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u8f66\u8f86\u65e5\u79df\u91d1");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(435, 255), label6.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(430, 275, 80, textField5.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 25, 395, 280);

        //---- deletButton2 ----
        deletButton2.setText("\u5220\u9664");
        deletButton2.addActionListener(e -> deletButton2ActionPerformed(e));
        contentPane.add(deletButton2);
        deletButton2.setBounds(new Rectangle(new Point(240, 340), deletButton2.getPreferredSize()));

        //---- updateButton ----
        updateButton.setText("\u4fee\u6539");
        updateButton.addActionListener(e -> updateButtonActionPerformed(e));
        contentPane.add(updateButton);
        updateButton.setBounds(new Rectangle(new Point(335, 340), updateButton.getPreferredSize()));

        //---- refreshButton ----
        refreshButton.setText("\u5237\u65b0");
        refreshButton.addActionListener(e -> refreshButtonActionPerformed(e));
        contentPane.add(refreshButton);
        refreshButton.setBounds(new Rectangle(new Point(430, 340), refreshButton.getPreferredSize()));

        //---- addButton ----
        addButton.setText("\u589e\u52a0");
        addButton.addActionListener(e -> addButtonActionPerformed(e));
        contentPane.add(addButton);
        addButton.setBounds(new Rectangle(new Point(145, 340), addButton.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u4fe1\u606f\u7ba1\u7406\uff1a");
        contentPane.add(label1);
        label1.setBounds(30, 340, 85, 25);

        contentPane.setPreferredSize(new Dimension(585, 425));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void table1MouseCliked(MouseEvent e) {

            int index =table1.getSelectedRow();
            if(index!=-1){
//                AbstractButton textField6 = new AbstractButton() {
//                };
//                AbstractButton textField7 = new AbstractButton() {
//                };
//                AbstractButton textField8 = new AbstractButton() {
//                };
//                AbstractButton textField9 = new AbstractButton() {
//                };
//                AbstractButton textField10 = new AbstractButton() {
//                };
                textField1.setText(table1.getValueAt(index,0).toString());
                textField2.setText(table1.getValueAt(index,1).toString());
                textField3.setText(table1.getValueAt(index,2).toString());
                textField4.setText(table1.getValueAt(index,3).toString());
                textField5.setText(table1.getValueAt(index,4).toString());

            }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton deletButton2;
    private JButton updateButton;
    private JButton refreshButton;
    private JButton addButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
