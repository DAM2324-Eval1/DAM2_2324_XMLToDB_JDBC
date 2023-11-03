package com.dam.dam2_23_24_ejercicio_xml_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utilidades {
	
	public static ArrayList<Persona> leerXML(String ruta) throws ParserConfigurationException, SAXException, IOException {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
			
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factoria.newDocumentBuilder();
		Document documento = db.parse(ruta);
		
		NodeList codigos = documento.getElementsByTagName("codigo");
		NodeList nombres = documento.getElementsByTagName("nombre");
		NodeList edades = documento.getElementsByTagName("edad");
		
		for (int i = 0; i < codigos.getLength(); i++) {
			
			personas.add(new Persona(Integer.parseInt(codigos.item(i).getTextContent()), 
									 nombres.item(i).getTextContent(),
									 Integer.parseInt(edades.item(i).getTextContent())));
			
		}
		
		return personas;
		
	}
	
	public static void insertarBD(ArrayList<Persona> personas) throws SQLException {
		
		//Creamos la conexión
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/personas","root","1234.Abcd");
		
		for (Persona persona: personas) {
			
			Statement insercion = conexion.createStatement();
			String insert = "INSERT INTO persona (codigo, nombre, edad) VALUES (" + persona.getCodigo() + ",'" +
				        															persona.getNombre() + "'," + 
				        															persona.getEdad() + ")";
			//System.out.println(insert);
			insercion.executeUpdate(insert);
			insercion.close();
		}
		
		conexion.close();
	}

}
