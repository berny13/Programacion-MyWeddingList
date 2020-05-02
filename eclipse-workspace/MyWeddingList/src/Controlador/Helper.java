package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Beans.User;

public class Helper {
	
	public ArrayList ResultSet2ArrayList(ResultSet resultados) {
		// Ya tengo los datos de la BBDD
		// Voy a transformarlos a objetos
		ArrayList<User> arraylist = new ArrayList<User>();
		try {
			while(resultados.next()) {
				int idinvitado = resultados.getInt("idinvitado");
				String nombre = resultados.getString("nombre");
				String contraseña = resultados.getString("contraseña");
				String autobus = resultados.getString("autobus");
				String dieta = resultados.getString("dieta");
				String tipo_invitado = resultados.getString("tipo_invitado");
				arraylist.add(new User(idinvitado, nombre, contraseña, autobus, dieta, tipo_invitado));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta de invitados");
		}
		
		return arraylist;
	}

}