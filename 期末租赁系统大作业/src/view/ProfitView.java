package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Car;
import model.FixCar;
import model.RentCar;
import model.RepayCar;
import util.Database;
import util.Search;

import javax.swing.JComboBox;
import javax.swing.JButton;
public class ProfitView {

	JFrame frame;
	JScrollPane scrollPane;
	private JTable table_1;
	JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Vector<String> columnName = new Vector();
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitView window = new ProfitView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfitView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("��ѯ��Ϣ");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 595, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.background"));
		panel.setBounds(412, 10, 161, 454);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u8F66\u8F86\u67E5\u8BE2");
		lblNewLabel.setBounds(12, 12, 119, 30);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(12, 45, 134, 38);
		comboBox.addItem("");
		comboBox.addItem("��������");
		comboBox.addItem("��������");
		comboBox.addItem("������ɫ");
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(12, 90, 134, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u67E5\u8BE2");
		lblNewLabel_1.setBounds(22, 143, 119, 30);
		panel.add(lblNewLabel_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(12, 175, 134, 38);
		comboBox_1.addItem("");
		comboBox_1.addItem("ʹ����");
		comboBox_1.addItem("��������");
		comboBox_1.addItem("�޳�����");
		panel.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 220, 134, 38);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" \u4EF7\u683C\u67E5\u8BE2");
		lblNewLabel_2.setBounds(22, 279, 119, 30);
		panel.add(lblNewLabel_2);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(12, 312, 134, 38);
		comboBox_2.addItem("");
		comboBox_2.addItem("�������");
		comboBox_2.addItem("�޳�����");
		panel.add(comboBox_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 356, 134, 38);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 401, 134, 38);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		scrollPane = new JScrollPane();//����
		scrollPane.setBounds(15, 10, 382, 399);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setToolTipText(null);
		scrollPane.setViewportView(table_1);
		
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.setBounds(144, 414, 123, 48);
		btnNewButton.addActionListener(new ActionListener() {
         
		public void actionPerformed(ActionEvent e) {
				String search_car = textField.getText().trim();
	            String search_data = textField_1.getText().trim();
//				Float search_price=Float.valueOf(textField_2.getText().trim());
//				Float search_price1=Float.valueOf(textField_3.getText().trim());
				String car_xinxi =(String) comboBox.getItemAt(comboBox.getSelectedIndex());
				String car_data =(String) comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
				String car_price =(String) comboBox_2.getItemAt(comboBox_2.getSelectedIndex());
			    
				if(car_xinxi.length()!=0 &&car_data.equals("")&&car_price .equals("")) {
					if(car_xinxi=="��������") {
						
						//table_1.removeAll();
						Vector rowData = new Vector();
						// ��ʼ���������
						columnName.add("�������");
						columnName.add("��������");
						columnName.add("������ɫ");
						columnName.add("��������");
						columnName.add("�������");
						List<Car> list;
						try {
							list = Search.queryCarName(search_car);
							//��ʼ���������
							if (list != null && list.size() > 0) {
								for (int i=0;i<list.size();i++) {
									Car car = list.get(i);
									Vector vector = new Vector();
									vector.add(car.getId());
									vector.add(car.getName());
									vector.add(car.getColor());
									vector.add(car.getType());
									vector.add(car.getPrice());
//									System.out.println(i);
//									System.out.println(car.getId());
									rowData.add(vector);
								}
							}
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						model = new DefaultTableModel(rowData, columnName) {
							// ���ñ���е����ݲ����Ա༭
							public boolean isCellEditable(int r,int c) {
								return false;
							}
						};
						table_1 = new JTable(model);
						scrollPane.setViewportView(table_1);
						// ֻ�ɵ�ѡ
//						table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//						table_1.getTableHeader().setReorderingAllowed(false);
						// �������¼�
						table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if (!e.getValueIsAdjusting()) {
								//֧�ֵ�ѡ
								int row=table_1.getSelectedRow();//ѡ����
								int col=table_1.getSelectedColumn();//ѡ����
								//System.out.println("����һ:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,3));
								// ����ֵ
								textField.setText(String.valueOf(table_1.getValueAt(row, 0)));
								textField_1.setText(String.valueOf(table_1.getValueAt(row, 1)));
								textField_2.setText(String.valueOf(table_1.getValueAt(row, 2)));
								textField_3.setText(String.valueOf(table_1.getValueAt(row, 3)));
									}
								}
							});
					}
					
					
					else if(car_xinxi=="������ɫ") {
						//table_1.removeAll();
						Vector rowData = new Vector();
						// ��ʼ���������
						columnName.add("�������");
						columnName.add("��������");
						columnName.add("������ɫ");
						columnName.add("��������");
						columnName.add("�������");
						List<Car> list;
						
						//��ʼ���������
						try {
							list = Search.queryCarColor(search_car);
							//��ʼ���������
							if (list != null && list.size() > 0) {
								for (int i=0;i<list.size();i++) {
									Car car = list.get(i);
									Vector vector = new Vector();
									vector.add(car.getId());
									vector.add(car.getName());
									vector.add(car.getColor());
									vector.add(car.getType());
									vector.add(car.getPrice());
//									System.out.println(i);
//									System.out.println(car.getId());
									rowData.add(vector);
								}
							}
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						model = new DefaultTableModel(rowData, columnName) {
							// ���ñ���е����ݲ����Ա༭
							public boolean isCellEditable(int r,int c) {
								return false;
							}
						};
						table_1 = new JTable(model);
						scrollPane.setViewportView(table_1);
						// ֻ�ɵ�ѡ
//						table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//						table_1.getTableHeader().setReorderingAllowed(false);
						// �������¼�
						table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if (!e.getValueIsAdjusting()) {
								//֧�ֵ�ѡ
								int row=table_1.getSelectedRow();//ѡ����
								int col=table_1.getSelectedColumn();//ѡ����
								System.out.println("����һ:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,3));
								// ����ֵ
								textField.setText(String.valueOf(table_1.getValueAt(row, 0)));
								textField_1.setText(String.valueOf(table_1.getValueAt(row, 1)));
								textField_2.setText(String.valueOf(table_1.getValueAt(row, 2)));
								textField_3.setText(String.valueOf(table_1.getValueAt(row, 3)));
									}
								}
							});
					}
					else if(car_xinxi=="��������") {
						//table_1.removeAll();
						Vector rowData = new Vector();
						// ��ʼ���������
						columnName.add("�������");
						columnName.add("��������");
						columnName.add("������ɫ");
						columnName.add("��������");
						columnName.add("�������");
						List<Car> list ;
						//��ʼ���������
						try {
							list = Search.queryCarType(search_car);
							//��ʼ���������
							if (list != null && list.size() > 0) {
								for (int i=0;i<list.size();i++) {
									Car car = list.get(i);
									Vector vector = new Vector();
									vector.add(car.getId());
									vector.add(car.getName());
									vector.add(car.getColor());
									vector.add(car.getType());
									vector.add(car.getPrice());
//									System.out.println(i);
//									System.out.println(car.getId());
									rowData.add(vector);
								}
							}
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						model = new DefaultTableModel(rowData, columnName) {
							// ���ñ���е����ݲ����Ա༭
							public boolean isCellEditable(int r,int c) {
								return false;
							}
						};
						table_1 = new JTable(model);
						scrollPane.setViewportView(table_1);
						// ֻ�ɵ�ѡ
//						table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//						table_1.getTableHeader().setReorderingAllowed(false);
						// �������¼�
						table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if (!e.getValueIsAdjusting()) {
								//֧�ֵ�ѡ
								int row=table_1.getSelectedRow();//ѡ����
								int col=table_1.getSelectedColumn();//ѡ����
								System.out.println("����һ:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,3));
								// ����ֵ
								textField.setText(String.valueOf(table_1.getValueAt(row, 0)));
								textField_1.setText(String.valueOf(table_1.getValueAt(row, 1)));
								textField_2.setText(String.valueOf(table_1.getValueAt(row, 2)));
								textField_3.setText(String.valueOf(table_1.getValueAt(row, 3)));
									}
								}
							});
					}
					
				}
				
				else if(car_data.length()!=0 &&car_xinxi.equals("")&&car_price .equals("")) {
					if(car_data=="ʹ����") {
						Vector rowData = new Vector();
						// ��ʼ���������
						columnName.add("�������");
						columnName.add("�⳵����");
						columnName.add("�⳵�û�");
						columnName.add("����״̬");
						columnName.add("����ID");
						List<RepayCar> list ;
						//��ʼ���������
						try {
							list = Search.queryCarUsers(search_data);
							//��ʼ���������
							if (list != null && list.size() > 0) {
								for (int i=0;i<list.size();i++) {
									RepayCar car = list.get(i);
									Vector vector = new Vector();
									vector.add(car.getId());
									vector.add(car.getRepayDate());
									vector.add(car.getUsers());
									vector.add(car.getState());
									vector.add(car.getCarID());
//									System.out.println(i);
//									System.out.println(car.getId());
									rowData.add(vector);
								}
							}
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						model = new DefaultTableModel(rowData, columnName) {
							// ���ñ���е����ݲ����Ա༭
							public boolean isCellEditable(int r,int c) {
								return false;
							}
						};
						table_1 = new JTable(model);
						scrollPane.setViewportView(table_1);
						// ֻ�ɵ�ѡ
//						table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//						table_1.getTableHeader().setReorderingAllowed(false);
						// �������¼�
						table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if (!e.getValueIsAdjusting()) {
								//֧�ֵ�ѡ
								int row=table_1.getSelectedRow();//ѡ����
								int col=table_1.getSelectedColumn();//ѡ����
								System.out.println("����һ:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,3));
								// ����ֵ
								textField.setText(String.valueOf(table_1.getValueAt(row, 0)));
								textField_1.setText(String.valueOf(table_1.getValueAt(row, 1)));
								textField_2.setText(String.valueOf(table_1.getValueAt(row, 2)));
								textField_3.setText(String.valueOf(table_1.getValueAt(row, 3)));
									}
								}
							});
					}
				}
           }
		});
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
}
