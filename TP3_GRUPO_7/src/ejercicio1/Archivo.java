package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import exceptions.DniInvalido;

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
	
	public TreeSet<Persona> guardarTreeSetPorLinea() {
	    TreeSet<Persona> treesetPersonas = new TreeSet<>();

	    try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
	        String linea;

	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split("-");
	            if (datos.length == 3) {
	                String nombre = datos[0].trim();
	                String apellido = datos[1].trim();
	                String dni = datos[2].trim();

	                try {
	                    Validador.verificarDniInvalido(dni);
	                    Persona persona = new Persona(nombre, apellido, dni);
	                    treesetPersonas.add(persona);
	                } catch (DniInvalido ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return treesetPersonas;
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
	//Ejercicio 3
		/////////////////////////////////////////
		public boolean creaArchivo()
		{
			FileWriter escritura;
			try {
				escritura = new FileWriter(ruta, true);
				escritura.write("");
				escritura.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
				
		}
		
		public void escribe_lineas(TreeSet<Persona> personas) {
			try 
			{	
				FileWriter entrada = new FileWriter(ruta, true);
				BufferedWriter miBuffer = new BufferedWriter(entrada);
				
				for (Persona persona : personas) {
					miBuffer.write(persona.getNombre() + " " + persona.getApellido() + " " + persona.getDni());
					miBuffer.newLine();
				}
				
				miBuffer.close();
				entrada.close();
				
				System.out.println("Información escrita en el archivo correctamente.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}


