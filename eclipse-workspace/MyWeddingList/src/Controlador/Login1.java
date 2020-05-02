package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Beans.User;

public class Login1 {
	
	public void checkUser1(String idinvitado,String nombre, String autobus, String dieta, String tipo_invitado) {
		// Recoger los usuarios
		boolean check = new Modelo.Users1().checkInvitado(nombre);
		if(check) {
			JOptionPane.showMessageDialog(null, "Invitado Añadido");
		}else { // Sino error
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		}
	}
	
	public boolean checkUserOld(String nombre, String contraseña) {
		// Recoger los invitado
		ArrayList<User> invitado = new Modelo.Users().getAllUsers();
		// Comprobar si usuario y contraseña son correctos
		for(User usuario1 : invitado) {
			if(nombre.equals(usuario1.getNombre()) && contraseña.equals(usuario1.getContraseña())) {
				JOptionPane.showMessageDialog(null, "Invitado Añadido");
			}else { // Sino error
				JOptionPane.showMessageDialog(null, "Invitado no encontrado");
			}
		}
		
		
		
		return true;
	}
	
	public void createTable(String name) {
		ArrayList<String[]> columns = new ArrayList<String[]>();
		String[] column0 = {"idinvitado", "int"};
		String[] column1 = {"nombre", "varchar(45)"};
		String[] column2 = {"contraseña", "varchar(25)"};
		String[] column3 = {"autobus", "varchar(4)"};
		String[] column4 = {"dieta", "varchar(45)"};
		String[] column5 = {"tipo_invitado", "varchar(45)"};
		
		columns.add(column0);
		columns.add(column1);
		columns.add(column2);
		columns.add(column3);
		columns.add(column4);
		columns.add(column5);
		
		new Modelo.Table().createTable(name, columns);
	}
	
	public void insertUser(String idinvitado,String nombre, String autobus, String dieta, String tipo_invitado) {
		new Modelo.Table1().insertUser(idinvitado, nombre, autobus, dieta, tipo_invitado);
	}
	
	
	public void deleteUser(String idinvitado,String nombre, String autobus, String dieta, String tipo_invitado) {
		new Modelo.Table1().deleteUser(idinvitado, nombre, autobus, dieta, tipo_invitado);
	}

	

}