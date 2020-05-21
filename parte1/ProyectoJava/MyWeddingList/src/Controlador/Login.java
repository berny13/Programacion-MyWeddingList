package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import BBDD.conexion;
import Beans.User;
import Vista.TablaInvitados;



public class Login extends conexion {

public boolean registrar(User usr) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "INSERT INTO usuarios (nombre, contraseña,correo) VALUES(?,?,?)";

    try {
        ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, usr.getNombre());
        ps.setString(2, usr.getContraseña());
        ps.setString(3, usr.getCorreo());       
        ps.execute();
        return true;
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}

public boolean login(User usr) {
    java.sql.PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();

    String sql = "SELECT id, nombre, contraseña FROM usuarios WHERE nombre = ? LIMIT 1";

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNombre());
        rs = ps.executeQuery();

        if (rs.next()) {
        	
            if (usr.getContraseña().equals(rs.getString(3))) {
                
            	 String sqlUpdate = "UPDATE usuarios SET ultimaconexion = ? WHERE id = ?";

            	ps= con.prepareStatement(sqlUpdate);
            	ps.setString(1, usr.getUltimaconexion());
            	ps.setInt(2, rs.getInt(1));
            	ps.execute();
            			
            	usr.setId(rs.getInt(1));
                usr.setNombre(rs.getString(2));
                return true;
            } else {
                return false;
            }
        }

        return false;
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
        
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}


public int existeUsuario(String nombre) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();

    String sql = "SELECT count(id) FROM usuarios WHERE nombre = ?";

    try {
        ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 1;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return 1;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}

public boolean esEmail(String correo) {

    // Patrón para validar el email
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    Matcher mather = pattern.matcher(correo);

    return mather.find();

}

public boolean registrarInvitado(User usr) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sqlInvitado = "INSERT INTO invitado (nombre, autobus, dieta, tipo_invitado) VALUES(?, ?,?,?)";

    try {
        ps = (PreparedStatement) con.prepareStatement(sqlInvitado);
        ps.setString(1, usr.getNombre());
        ps.setString(2, usr.getAutobus());
        ps.setString(3, usr.getDieta()); 
        ps.setString(4, usr.getTipo_invitado());
        ps.execute();
        return true;
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
	public void PDFJava() {
		
		
	}
	
	public void deleteUser(String user) {
		new Controlador.Login().deleteUser(user);
		
		
	}
	public static void recordar() {

		try {

		FileReader leerUser = new FileReader("C:/Users/34644/eclipse-workspace/MyWeddingList/src/nombre.txt");
		BufferedReader br = new BufferedReader(leerUser);

		FileReader leerPasswd = new FileReader("C:/Users/34644/eclipse-workspace/MyWeddingList/src/contraseña.txt");

		int c=0;
		String texto = "";
		String text = "";

		while((texto=br.readLine())!=null){
		           text = texto;
		   }


		} catch (IOException e) {
		System.out.println("No se ha encontrado el archivo");
		e.printStackTrace();
		}

		}

		public static void EscribirRecordar(String nombre, String contraseña) {


		FileWriter escribirUser;
		FileWriter escribirPasswd;

		BufferedWriter buferUser;
		BufferedWriter buferPasswd;

		PrintWriter printUser;
		PrintWriter printPasswd;

		try {

		escribirUser = new FileWriter("C:/Users/34644/eclipse-workspace/MyWeddingList/src/nombre.txt");
		escribirPasswd = new FileWriter("C:/Users/34644/eclipse-workspace/MyWeddingList/src/contraseña.txt");

		buferUser = new BufferedWriter(escribirUser);
		printUser = new PrintWriter(escribirUser);
		escribirUser.write(" "+nombre);

		escribirUser.close();
		buferUser.close();

		buferPasswd = new BufferedWriter(escribirPasswd);
		printPasswd = new PrintWriter(escribirPasswd);
		escribirPasswd.write(" "+contraseña);

		escribirPasswd.close();
		buferPasswd.close();



		} catch (IOException e1) {
		System.out.println("No se ha podido escribir en el archivo.");
		e1.printStackTrace();
		}
		}
	

}
