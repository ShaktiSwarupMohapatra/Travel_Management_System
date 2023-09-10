package travel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
	String username;
	
	Thread th;
	JProgressBar bar;
	
	public void run() {
		try {
			for(int i=1;i<=101;i++) {
				int max=bar.getMaximum();
				int value =bar.getValue();
				
				if(value<max) {
					bar.setValue(bar.getValue()+1);
				}
				else {
					setVisible(false);
					new Dashboard(username);
				}
				Thread.sleep(20);
				
			}
			
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Loading(String username) {
		
		this.username = username;
		th=new Thread(this);
		setBounds(370, 180, 800, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text =new JLabel("Travel And Tourism Application");
		text.setBounds(160, 20, 600, 40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Tahoma",Font.BOLD,30));
		add(text);
		
		bar=new JProgressBar();
		bar.setBounds(230, 80, 300, 35);
		bar.setStringPainted(true);
		
		add(bar);
		
		JLabel loading =new JLabel("Loading, please wait...");
		loading.setBounds(300, 120, 200, 30);
		loading.setForeground(Color.RED);
		loading.setFont(new Font("Raleway",Font.BOLD,16));
		add(loading);
		
		JLabel lblusername =new JLabel("Welcome "+username);
		lblusername.setBounds(20, 350, 400, 40);
		lblusername.setForeground(Color.RED);
		lblusername.setFont(new Font("Raleway",Font.BOLD,16));
		add(lblusername);
		
		
		th.start();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Loading loading=new Loading("");
	}
}
