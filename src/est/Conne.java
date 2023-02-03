package est;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conne {
	
	
	Connection conectar = null;
	String driver = "org.gjt.mm.mysql.Driver";
	String url = "jdbc: mysql://localhost/TPW4";


	
	public Connection connectar() {
		

		if (conectar == null) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conectar = (Connection) DriverManager.getConnection(url, "root", "Gabilenow2111");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}

		return conectar;
	}
}
