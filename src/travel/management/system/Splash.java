package travel.management.system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable {
	
	Thread thread;
	public Splash() {
//		setSize(1000, 600);
//		setLocation(250, 100);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/travell.jpg"));
		Image i2=i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		
		setVisible(true);
		thread=new Thread(this);
		thread.start();
	}
	
	public void run() {
		try {
			Thread.sleep(6000);
			setVisible(false);
			new Login();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public static void main(String[] args) {
		Splash frame = new Splash();
		
		int x=1;
		for (int i=1;i<=500;x+=6,i+=6)
		{
			frame.setLocation(750- (x+i)/2,400-(i/2));
			frame.setSize(x+i,i);
			
			try {
				Thread.sleep(10);
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
