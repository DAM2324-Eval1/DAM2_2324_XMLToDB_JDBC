package com.dam.dam2_23_24_ejercicio_xml_jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException, SQLException
    {
       
    	ArrayList<Persona> personas;
    	
    	//Leer el XML
    	personas = Utilidades.leerXML("D:\\PRUEBAS\\personas.xml");
    	
    	//Insertar en BD
    	Utilidades.insertarBD(personas);
    	
    }
}
