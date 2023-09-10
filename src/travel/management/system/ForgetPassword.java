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

public class ForgetPassword extends JFrame implements ActionListener{
	
	JLabel lblusername , lblname , lblquestion,lblanswer,lblpassword;
	JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
	JButton search,retrive,back;
	
	public ForgetPassword() {
		setBounds(350, 200, 900, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(30, 30, 550, 355);
//		p1.setBackground(new Color(133,193,200));
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(630, 100, 200,200);
		add(image);
		
		lblusername =new JLabel("Username");
		lblusername.setBounds(40, 20, 100, 25);
		lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p1.add(lblusername);
		
		tfusername =new JTextField();
		tfusername.setBounds(200, 20, 200, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
		
		search=new JButton("Search");
		search.setBounds(420, 20, 100, 25);
		search.setBackground(new Color(133,193,200));
		search.setForeground(Color.WHITE);
		search.setBorder(new LineBorder(new Color(133,193,200)));
		search.addActionListener(this);
		p1.add(search);
		
		lblname =new JLabel("Name");
		lblname.setBounds(40, 60, 100, 25);
		lblname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p1.add(lblname);
		
		tfname =new JTextField();
		tfname.setBounds(200, 60, 200, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		lblquestion =new JLabel("Security Question");
		lblquestion.setBounds(40, 100, 150, 25);
		lblquestion.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p1.add(lblquestion);
		
		tfquestion =new JTextField();
		tfquestion.setBounds(200, 100, 200, 25);
		tfquestion.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfquestion);
		
		
		lblanswer =new JLabel("Security answer");
		lblanswer.setBounds(40, 140, 150, 25);
		lblanswer.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p1.add(lblanswer);
		
		tfanswer =new JTextField();
		tfanswer.setBounds(200, 140, 200, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		retrive=new JButton("Retrive");
		retrive.setBounds(420, 140, 100, 25);
		retrive.setBackground(new Color(133,193,200));
		retrive.setForeground(Color.WHITE);
		retrive.setBorder(new LineBorder(new Color(133,193,200)));
		retrive.addActionListener(this);
		p1.add(retrive);
		
		lblpassword =new JLabel("Password");
		lblpassword.setBounds(40, 180, 150, 25);
		lblpassword.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		p1.add(lblpassword);
		
		tfpassword =new JTextField();
		tfpassword.setBounds(200, 180, 200, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		back=new JButton("Back");
		back.setBounds(180, 230, 170, 30);
		back.setFont(new Font("Tahoma",Font.BOLD,15));
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.setBorder(BorderFactory.createEmptyBorder());
		back.addActionListener(this);
		p1.add(back);
		
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent actionEvent) {
		
		if (actionEvent.getSource()==search) {
			
			String query="select * from account where username='"+tfusername.getText()+"'";
			try {
				DbCon c=new DbCon();
				ResultSet rs= c.s.executeQuery(query);
				
				while (rs.next()) {
					tfname.setText(rs.getString("name"));
					tfquestion.setText(rs.getString("security"));
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (actionEvent.getSource()==retrive)
		{
			String query="select * from account where answer='"+tfanswer.getText()+"'";
			try {
				DbCon c=new DbCon();
				ResultSet rs= c.s.executeQuery(query);
				
				while (rs.next()) {
					tfpassword.setText(rs.getString("password"));
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (actionEvent.getSource()==back)
		{
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
			ForgetPassword forgetPassword=new ForgetPassword();

	}

}
