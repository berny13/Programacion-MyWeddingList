package Main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.conexion;
import Vista.Login;

public class Main {

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		conexion.Conectar();
		
		/* Arranco la interfaz gráfica */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}