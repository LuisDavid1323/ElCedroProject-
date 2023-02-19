package com.Java.Cedro.DTO;

public class TelaDTO {

	
	/*Tela*/
	private Integer id_telas;
	private String Nombre_tela;
	private String Valor;
	private Integer id_tela_fk;
	
	/*Constructor*/
	
	public TelaDTO(Integer id_telas, String nombre_tela, String valor, Integer id_tela_fk) {
		super();
		this.id_telas = id_telas;
		Nombre_tela = nombre_tela;
		Valor = valor;
		this.id_tela_fk = id_tela_fk;
	}
	
	
	/*Getters and Setters*/
	
	public Integer getId_telas() {
		return id_telas;
	}

	public void setId_telas(Integer id_telas) {
		this.id_telas = id_telas;
	}

	public String getNombre_tela() {
		return Nombre_tela;
	}

	public void setNombre_tela(String nombre_tela) {
		Nombre_tela = nombre_tela;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public Integer getId_tela_fk() {
		return id_tela_fk;
	}

	public void setId_tela_fk(Integer id_tela_fk) {
		this.id_tela_fk = id_tela_fk;
	}

}
