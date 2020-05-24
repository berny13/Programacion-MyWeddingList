package Beans;

public class User {
	
	private int id;
	private int idinvitado;
	private String nombre;
	private String contrase�a;
	private String nombreinvitado;
	private String autobus;
	private String dieta;
	private String tipo_invitado;
	private String correo;
	private String ultimaconexion;
	
	
	public User() {
		
	}
	public User(int idinvitado, int id, String nombre, String contrase�a,  String autobus, String dieta, String tipo_invitado, String correo, String nombreinvitado) {
		this.idinvitado = idinvitado;
		this.id = id;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.autobus = autobus;
		this.dieta = dieta;
		this.tipo_invitado = tipo_invitado;
		this.correo = correo;
		this.nombreinvitado = nombreinvitado;
		this.ultimaconexion = ultimaconexion;
		
	
	}
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNombreinvitado() {
		return nombreinvitado;
	}
	public void setNombreinvitado(String nombreinvitado) {
		this.nombreinvitado = nombreinvitado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUltimaconexion() {
		return ultimaconexion;
	}
	public void setUltimaconexion(String ultimaconexion) {
		this.ultimaconexion = ultimaconexion;
	}
	public int getIdinvitado() {
		return idinvitado;
	}
	
	
	
	


}