package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener{
	
	JButton login,signup,password;
	JTextField tfusername,tfpassword;
	
	public Login() {
		setSize(900,450);
		setLocation(350,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		JPanel p1=new JPanel();
		p1.setBackground(new Color(131,193,200));
		p1.setBounds(0, 0, 400, 450);
		p1.setLayout(null);
		
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(100, 120, 200, 200);
		p1.add(image);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(400, 30, 450, 350);
		add(p2);
		
		JLabel lblusername =new JLabel("Username");
		lblusername.setBounds(60, 20, 100, 25);
		lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p2.add(lblusername);
		
		tfusername =new JTextField();
		tfusername.setBounds(60, 60, 300, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);
		
		
		JLabel lblpassword =new JLabel("Password");
		lblpassword.setBounds(60, 110, 100, 25);
		lblpassword.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p2.add(lblpassword);
		
		tfpassword =new JTextField();
		tfpassword.setBounds(60, 150, 300, 30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
		login=new JButton("Login");
		login.setBounds(60, 200, 130, 30);
		login.setBackground(new Color(133,193,200));
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(133,193,200)));
		login.addActionListener(this);
		p2.add(login);

		signup =new JButton("Signp");
		signup.setBounds(230, 200, 130, 30);
		signup.setBackground(new Color(133,193,200));
		signup.setForeground(Color.WHITE);
		signup.setBorder(new LineBorder(new Color(133,193,200)));
		signup.addActionListener(this);
		p2.add(signup);
		
		password =new JButton("Forget Password");
		password.setBounds(130, 250, 130, 30);
		password.setBackground(new Color(133,193,200));
		password.setForeground(Color.WHITE);
		password.setBorder(new LineBorder(new Color(133,193,200)));
		password.addActionListener(this);
		p2.add(password);
		
		JLabel text= new JLabel("Trouble in login!!!");
		text.setBounds(300, 260, 150, 20);
		text.setForeground(Color.RED);
		p2.add(text);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			try {
				String username=tfusername.getText();
				String pass=tfpassword.getText();
				
				String query="select * from account where username='"+username+"' AND password='"+pass+"'";
				DbCon c=new DbCon();
				ResultSet rs= c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");
				}
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new Signup();
		}
		else if(e.getSource()==password) {
			setVisible(false);
			new ForgetPassword();
		}
		
	}
	
	
	public static void main(String[] args) {
		Login l1=new Login();
	}



}
