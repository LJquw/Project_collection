
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;

public class Login {
    JTextField j2;
    JPasswordField j4;
    JButton j5;
    public Login()
    {

        //插入图片
        ImageIcon icon1=new ImageIcon("D:\\CarSystem\\pic\\16.jpg" );
        //添加JLabel 放置图片
        JLabel label1=new JLabel(icon1);
        //设置label的位置、大小，label大小为图片的大小
        label1.setBounds(0, 0, 600, 450);

        //JFrame框架
        JFrame frame=new JFrame("登陆界面");
        //在frame的底层容器添加label


        //panel


        JLabel label=new JLabel("汽 车 租 赁 系 统");
        label.setFont(new Font("隶书",Font.BOLD,50));
        label.setForeground(Color.ORANGE);
        label.setBounds(95,30,500,80);

        //label0，这个是对界面的自定义操作，用作效果展示
        JLabel j1=new JLabel("姓名:");
        j1.setForeground(Color.orange);
        j1.setFont(new Font("微软黑体",Font.BOLD,20));
        j1.setBounds(130, 135, 60, 50);

        j2= new JTextField(10);
        j2.setBounds(180, 150, 200, 20);

        JLabel j3= new JLabel("密码:");
        j3.setFont(new Font("微软黑体",Font.BOLD,20));
        j3.setForeground(Color.orange);
        j3.setBounds(130, 185, 60, 50);

        j4=new JPasswordField(10);
        j4.setBounds(180, 200, 200, 20);

        j5=new JButton("登录");
        j5.setBounds(220, 260, 100, 30);


        Container c=frame.getContentPane();

        c.add(label);
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(j5);
        c.add(label1);


        //添加panel，设置大小，可视

        frame.setBounds(300, 200, 600, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EVENT();
    }
    public void EVENT(){
     j5.addActionListener(arg0 -> {
         if(j2.getText().equals("")&&j4.getText().equals("")){
             System.out.println("登陆成功！");
             JOptionPane.showMessageDialog(null, "登录成功！");
             new Carsystem();

         }
         else {
             System.out.println("登录失败！");
             JOptionPane.showMessageDialog(null, "登录失败！");
         }
         j2.setText("");
         j4.setText("");
    });
    }
}

