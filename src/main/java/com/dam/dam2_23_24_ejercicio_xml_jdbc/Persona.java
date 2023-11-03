package com.dam.dam2_23_24_ejercicio_xml_jdbc;

public class Persona {
	
	private int codigo;
	private String nombre;
	private int edad;
	
	public Persona(int codigo, String nombre, int edad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
