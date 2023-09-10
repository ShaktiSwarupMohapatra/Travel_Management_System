package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Signup extends JFrame implements ActionListener {
	
	JButton create,back;
	JTextField tfusername,tfpassword,tfname,tfanswer;
	Choice security;
	
	Signup(){
		setBounds(350, 200, 900, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setBackground(new Color(133,193,200));
		p1.setBounds(0, 0, 500, 450);
		p1.setLayout(null);
		add(p1);
		
		JLabel lblusername =new JLabel("Username :");
		lblusername.setBounds(50, 40, 100, 25);
		lblusername.setFont(new Font("Tahoma",Font.BOLD,15));
		p1.add(lblusername);
		
		tfusername =new JTextField();
		tfusername.setBounds(200, 40, 250, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
		
		JLabel lblname =new JLabel("Name :");
		lblname.setBounds(50, 90, 100, 25);
		lblname.setFont(new Font("Tahoma",Font.BOLD,15));
		p1.add(lblname);
		
		tfname =new JTextField();
		tfname.setBounds(200, 90, 250, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		JLabel lblpassword =new JLabel("Password :");
		lblpassword.setBounds(50, 140, 100, 25);
		lblpassword.setFont(new Font("Tahoma",Font.BOLD,15));
		p1.add(lblpassword);
		
		tfpassword =new JTextField();
		tfpassword.setBounds(200, 140, 250, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		JLabel lblsecurity =new JLabel("Security Question");
		lblsecurity.setBounds(50, 190, 145, 25);
		lblsecurity.setFont(new Font("Tahoma",Font.BOLD,15));
		p1.add(lblsecurity);
		
		security =new Choice();
		security.setFont(new Font("Tahoma",Font.PLAIN,15));
		security.add("Fav Movie Name");
		security.add("Fav Hero Name");
		security.add("Fav Character from Shaktiman");
		security.add("Fav Star Name");
		security.add("Fav Youtuber");
		security.setBounds(200, 190, 250, 25);
		p1.add(security);
		
		JLabel lblanswer =new JLabel("Answer :");
		lblanswer.setBounds(50, 240, 100, 25);
		lblanswer.setFont(new Font("Tahoma",Font.BOLD,15));
		p1.add(lblanswer);
		
		tfanswer =new JTextField();
		tfanswer.setBounds(200, 240, 250, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		create=new JButton("Create");
		create.setBounds(50, 300, 170, 30);
		create.setFont(new Font("Tahoma",Font.BOLD,15));
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(133,193,200));
		create.setBorder(new LineBorder(new Color(133,193,200)));
		create.addActionListener(this);
		p1.add(create);
		
		
		back=new JButton("Back");
		back.setBounds(280, 300, 170, 30);
		back.setFont(new Font("Tahoma",Font.BOLD,15));
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(133,193,200));
		back.setBorder(new LineBorder(new Color(133,193,200)));
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(600, 85, 200, 200);
		add(image);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		if (actionEvent.getSource()==create) {
			String username=tfusername.getText();
			String name=tfname.getText();
			String password=tfpassword.getText();
			String question =security.getSelectedItem();
			String answer=tfanswer.getText();
			
			String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
			try {
				DbCon c=new DbCon();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				setVisible(false);
				new Login();
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
		Signup s1=new Signup();

	}

}
