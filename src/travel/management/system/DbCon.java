package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbCon {
	
	Connection connection;
	Statement s;
	
	public DbCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","080Md121@");
			s=connection.createStatement();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
