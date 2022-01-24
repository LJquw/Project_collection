package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.Database;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;


public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("��������ϵͳ-����Ա��¼(201931101137����)");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 595, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�û���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(166, 124, 81, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(178, 198, 81, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(295, 124, 168, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 24));
		btnNewButton.setBounds(226, 273, 123, 52);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(295, 191, 168, 40);
		frame.getContentPane().add(passwordField);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText().trim();//trim()ȥ���ַ�����ͷβ�ո�,getText()��ȡ�ı���ǰ������
	            String password = new String(passwordField.getPassword()).trim();//passwordField��������
	            if (userName == null || "".equals(userName)) {
                    JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
                    return;
                }
                if (password == null || "".equals(password)) {
                    JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
                    return;
                }
                try {
                	  if (Database.adminLogin(userName, password)) {               		 
                		  frame.setVisible(false);
                		  new MainView().frame.setVisible(true);
                		  JOptionPane.showMessageDialog(null, "��¼�ɹ�");
                		  
                      } else {
                      	  JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ���˶Ե�¼��Ϣ");
                            return;
                      }
                } catch(Exception ex) {
                	ex.printStackTrace();
                	JOptionPane.showMessageDialog(null, "��¼ʧ��");
                    return;
                }
			}
		});
	}

	
}
