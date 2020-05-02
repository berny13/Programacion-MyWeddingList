package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BBDD.conexion;
import Beans.User;

public class Users {
	
	public ArrayList<User> getAllUsers() {
		ResultSet resultados = conexion.EjecutarSentencia("SELECT * FROM usuarios");
		ArrayList<User> usuarios = new Controlador.Helper().ResultSet2ArrayList(resultados);
		return usuarios;
	}
	
	public boolean checkUserAndPass(String nombre, String contraseña) {
		ResultSet usuariosBD = conexion.EjecutarSentencia("SELECT * FROM usuarios WHERE NOMBRE='"+nombre+"' AND CONTRASEÑA='"+contraseña+"'");
		
		try {
			return usuariosBD.next();
		} catch (SQLException e) {
			return false;
		}
	}
	

}