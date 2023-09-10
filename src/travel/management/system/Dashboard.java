package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Dashboard extends JFrame implements ActionListener {
	String username;
	JButton bookpackages,checkpackages,addpersonalDetails,viewpersonalDetails,updatepersonalDetails,viewpackages;
	public Dashboard(String username) {
		this.username = username;
//		setBounds(00, 0, 1600, 1000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0, 0, 1600, 60);
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel icon=new JLabel(i3);
		icon.setBounds(5, 0, 70, 60);
		p1.add(icon);
		
		JLabel heading =new JLabel("Dashboard");
		heading.setBounds(80, 10, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		p1.add(heading);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0, 60, 300, 900);
		add(p2);
		
		addpersonalDetails=new JButton("Add Personal Details");
		addpersonalDetails.setBounds(0, 0, 300, 52);
		addpersonalDetails.setBackground(new Color(0,0,102));
		addpersonalDetails.setForeground(Color.WHITE);
		addpersonalDetails.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		addpersonalDetails.setMargin(new Insets(0, 0, 0, 60));
//		addpersonalDetails.setBorder(new LineBorder(new Color(133,193,200)));
		addpersonalDetails.addActionListener(this);
		p2.add(addpersonalDetails);
		
		
		updatepersonalDetails=new JButton("Update Personal Details");
		updatepersonalDetails.setBounds(0, 52, 300, 52);
		updatepersonalDetails.setBackground(new Color(0,0,102));
		updatepersonalDetails.setForeground(Color.WHITE);
		updatepersonalDetails.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		updatepersonalDetails.setMargin(new Insets(0, 0, 0, 30));
//		updatepersonalDetails.setBorder(new LineBorder(new Color(133,193,200)));
		updatepersonalDetails.addActionListener(this);
		p2.add(updatepersonalDetails);
		
		
		viewpersonalDetails=new JButton("View Personal Details");
		viewpersonalDetails.setBounds(0, 104, 300, 52);
		viewpersonalDetails.setBackground(new Color(0,0,102));
		viewpersonalDetails.setForeground(Color.WHITE);
		viewpersonalDetails.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		viewpersonalDetails.setMargin(new Insets(0, 0, 0, 50));
//		viewpersonalDetails.setBorder(new LineBorder(new Color(133,193,200)));
		viewpersonalDetails.addActionListener(this);
		p2.add(viewpersonalDetails);
		
		
		JButton deletepersonalDetails=new JButton("Delete Personal Details");
		deletepersonalDetails.setBounds(0, 156, 300, 52);
		deletepersonalDetails.setBackground(new Color(0,0,102));
		deletepersonalDetails.setForeground(Color.WHITE);
		deletepersonalDetails.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		deletepersonalDetails.setMargin(new Insets(0, 0, 0, 32));
//		deletepersonalDetails.setBorder(new LineBorder(new Color(133,193,200)));
//		deletepersonalDetails.addActionListener(this);
		p2.add(deletepersonalDetails);
		
		
		checkpackages=new JButton("Check Packages");
		checkpackages.setBounds(0, 208, 300, 52);
		checkpackages.setBackground(new Color(0,0,102));
		checkpackages.setForeground(Color.WHITE);
		checkpackages.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		checkpackages.setMargin(new Insets(0, 0, 0, 95));
//		checkpackages.setBorder(new LineBorder(new Color(133,193,200)));
		checkpackages.addActionListener(this);
		p2.add(checkpackages);
		
		
		bookpackages=new JButton("Book Packages");
		bookpackages.setBounds(0, 260, 300, 52);
		bookpackages.setBackground(new Color(0,0,102));
		bookpackages.setForeground(Color.WHITE);
		bookpackages.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		bookpackages.setMargin(new Insets(0, 0, 0, 105));
//		bookpackages.setBorder(new LineBorder(new Color(133,193,200)));
		bookpackages.addActionListener(this);
		p2.add(bookpackages);
		
		
		viewpackages=new JButton("View Packages");
		viewpackages.setBounds(0, 312, 300, 52);
		viewpackages.setBackground(new Color(0,0,102));
		viewpackages.setForeground(Color.WHITE);
		viewpackages.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		viewpackages.setMargin(new Insets(0, 0, 0, 110));
//		viewpackages.setBorder(new LineBorder(new Color(133,193,200)));
//		viewpackages.addActionListener(this);
		p2.add(viewpackages);
		
		
		JButton viewhotels=new JButton("View Hotels");
		viewhotels.setBounds(0, 364, 300, 52);
		viewhotels.setBackground(new Color(0,0,102));
		viewhotels.setForeground(Color.WHITE);
		viewhotels.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		viewhotels.setMargin(new Insets(0, 0, 0, 140));
//		viewhotels.setBorder(new LineBorder(new Color(133,193,200)));
//		viewhotels.addActionListener(this);
		p2.add(viewhotels);
		
		
		JButton bookhotels=new JButton("Book Hotels");
		bookhotels.setBounds(0, 416, 300, 52);
		bookhotels.setBackground(new Color(0,0,102));
		bookhotels.setForeground(Color.WHITE);
		bookhotels.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		bookhotels.setMargin(new Insets(0, 0, 0, 140));
//		bookhotels.setBorder(new LineBorder(new Color(133,193,200)));
//		bookhotels.addActionListener(this);
		p2.add(bookhotels);
		
		
		JButton viewbookedhotels=new JButton("View Booked Hotel");
		viewbookedhotels.setBounds(0, 468, 300, 52);
		viewbookedhotels.setBackground(new Color(0,0,102));
		viewbookedhotels.setForeground(Color.WHITE);
		viewbookedhotels.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		viewbookedhotels.setMargin(new Insets(0, 0, 0, 80));
//		viewbookedhotels.setBorder(new LineBorder(new Color(133,193,200)));
//		viewbookedhotels.addActionListener(this);
		p2.add(viewbookedhotels);
		
		
		JButton destinations=new JButton("Destinations");
		destinations.setBounds(0, 520, 300, 52);
		destinations.setBackground(new Color(0,0,102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		destinations.setMargin(new Insets(0, 0, 0, 140));
//		destinations.setBorder(new LineBorder(new Color(133,193,200)));
//		destinations.addActionListener(this);
		p2.add(destinations);
		
		
		JButton payments=new JButton("Payments");
		payments.setBounds(0, 572, 300, 52);
		payments.setBackground(new Color(0,0,102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		payments.setMargin(new Insets(0, 0, 0, 160));
//		payments.setBorder(new LineBorder(new Color(133,193,200)));
//		payments.addActionListener(this);
		p2.add(payments);
		
		
		JButton calculators=new JButton("Calculator");
		calculators.setBounds(0, 624, 300, 52);
		calculators.setBackground(new Color(0,0,102));
		calculators.setForeground(Color.WHITE);
		calculators.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		calculators.setMargin(new Insets(0, 0, 0, 160));
//		calculators.setBorder(new LineBorder(new Color(133,193,200)));
//		calculators.addActionListener(this);
		p2.add(calculators);
		
		
		JButton about=new JButton("About");
		about.setBounds(0, 676, 300, 52);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		about.setMargin(new Insets(0, 0, 0, 200));
//		about.setBorder(new LineBorder(new Color(133,193,200)));
//		about.addActionListener(this);
		p2.add(about);
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/homee.jpg"));
		Image i5=i4.getImage().getScaledInstance(1450, 900, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel imagee=new JLabel(i6);
		imagee.setBounds(0, 0, 1650, 1000);
		add(imagee);
		
		JLabel text =new JLabel("Travel And Tourism Management System");
		text.setBounds(550, 60, 1000, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma",Font.BOLD,35));
		imagee.add(text);
		
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==addpersonalDetails)
		{
			try {
				new AddCustomer(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==viewpersonalDetails)
		{
			try {
				new ViewCustomer(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==updatepersonalDetails)
		{
			try {
				new UpdateCustomer(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==checkpackages)
		{
			try {
				new CheckPackage();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==bookpackages)
		{
			try {
				new BookPackage(username);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
				
}
	

	public static void main(String[] args) {
		new Dashboard("");
	}

}
