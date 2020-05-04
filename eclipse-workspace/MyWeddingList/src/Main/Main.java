package Main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.conexion;
import Vista.Login;
import Vista.Principal;



public class Main {

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		
		
		/* Arranco la interfaz gráfica */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}