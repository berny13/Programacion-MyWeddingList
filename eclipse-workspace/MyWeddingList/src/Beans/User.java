package Beans;

public class User {
	
	int idinvitado;
	String nombre;
	String contrase�a;
	String autobus;
	String dieta;
	String tipo_invitado;
	
	public User() {}
	public User(int idinvitado, String nombre, String contrase�a,  String autobus, String dieta, String tipo_invitado) {
		this.idinvitado = idinvitado;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.autobus = autobus;
		this.dieta = dieta;
		this.tipo_invitado = tipo_invitado;
	
	}
		
	
	public int getIdinvitado() {
		return idinvitado;
	}
	public void setIdinvitado(int idinvitado) {
		this.idinvitado = idinvitado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public String getAutobus() {
		return autobus;
	}
	public void setAutobus(String autobus) {
		this.autobus = autobus;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getTipo_invitado() {
		return tipo_invitado;
	}
	public void setTipo_invitado(String tipo_invitado) {
		this.tipo_invitado = tipo_invitado;
	}
	
	
	
	


}