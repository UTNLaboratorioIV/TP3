package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Archivo {
	private String ruta;
	
	
	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public boolean existe() {
		File archivo = new File(ruta); 
		if(archivo.exists()) {
			return true;
		}
		return false;
	}
	
	public void leer_archivoXLetra() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			int l = entrada.read(); // lee el primer caracter 
			while(l != -1) {
				char letra = (char) l;
				System.out.println(letra);
				l = entrada.read();
			}
			entrada.read();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leerArchivoPorLinea() {
	    try {
	        BufferedReader lector = new BufferedReader(new FileReader(ruta));
	        String linea;
	        while ((linea = lector.readLine()) != null) {
	            System.out.println(linea); // muestra la línea completa
	        }
	        lector.read();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void leerSinDuplicados() {
	    Set<String> nombresUnicos = new HashSet<>();
	    
	    try {
	        BufferedReader leer = new BufferedReader(new FileReader(ruta));
	        String linea;
	        while ((linea = leer.readLine()) != null) {
	            if (nombresUnicos.add(linea.trim())) { //con trim eliminamos espacios al principio y final 
	                System.out.println(linea);
	            }
	        }
	        leer.read();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
