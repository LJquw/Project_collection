package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Car;
import util.Database;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CarInfoView extends JFrame{

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
	private static Connection con=null;
	
	/**
	 * Launch the application.
	 */
	private Vector<String> columnName = new Vector();
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarInfoView window = new CarInfoView();
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
	public CarInfoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();//������
		frame.setTitle("��������ϵͳ(201931101137����)");
		frame.setFont(new Font("Dialog", Font.PLAIN, 30));
		frame.setBounds(100, 100, 595, 499);//(x���꣬y���꣬��ȣ�����)
		frame.getContentPane().setBackground(Color.PINK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel_1 = new JPanel();//��ť��
		panel_1.setBounds(422, 10, 151,431);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("�������");//��ǩ��ʾ
		label.setBounds(38, 10, 93, 17);
		panel_1.add(label);
		
		textField = new JTextField();//������
		textField.setBounds(27, 35, 77, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("��������");
		lblNewLabel.setBounds(38, 66, 93, 17);
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 91, 77, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("������ɫ");
		lblNewLabel_1.setBounds(38, 122, 93, 17);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 147, 77, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("��������");
		lblNewLabel_2.setBounds(38, 178, 93, 17);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(27, 203, 77, 25);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("�������");
		lblNewLabel_3.setBounds(38, 234, 93, 17);
		panel_1.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(27, 259, 77, 25);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		// ������ť
		button_1 = new JButton("���");
		button_1.setBounds(27, 307, 77, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()ȥ���ַ�����ͷβ�ո�,getText()��ȡ�ı���ǰ������
				String name = textField_1.getText().trim();
				String color = textField_2.getText().trim();
				String type = textField_3.getText().trim();
				Float price = Float.valueOf(textField_4.getText().trim());
				Car car =new Car(id,name,color,type,price);
				if (e.getSource() == button_1) {
					if (name == null || "".equals(name)) {
						JOptionPane.showMessageDialog(null, "�������Ʋ���Ϊ��");
	                    return;
					}
					if (color == null || "".equals(color)) {
						JOptionPane.showMessageDialog(null, "������ɫ����Ϊ��");
	                    return;
					}
					if (type == null || "".equals(type)) {
						JOptionPane.showMessageDialog(null, "�������Ͳ���Ϊ��");
	                    return;
					}
					if (price == null || "".equals(price)) {
						JOptionPane.showMessageDialog(null, "���������Ϊ��");
	                    return;
					}
					new Database().addCarInfo(car);
			        JOptionPane.showMessageDialog(null, "��ӳɹ�");
				}
			}
		});
		panel_1.add(button_1);
		
		button_2 = new JButton("�޸�");
		button_2.setBounds(27, 340, 77, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()ȥ���ַ�����ͷβ�ո�,getText()��ȡ�ı���ǰ������
				String name = textField_1.getText().trim();
				String color = textField_2.getText().trim();
				String type = textField_3.getText().trim();
				Float price = Float.valueOf(textField_4.getText().trim());
				Car car =new Car(id,name,color,type,price);
				if (e.getSource() == button_2) {
					if (name == null || "".equals(name)) {
						JOptionPane.showMessageDialog(null, "�������Ʋ���Ϊ��");
	                    return;
					}
					if (color == null || "".equals(color)) {
						JOptionPane.showMessageDialog(null, "������ɫ����Ϊ��");
	                    return;
					}
					if (type == null || "".equals(type)) {
						JOptionPane.showMessageDialog(null, "�������Ͳ���Ϊ��");
	                    return;
					}
					if (price == null || "".equals(price)) {
						JOptionPane.showMessageDialog(null, "���������Ϊ��");
	                    return;
					}
					new Database().updateCarInfo(car);
			        JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				}
			}
		});
		panel_1.add(button_2);
		
		button_3 = new JButton("ɾ��");
		button_3.setBounds(27, 373, 77, 23);
		button_3.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()ȥ���ַ�����ͷβ�ո�,getText()��ȡ�ı���ǰ������
				if (e.getSource() == button_3) {
					if (id == 0 || "".equals(id)) {
						JOptionPane.showMessageDialog(null, "������Ų���Ϊ��");
	                    return;
					}
					new Database().deleteCarInfo(id);
			        JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}
			}
		});
		panel_1.add(button_3);
		
		
		button_4 = new JButton("ˢ��");
		button_4.setBounds(27, 406, 77, 23);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if (e.getSource() == button_4) {
					// ˢ�±�������¼�
				  table_1.removeAll();
       	          Vector rowData = new Vector();
					// ��ʼ���������
					List<Car> list = Database.queryCarInfo();
					if (list != null && list.size() > 0) {
						for (int i=0;i<list.size();i++) {
							Car car = list.get(i);
							Vector vector = new Vector();
							vector.add(car.getId());
							vector.add(car.getName());
							vector.add(car.getColor());
							vector.add(car.getType());
							vector.add(car.getPrice());
				
							rowData.add(vector);
						}
					}
				
					model = new DefaultTableModel(rowData, columnName) {
						// ���ñ���е����ݲ����Ա༭
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
		
		scrollPane = new JScrollPane();//����
		scrollPane.setBounds(15, 10, 392, 431);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setToolTipText(null);
     	scrollPane.setViewportView(table_1);
		
		// ��ʼ���������
		columnName.add("�������");
		columnName.add("��������");
		columnName.add("������ɫ");
		columnName.add("��������");
		columnName.add("�������");
		Vector rowData = new Vector();//
		List<Car> list = Database.queryCarInfo();
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
	
				rowData.add(vector);
			}
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
//		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table_1.getTableHeader().setReorderingAllowed(false);
		// �������¼�
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (!e.getValueIsAdjusting()) {
				//֧�ֵ�ѡ
				int row=table_1.getSelectedRow();//ѡ����
				int col=table_1.getSelectedColumn();//ѡ����
				System.out.println("����һ:"+table_1.getValueAt(row, 0)+"\t"+table_1.getValueAt(row,4));
				// ����ֵ
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
