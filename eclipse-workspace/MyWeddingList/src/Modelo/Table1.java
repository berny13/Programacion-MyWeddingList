package Modelo;

import java.util.ArrayList;

import BBDD.conexion;

public class Table1 {
	
	public void createTable(String tableName, ArrayList<String[]> columns) {
		String columnsString = "";
		for(String[] column : columns){
			columnsString += column[0]+" "+column[1]+",";
		}
		columnsString = columnsString.substring(0, columnsString.length()-1);
		
		conexion.EjecutarUpdate("CREATE TABLE "+tableName+"("+columnsString+");");
	}
	
	public void insertUser(String idinvitado,String nombre, String autobus, String dieta, String tipo_invitado) {
		conexion.EjecutarUpdate("INSERT INTO invitado (IDINVITADO, NOMBRE, AUTOBUS, DIETA, TIPO_INVITADO) VALUES (1, '"+idinvitado+"', '"+nombre+"', '"+autobus+"', '"+dieta+"', '"+tipo_invitado+"');");
	}
	
	public void deleteUser(String idinvitado,String nombre, String autobus, String dieta, String tipo_invitado) {
		conexion.EjecutarUpdate("DELETE FROM invitado WHERE nombre = '"+nombre+"';");
	}

}