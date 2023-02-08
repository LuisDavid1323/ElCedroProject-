package com.Java.Cedro.controlador.dto;

public class UsuarioRegistroDTO {

	private Long id_usuario;
	private String nombre;
	private String apellido;
	private String tipo_documento;
	private String numero_documento;
	private String telefono;
	private String direccion;
	private String email;
	private String password;

	public Long getId() {
		return id_usuario;
	}

	public void setId(Long id_usuario) {
		this.id_usuario = id_usuario;
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
	
	
	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
	public UsuarioRegistroDTO(String nombre, String apellido, String tipo_documento, String numero_documento,
			String telefono, String direccion, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
	}


	public UsuarioRegistroDTO() {

	}
	

}
