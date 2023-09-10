package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class ViewCustomer extends JFrame implements ActionListener{
	
	JLabel lblusername,labelusername,lblid,labelid,lblno,labelno,lblname,labelname,lblgender,labelgender,lblcuntry,labelcuntry,labelemail,lblemail,labelcountry,lblcountry,lblpno,labelpno,labeladdress,lbladdress;
	JButton back;
	
	public ViewCustomer(String username) {
		setBounds(280, 120, 1000, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		lblusername =new JLabel("Username :");
		lblusername.setBounds(30, 50, 150, 25);
		lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblusername);
		
		labelusername =new JLabel();
		labelusername.setBounds(190, 50, 150, 25);
		labelusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelusername);
		
		lblname =new JLabel("Name :");
		lblname.setBounds(30, 110, 150, 25);
		lblname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblname);
		
		labelname =new JLabel();
		labelname.setBounds(190, 110, 150, 25);
		labelname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelname);
		
		lblgender =new JLabel("Gender :");
		lblgender.setBounds(30, 170, 150, 25);
		lblgender.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblgender);
		
		labelgender =new JLabel();
		labelgender.setBounds(190, 170, 150, 25);
		labelgender.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelgender);
		
		lblid =new JLabel("Id :");
		lblid.setBounds(30, 230, 150, 25);
		lblid.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblid);
		
		labelid =new JLabel();
		labelid.setBounds(190, 230, 150, 25);
		labelid.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelid);
		
		
		lblno =new JLabel("Id Number :");
		lblno.setBounds(30, 290, 150, 25);
		lblno.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblno);
		
		labelno =new JLabel();
		labelno.setBounds(190, 290, 150, 25);
		labelno.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelno);
		
		
		lblcountry =new JLabel("Country :");
		lblcountry.setBounds(500, 50, 150, 25);
		lblcountry.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblcountry);
		
		labelcountry =new JLabel();
		labelcountry.setBounds(690, 50, 150, 25);
		labelcountry.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelcountry);
		
		
		lbladdress =new JLabel("Address");
		lbladdress.setBounds(500, 110, 150, 25);
		lbladdress.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lbladdress);
		
		labeladdress =new JLabel();
		labeladdress.setBounds(690, 110, 150, 25);
		labeladdress.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labeladdress);
		
		
		lblpno =new JLabel("Phone No. :");
		lblpno.setBounds(500, 170, 150, 25);
		lblpno.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblpno);
		
		labelpno =new JLabel();
		labelpno.setBounds(690, 170, 150, 25);
		labelpno.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelpno);
		
		
		lblemail =new JLabel("Email :");
		lblemail.setBounds(500, 230, 150, 25);
		lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblemail);
		
		labelemail =new JLabel();
		labelemail.setBounds(690, 230, 250, 25);
		labelemail.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelemail);
		
		back =new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(450, 350, 100, 30);
		back.setBorder(new LineBorder(Color.BLACK));
		back.addActionListener(this);
		add(back);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(10, 400, 600, 200);
		add(image);
		
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5=i4.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel imagee=new JLabel(i6);
		imagee.setBounds(610, 400, 600, 200);
		add(imagee);
		
		
		try {
			
			DbCon c=new DbCon();
			String query="select * from customer where username='"+username+"'";
			ResultSet rs= c.s.executeQuery(query);
			
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelid.setText(rs.getString("id"));
				labelcountry.setText(rs.getString("country"));
				labelpno.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
				labeladdress.setText(rs.getString("address"));
				labelno.setText(rs.getString("number"));
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Dashboard("");
		}
	}
	
	
	
	public static void main(String[] args) {
		new ViewCustomer("");

	}

}
