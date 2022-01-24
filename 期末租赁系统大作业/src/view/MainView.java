package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class MainView {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
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
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	     frame = new JFrame("车辆管理系统(201931101137柳均)");
//	    ImageIcon icon1=new ImageIcon("D:\\Documents\\Java-目录\\大作业\\期末租赁系统大作业\\imgs\\17.jpg" );
//        //添加JLabel 放置图片
//        JLabel label1=new JLabel(icon1);
//        label1.setBounds(100, 100, 595, 507);

		frame.setBounds(100, 100, 595, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton_1 = new JButton("车辆信息管理");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarInfoView().frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10,128,270,58);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("租车信息管理");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RentCarView().frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(289,233,270,58);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("还车信息管理");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepayCarView().frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10,233,270,58);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("修车信息管理");
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FixCarView().frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(289,128,270,58);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("查询信息");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfitView().frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(9,334,550,58);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("       \u6C7D   \u8F66   \u79DF   \u8D41   \u7CFB   \u7EDF ");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 39, 573, 40);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
