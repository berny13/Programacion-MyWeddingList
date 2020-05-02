package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BBDD.conexion;
import Beans.User;

public class Users1 {
	
	public ArrayList<User> getAllUsers1() {
		ResultSet resultados = conexion.EjecutarSentencia("SELECT * FROM invitado");
		ArrayList<User> invitado = new Controlador.Helper().ResultSet2ArrayList(resultados);
		return invitado;
	}
	
	public boolean checkInvitado (String nombre) {
		ResultSet invitadoBD = conexion.EjecutarSentencia("SELECT * FROM invitado WHERE NOMBRE='"+nombre+"' ");
		
		try {
			return invitadoBD.next();
		} catch (SQLException e) {
			return false;
		}
	}
	

}