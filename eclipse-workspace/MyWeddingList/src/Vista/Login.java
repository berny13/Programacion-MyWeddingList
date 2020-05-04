package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Beans.User;

public class Login {
	
	public void checkUser(String nombre, String contraseña) {
		// Recoger los usuarios
		boolean check = new Modelo.Users().checkUserAndPass(nombre, contraseña);
		if(check) {
			JOptionPane.showMessageDialog(null, "Uuario correcto");
		}else { // Sino error
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		}
	}
	
	public boolean checkUserOld(String nombre, String contraseña) {
		// Recoger los invitado
		ArrayList<User> invitado = new Modelo.Users().getAllUsers();
		// Comprobar si usuario y contraseña son correctos
		for(User usuario : invitado) {
			if(nombre.equals(usuario.getNombre()) && contraseña.equals(usuario.getContraseña())) {
				JOptionPane.showMessageDialog(null, "Usuario correcto");
			}else { // Sino error
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			}
		}
		
		
		
		return true;
	}
	
	public void createTable(String name) {
		ArrayList<String[]> columns = new ArrayList<String[]>();
		String[] column0 = {"idinvitado", "int"};
		String[] column1 = {"nombre", "varchar(45)"};
		String[] column2 = {"contraseña", "varchar(25)"};
		
		
		columns.add(column0);
		columns.add(column1);
		columns.add(column2);
		
		
		new Modelo.Table().createTable(name, columns);
	}
	
	
	public void deleteUser(String nombre, String contraseña) {
		new Modelo.Table().deleteUser(nombre);
	}

	public void insertUser(String nombre, String contraseña) {
		new Modelo.Table().insertUser(nombre, contraseña);
		
	}

}