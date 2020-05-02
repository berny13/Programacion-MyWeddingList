package Modelo;

import java.util.ArrayList;

import BBDD.conexion;

public class Table {
	
	public void createTable(String tableName, ArrayList<String[]> columns) {
		String columnsString = "";
		for(String[] column : columns){
			columnsString += column[0]+" "+column[1]+",";
		}
		columnsString = columnsString.substring(0, columnsString.length()-1);
		
		conexion.EjecutarUpdate("CREATE TABLE "+tableName+"("+columnsString+");");
	}
	
	public void insertUser(String nombre, String contraseña) {
		conexion.EjecutarUpdate("INSERT INTO usuarios (ID, NOMBRE, CONTRASEÑA) VALUES (?, '"+nombre+"', '"+contraseña+"');");
	}
	
	public void deleteUser(String nombre) {
		conexion.EjecutarUpdate("DELETE FROM usuarios WHERE nombre = '"+nombre+"';");
	}

}