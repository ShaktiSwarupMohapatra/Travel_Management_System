package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookPackage extends JFrame implements ActionListener{

	
	JLabel lblusername,labelusername,labelprice,lblprice,lblPackage,lblperson,lblid,labelid,lblnumber,labelnumber,lblphone,labelphone,lblemail,labelemail;
	JTextField tfperson;
	Choice cpackage;
	String username;
	JButton checkprice,bookpackages,back;
	
	
	public BookPackage(String username) {
		this.username=username;
		setBounds(270, 100, 1000, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text =new JLabel("Book Package");
		text.setBounds(110, 10, 250, 30);
		text.setFont((new Font("Tahoma",Font.BOLD,20)));
		add(text);
	
		lblusername =new JLabel("Username :");
		lblusername.setBounds(40, 70, 150, 20);
		lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblusername);


		labelusername =new JLabel();
		labelusername.setBounds(250, 70, 150, 20);
		labelusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelusername);
	
		
		lblPackage =new JLabel("Select Package :");
		lblPackage.setBounds(40, 110, 150, 20);
		lblPackage.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblPackage);
		
		
		cpackage=new Choice();
		cpackage.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		cpackage.add("Gold Package");
		cpackage.add("Silver Package");
		cpackage.add("Bronze Package");
		cpackage.setBounds(250, 110, 200, 25);
		add(cpackage);
		

		lblperson =new JLabel("Total Persons :");
		lblperson.setBounds(40, 150, 150, 20);
		lblperson.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblperson);
		
		tfperson =new JTextField("1");
		tfperson.setBounds(250, 150, 200, 25);
		add(tfperson);
		
		lblid =new JLabel("Id :");
		lblid.setBounds(40, 190, 150, 20);
		lblid.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblid);
		
		
		labelid =new JLabel();
		labelid.setBounds(250, 190, 200, 25);
		labelid.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelid);

		lblnumber =new JLabel("Id Number :");
		lblnumber.setBounds(40, 230, 150, 20);
		lblnumber.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblnumber);
		
		
		labelnumber =new JLabel();
		labelnumber.setBounds(250, 230, 200, 25);
		labelnumber.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelnumber);
		
		
		lblphone =new JLabel("Phone :");
		lblphone.setBounds(40, 270, 150, 20);
		lblphone.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblphone);
		
		
		labelphone =new JLabel();
		labelphone.setBounds(250, 270, 200, 25);
		labelphone.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelphone);
		
		
		lblemail =new JLabel("Email :");
		lblemail.setBounds(40, 310, 150, 20);
		lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblemail);
		
		
		labelemail =new JLabel();
		labelemail.setBounds(250, 310, 240, 25);
		labelemail.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(labelemail);
		
		lblprice =new JLabel("Total Price :");
		lblprice.setBounds(40, 350, 150, 20);
		lblprice.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(lblprice);
		
		
		labelprice =new JLabel();
		labelprice.setBounds(250, 350, 200, 25);
		labelprice.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		labelprice.setForeground(Color.RED);
		add(labelprice);
		
		
		try {
			
			DbCon c=new DbCon();
			String query="select * from customer where username='"+username+"'";
			ResultSet rs= c.s.executeQuery(query);
			
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
				
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		checkprice =new JButton("Check Price");
		checkprice.setBackground(Color.BLACK);
		checkprice.setForeground(Color.WHITE);
		checkprice.setBounds(60, 400, 120, 25);
		checkprice.addActionListener(this);
		add(checkprice);
		
		
		bookpackages =new JButton("Book Package");
		bookpackages.setBackground(Color.BLACK);
		bookpackages.setForeground(Color.WHITE);
		bookpackages.setBounds(200, 400, 120, 25);
		bookpackages.addActionListener(this);
		add(bookpackages);
		
		
		back =new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(340, 400, 120, 25);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==checkprice)
		{
			String pack=cpackage.getSelectedItem();
			int cost=0;
			if(pack.equals("Gold Package")) {
				cost+=12000;
			}
			else if(pack.equals("Silver Package")) {
				cost+=25000;
			}
			else {
				cost+=32000;
			}
			int person=Integer.parseInt(tfperson.getText());
			cost*=person;
			labelprice.setText("Rs "+cost);
		}
		else if (ae.getSource()==bookpackages) {
			try {
				DbCon con=new DbCon();
				con.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelemail.getText()+"') ");
				JOptionPane.showMessageDialog(null, "Package Booked Succesfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new BookPackage("");

	}

}
