package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conect {
	private static Connection conexion;
	private static Conect instancia;
	private static final String URL = "jdbc:mysql://localhost/bd_costossuministros";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	private Conect(){}
	
	public Connection conectarBase() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conexion;
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Error: " + e);
		}
		
		return conexion;
	}
	
	public void cerrarBase() throws SQLException {
		try {
			conexion.close();
			JOptionPane.showConfirmDialog(null, "Close exitoso");
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Error: " + e);
			conexion.close();
			
		}finally {
			conexion.close();
		}
	}
	
	public static Conect getInstancia() {
		if (instancia == null) {
			instancia = new Conect();
		}
		return instancia;
		
	}
}
