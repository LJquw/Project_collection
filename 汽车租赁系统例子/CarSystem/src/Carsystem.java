import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carsystem extends JFrame {
        public Carsystem(){

            //JFram 为一个窗口，参数名字为窗口名称。
            JFrame frame=new JFrame("车辆租赁系统");

            ImageIcon icon1=new ImageIcon("D:\\CarSystem\\pic\\17.jpg" );
            //添加JLabel 放置图片
            JLabel label1=new JLabel(icon1);
            //设置label的位置、大小，label大小为图片的大小
            label1.setBounds(0, 0, 600, 450);



            //向内容面板添加控件，如JLabel，JButton
            JLabel label=new JLabel("汽 车 租 赁 系 统");
            label.setFont(new Font("微软黑体",Font.BOLD,50));
            label.setForeground(Color.darkGray);
            label.setBounds(115,10,500,80);

            JButton button=new JButton("车辆信息管理");
            button.setFont(new Font("微软黑体",Font.BOLD,20));
            button.setBounds(70,120,200,80);

            JButton button2=new JButton("租车信息管理");
            button2.setFont(new Font("微软黑体",Font.BOLD,20));
            button2.setBounds(330,120,200,80);

            JButton button3=new JButton("还车信息管理");
            button3.setFont(new Font("微软黑体",Font.BOLD,20));
            button3.setBounds(70,225,200,80);

            JButton button5=new JButton("利润分析");
            button5.setFont(new Font("微软黑体",Font.BOLD,20));
            button5.setBounds(330,225,200,80);

            Container contentPane=frame.getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label);
            contentPane.add(button);
            contentPane.add(button2);
            contentPane.add(button3);
            contentPane.add(button5);
            contentPane.add(label1);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AllCar();
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   new UnLeased();
                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Retnrncar();
                }
            });
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Profit();
                }
            });
            //设置窗口其他参数，如大小。
            frame.setBounds(300, 200, 600, 450);
            //关闭方式
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //显示窗口
            frame.setVisible(true);
        }

    }


