package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateCustomer extends JFrame implements ActionListener  {
	
	JLabel lblheading,lblusername,labelusername,lblname,lblgender,lblid,lblnumber,lblcountry,lbladdress,lblemail,lblpno;
	JComboBox cid,ccountry;
	JTextField tfnumber,tfaddress,tfemail,tfpno,tfname;
	JRadioButton rmale,rfemale,rother;
	JButton add,back;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UpdateCustomer(String username) throws Exception {

		setBounds(320, 170, 900, 500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		lblheading =new JLabel("Update Personal Details");
		lblheading.setBounds(110, 0, 250, 25);
		lblheading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lblheading);
		
		lblusername =new JLabel("Username");
		lblusername.setBounds(30, 40, 150, 25);
		lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblusername);
		
		labelusername =new JLabel();
		labelusername.setBounds(220, 40, 150, 25);
		labelusername.setFont(new Font("SAN_SERIF",Font.BOLD,14));
		add(labelusername);
		
		lblname =new JLabel("Name");
		lblname.setBounds(30, 80, 150, 25);
		lblname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblname);
		
		tfname =new JTextField();
		tfname.setBounds(220, 80, 200, 25);
//		tfname.setBorder(BorderFactory.createEmptyBorder());
		add(tfname);
		
		lblgender =new JLabel("Gender");
		lblgender.setBounds(30, 120, 150, 25);
		lblgender.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblgender);
		
		rmale=new JRadioButton("Male");
		rmale.setBounds(220, 120, 70, 25);
		rmale.setBackground(Color.WHITE);
		add(rmale);
		
		rfemale=new JRadioButton("Female");
		rfemale.setBounds(300, 120, 70, 25);
		rfemale.setBackground(Color.WHITE);
		add(rfemale);
		
		rother=new JRadioButton("Other");
		rother.setBounds(380, 120, 70, 25);
		rother.setBackground(Color.WHITE);
		add(rother);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		bg.add(rother);
		
		
		
		
		lblcountry =new JLabel("Country");
		lblcountry.setBounds(30, 160, 150, 25);
		lblcountry.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblcountry);
		
		ccountry=new JComboBox(new String [] {"India","SriLanka","Nepal","US"});
		ccountry.setBounds(220, 160, 200, 25);
		ccountry.setBackground(Color.WHITE);
		add(ccountry);
		
		lblid =new JLabel("Id");
		lblid.setBounds(30, 200, 150, 25);
		lblid.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblid);
		
		
		cid=new JComboBox(new String [] {"Passport","Adhar Card","Pan Card","Driving License"});
		
		cid.setBounds(220, 200, 200, 25);
		cid.setBackground(Color.WHITE);
		add(cid);
		
		lblnumber =new JLabel("Id Number");
		lblnumber.setBounds(30, 240, 150, 25);
		lblnumber.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblnumber);
		
		tfnumber =new JTextField();
		tfnumber.setBounds(220, 240, 200, 25);
//		tfnumber.setBorder(BorderFactory.createEmptyBorder());
		add(tfnumber);
		
		lbladdress =new JLabel("Adress");
		lbladdress.setBounds(30, 280, 150, 25);
		lbladdress.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lbladdress);
		
		tfaddress =new JTextField();
		tfaddress.setBounds(220, 280, 200, 25);
		add(tfaddress);
		
		lblemail =new JLabel("Email");
		lblemail.setBounds(30, 320, 150, 25);
		lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblemail);
		
		tfemail =new JTextField();
		tfemail.setBounds(220, 320, 200, 25);
		add(tfemail);
		
		lblpno =new JLabel("Mobile No.");
		lblpno.setBounds(30, 360, 150, 25);
		lblpno.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblpno);
		
		tfpno =new JTextField();
		tfpno.setBounds(220, 360, 200, 25);
		add(tfpno);
		
		add=new JButton("Update");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(70, 410, 100, 30);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(220, 410, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2=i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(450, 10, 430, 430);
		add(image);
		
			DbCon con=new DbCon();
			ResultSet rs= con.s.executeQuery("select * from customer where username='"+username+"'");
			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				tfname.setText(rs.getString("name"));
				tfaddress.setText(rs.getString("address"));
				tfnumber.setText(rs.getString("number"));
				tfpno.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				
				} 
		
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==add) {
		DbCon con=new DbCon();
		String radio =null;
		if (rmale.isSelected()) {
			radio="Male";
		}
		else if (rfemale.isSelected()) {
			radio="Female";
		}
		else if (rother.isSelected()) {
			radio="Other";
		}
		try {
		String username=labelusername.getText();
		String name=tfname.getText();
		String gender=radio;
		String country=(String)ccountry.getSelectedItem();
		String id=(String)cid.getSelectedItem();
		String number =tfnumber.getText();
		String address=tfaddress.getText();
		String email=tfemail.getText();
		String phone =tfpno.getText();
		
			
			
			String query="update customer set name='"+name+"', id='"+id+"', number='"+number+"', gender='"+gender+"', country='"+country+"', address='"+address+"', phone='"+phone+"', email='"+email+"' where username='"+username+"'";
			con.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, " Customers Details Updated Successfully");
			setVisible(false);
			
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch(NumberFormatException s){
			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
}
		
		
	}
	else {
		setVisible(false);
//		new Dashboard("");
	}
	
			
}

	
	
	
	public static void main(String[] args) {
		try {
			UpdateCustomer add1= new UpdateCustomer("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
