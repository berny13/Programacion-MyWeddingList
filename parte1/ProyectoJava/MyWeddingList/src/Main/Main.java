package Main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.conexion;
import Controlador.Login;
import Vista.Principal;

import java.awt.Toolkit;



public class Main {
	
	

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		
		
		/* Arranco la interfaz gráfica */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("anillos.jpg"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}