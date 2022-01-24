package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.RepayCar;
import util.Database;

public class RepayCarView extends JFrame{

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
					RepayCarView window = new RepayCarView();
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
	public RepayCarView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("������Ϣ����(201931101137����)");
		frame.setFont(new Font("Dialog", Font.PLAIN, 30));
		frame.setBounds(100, 100, 595, 499);
		frame.getContentPane().setBackground(Color.PINK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setVisible(true);
		
		JPanel panel_1 = new JPanel();//��ť��
		panel_1.setBounds(422, 10, 151,433);
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
		
		JLabel lblNewLabel = new JLabel("����ʱ��");
		lblNewLabel.setBounds(38, 66, 93, 17);
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 91, 77, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("�����û�");
		lblNewLabel_1.setBounds(38, 122, 93, 17);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 147, 77, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("����״̬");
		lblNewLabel_2.setBounds(38, 178, 93, 17);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(27, 203, 77, 25);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("����ID");
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
				String repayDate = textField_1.getText().trim();
				String users = textField_2.getText().trim();
				String state = textField_3.getText().trim();
				int carID = Integer.valueOf(textField_4.getText().trim());
				RepayCar repaycar =new RepayCar(id,repayDate,users,state,carID);
				if (e.getSource() == button_1) {
					if (repayDate == null || "".equals(repayDate)) {
						JOptionPane.showMessageDialog(null, "�������ڲ���Ϊ��");
	                    return;
					}
					if (users == null || "".equals(users)) {
						JOptionPane.showMessageDialog(null, "�����û�����Ϊ��");
	                    return;
					}
					if (state == null || "".equals(state)) {
						JOptionPane.showMessageDialog(null, "����״̬����Ϊ��");
	                    return;
					}
					if (carID == 0 || "".equals(carID)) {
						JOptionPane.showMessageDialog(null, "����ID����Ϊ��");
	                    return;
					}
					new Database().addRepayCarInfo(repaycar);
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
				String repayDate = textField_1.getText().trim();
				String users = textField_2.getText().trim();
				String state = textField_3.getText().trim();
				int carID = Integer.valueOf(textField_4.getText().trim());
				RepayCar repaycar =new RepayCar(id,repayDate,users,state,carID);
				if (e.getSource() == button_2) {
					if (repayDate == null || "".equals(repayDate)) {
						JOptionPane.showMessageDialog(null, "�������ڲ���Ϊ��");
	                    return;
					}
					if (users == null || "".equals(users)) {
						JOptionPane.showMessageDialog(null, "�����û�����Ϊ��");
	                    return;
					}
					if (state == null || "".equals(state)) {
						JOptionPane.showMessageDialog(null, "����״̬����Ϊ��");
	                    return;
					}
					if (carID == 0 || "".equals(carID)) {
						JOptionPane.showMessageDialog(null, "����ID����Ϊ��");
	                    return;
					}
					new Database().updateRepayCarInfo(repaycar);
			        JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				}
			}
		});
		panel_1.add(button_2);
		
		button_3 = new JButton("ɾ��");
		button_3.setBounds(27, 373, 77, 23);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText().trim());//trim()ȥ���ַ�����ͷβ�ո�,getText()��ȡ�ı���ǰ������
				if (e.getSource() == button_3) {
					if (id == 0 || "".equals(id)) {
						JOptionPane.showMessageDialog(null, "������Ų���Ϊ��");
	                    return;
					}
					new Database().deleteRapayCarInfo(id);
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
					List<RepayCar> list = Database.queryRepayCarInfo();
					if (list != null && list.size() > 0) {
						for (int i=0;i<list.size();i++) {
							RepayCar repaycar = list.get(i);
							Vector vector = new Vector();
							vector.add(repaycar.getId());
							vector.add(repaycar.getRepayDate());
							vector.add(repaycar.getUsers());
							vector.add(repaycar.getState());
							vector.add(repaycar.getCarID());
				
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
		scrollPane.setBounds(15, 10, 392, 433);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setToolTipText(null);
		scrollPane.setViewportView(table_1);
		
		// ��ʼ���������
		columnName.add("�������");
		columnName.add("��������");
		columnName.add("�����û�");
		columnName.add("����״̬");
		columnName.add("����ID");
		Vector rowData = new Vector();
		// ��ʼ���������
		List<RepayCar> list = Database.queryRepayCarInfo();
		if (list != null && list.size() > 0) {
			for (int i=0;i<list.size();i++) {
				RepayCar repaycar = list.get(i);
				Vector vector = new Vector();
				vector.add(repaycar.getId());
				vector.add(repaycar.getRepayDate());
				vector.add(repaycar.getUsers());
				vector.add(repaycar.getState());
				vector.add(repaycar.getCarID());
	
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
				table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_1.getTableHeader().setReorderingAllowed(false);
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
