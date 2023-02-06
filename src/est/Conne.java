package est;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conne {

	Connection conectar = null;
	String driver = "com.mysql.cj.jdbc.Driver";

	public Connection connectar() {

		Connection con = null;

		try {

			Class.forName(driver);
			if (con == null) {
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TPW4", "root",
						"Gabilenow2111");

			}

			JOptionPane.showMessageDialog(null, "Connectado");

		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		return con;

	}
}
