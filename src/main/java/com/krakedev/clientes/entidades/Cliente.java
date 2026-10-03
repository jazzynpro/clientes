package com.krakedev.clientes.entidades;

public class Cliente {
	//Atributos
	private String cedula;
	private String nombre;
	private String apellido;
	private String email; //nuevo atributo cliente
	
	//constructor vacio
	public Cliente() {}
	//constructor con parametros
	public Cliente(String cedula, String nombre, String apellido, String email) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email; //nuevo atributo cliente
	}
	//generate to String
	
	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}
	
	//generar lo getters and stteres
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() { //nuevo atributo cliente
		return email;
	}
	public void setEmail(String email) { //nuevo atributo cliente
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
	
}
