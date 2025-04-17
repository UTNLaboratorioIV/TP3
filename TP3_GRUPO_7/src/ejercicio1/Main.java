package ejercicio1;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
			//EJERCICIO 2 LEER ARCHIVO PERSONAS TXT
		//Persona p1 = new Persona();
		Archivo a1 = new Archivo();
		
		a1.setRuta("C:\\Users\\danie\\Downloads\\Personas.txt");
		if(a1.existe()) {
			System.out.println("El archivo ya existe!");
		}else {
			System.out.println("El archivo NO existe!");
		}
		
		//System.out.println(" Lectura del archivo: ");
		//a1.leerArchivoPorLinea();
		
		//System.out.println(" CORTE PARA VERIFICAR DUPLICADOS  ");
		//a1.leerSinDuplicados();
		
		TreeSet<Persona> personasOrdenadas = a1.guardarTreeSetPorLinea();

		System.out.println("Personas ordenadas y sin duplicados:");
		for (Persona p : personasOrdenadas) {
		    System.out.println(p);
		}
		
		//Ejercicio 3
		////////////////////////////////////////////////////////////////
		Archivo archivo = new Archivo();
		archivo.setRuta("C:\\Users\\danie\\Downloads\\Resultado.txt");

		if(archivo.existe())
			{
				System.out.println("Existe el archivo");
			}
		else
			{
				System.out.println("No existe archivo previo, se crea archivo");
				archivo.creaArchivo();
			}

		//escribo lineas
		archivo.escribe_lineas(personasOrdenadas);

		////////////////////////////////////////////////////////////////
		
		
	}


}
