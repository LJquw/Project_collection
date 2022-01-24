package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.FixCar;
import util.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FixCarView extends JFrame{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JScrollPane scrollPane;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private TableModel model;

	private Vector<String> columnName = new Vector();
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FixCarView window = new FixCarView();
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
	public FixCarView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("修车信息管理(201931101137柳均)");
		frame.setFont(new Font("Dialog", Font.PLAIN, 30));
		frame.setBounds(100, 100, 595, 499);
		frame.getContentPane().setBackground(Color.PINK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//frame.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(422, 10, 151, 433);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("车辆编号");//标签提示
		label.setBounds(38, 10, 93, 17);
		panel_1.add(label);
		
		textField = new JTextField();//输入栏
		textField.setBounds(27, 35, 77, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("修车日期");
		lblNewLabel.setBounds(38, 66, 93, 17);
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 91, 77, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("车辆故障");
		lblNewLabel_1.setBounds(38, 122, 93, 17);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 147, 77, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("修车费用");
		lblNewLabel_2.setBounds(38, 178, 93, 17);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(27, 203, 77, 25);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("车辆ID");
		lblNewLabel_3.setBounds(38, 234, 93, 17);
		panel_1.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(27, 259, 77, 25);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		// 操作按钮
		button_1 = new JButton("添加");
		button_1.setBounds(27, 307, 77, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()去除字符串的头尾空格,getText()获取文本框前的内容
				String fixDate = textField_1.getText().trim();
				String question = textField_2.getText().trim();
				Float price = Float.valueOf(textField_3.getText().trim());
				int carID = Integer.valueOf(textField_4.getText().trim());
				FixCar fixcar =new FixCar(id,fixDate,question,price,carID);
				if (e.getSource() == button_1) {
					if (fixDate == null || "".equals(fixDate)) {
						JOptionPane.showMessageDialog(null, "修车日期不能为空");
	                    return;
					}
					if (question == null || "".equals(question)) {
						JOptionPane.showMessageDialog(null, "修车故障不能为空");
	                    return;
					}
					if (price == null || "".equals(price)) {
						JOptionPane.showMessageDialog(null, "修车费用不能为空");
	                    return;
					}
					if ( carID== 0 || "".equals(carID)) {
						JOptionPane.showMessageDialog(null, "车辆ID不能为空");
	                    return;
					}
					new Database().addFixCarInfo(fixcar);
			        JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		panel_1.add(button_1);
		
		button_2 = new JButton("修改");
		button_2.setBounds(27, 340, 77, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()去除字符串的头尾空格,getText()获取文本框前的内容
				String fixDate = textField_1.getText().trim();
				String question = textField_2.getText().trim();
				Float price = Float.valueOf(textField_3.getText().trim());
				int carID = Integer.valueOf(textField_4.getText().trim());
				FixCar fixcar =new FixCar(id,fixDate,question,price,carID);
				if (e.getSource() == button_2) {
					if (fixDate == null || "".equals(fixDate)) {
						JOptionPane.showMessageDialog(null, "修车日期不能为空");
	                    return;
					}
					if (question == null || "".equals(question)) {
						JOptionPane.showMessageDialog(null, "修车故障不能为空");
	                    return;
					}
					if (price == null || "".equals(price)) {
						JOptionPane.showMessageDialog(null, "修车费用不能为空");
	                    return;
					}
					if ( carID== 0 || "".equals(carID)) {
						JOptionPane.showMessageDialog(null, "车辆ID不能为空");
	                    return;
					}
					new Database().updateFixCarInfo(fixcar);
			        JOptionPane.showMessageDialog(null, "修改成功");
				}
			}
		});
		panel_1.add(button_2);
		
		button_3 = new JButton("删除");
		button_3.setBounds(27, 373, 77, 23);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()去除字符串的头尾空格,getText()获取文本框前的内容
				if (e.getSource() == button_3) {
					if (id == 0 || "".equals(id)) {
						JOptionPane.showMessageDialog(null, "车辆编号不能为空");
	                    return;
					}
					new Database().deleteFixCarInfo(id);
			        JOptionPane.showMessageDialog(null, "删除成功");
				}
			}
		});
		panel_1.add(button_3);
		
		button_4 = new JButton("刷新");
		button_4.setBounds(27, 406, 77, 23);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if (e.getSource() == button_4) {
					// 刷新表格数据事件
				  table_1.removeAll();
       	          Vector rowData = new Vector();
					// 初始化表格数据
					List<FixCar> list = Database.queryFixCarInfo();
					if (list != null && list.size() > 0) {
						for (int i=0;i<list.size();i++) {
							FixCar fixcar = list.get(i);
							Vector vector = new Vector();
							vector.add(fixcar.getId());
							vector.add(fixcar.getFixDate());
							vector.add(fixcar.getQuestion());
							vector.add(fixcar.getPrice());
							vector.add(fixcar.getCarID());
				
							rowData.add(vector);
						}
					}
				
					model = new DefaultTableModel(rowData, columnName) {
						// 设置表格中的数据不可以编辑
						public boolean isCellEditable(int r,int c) {
							return false;
						}
					};
					table_1 = new JTable(model);
					scrollPane.setViewportView(table_1);
					model = new DefaultTableModel(rowData, columnName);
			        table_1.setModel(model);
			        table_1.addMouseListener(new MouseAdapter() {
			            public void valueChanged(ListSelectionEvent e) {
			            	valueChanged(e);
			            }
			        });
			  }
			}
		});
		panel_1.add(button_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 10, 392, 433);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setToolTipText(null);
		scrollPane.setViewportView(table_1);
		
		// 初始化表格数据
		columnName.add("车辆编号");
		columnName.add("修车日期");
		columnName.add("修车故障");
		columnName.add("修车费用");
		columnName.add("车辆ID");
	          Vector rowData = new Vector();
			// 初始化表格数据
			List<FixCar> list = Database.queryFixCarInfo();
			if (list != null && list.size() > 0) {
				for (int i=0;i<list.size();i++) {
					FixCar fixcar = list.get(i);
					Vector vector = new Vector();
					vector.add(fixcar.getId());
					vector.add(fixcar.getFixDate());
					vector.add(fixcar.getQuestion());
					vector.add(fixcar.getPrice());
					vector.add(fixcar.getCarID());
		
					rowData.add(vector);
				}
			}
		
			model = new DefaultTableModel(rowData, columnName) {
				// 设置表格中的数据不可以编辑
				public boolean isCellEditable(int r,int c) {
					return false;
				}
			};
			table_1 = new JTable(model);
			scrollPane.setViewportView(table_1);
		// 只可单选
				table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_1.getTableHeader().setReorderingAllowed(false);
				// 表格监听事件
				table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if (!e.getValueIsAdjusting()) {
						//支持单选
						int row=table_1.getSelectedRow();//选中行
						int col=table_1.getSelectedColumn();//选中列
						System.out.println("方法一:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,4));
						// 綁定值
						textField.setText(String.valueOf(table_1.getValueAt(row, 0)));
						textField_1.setText(String.valueOf(table_1.getValueAt(row, 1)));
						textField_2.setText(String.valueOf(table_1.getValueAt(row, 2)));
						textField_3.setText(String.valueOf(table_1.getValueAt(row, 3)));
						textField_4.setText(String.valueOf(table_1.getValueAt(row, 4)));
				
							}
						}
			});
	}
}
