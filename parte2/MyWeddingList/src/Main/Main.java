package Main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.conexion;
import Controlador.Login;
import Modelo.Principal;

import java.awt.Toolkit;



public class Main {
	
	

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		//el Main sera el unico que pueda abrir las otras ventanas  y desde esta clase todas las otras clases del proyecto se abriran
		
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
