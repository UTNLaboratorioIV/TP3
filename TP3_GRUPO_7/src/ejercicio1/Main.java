package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
			//EJERCICIO 2 LEER ARCHIVO PERSONAS TXT
		Persona p1 = new Persona();
		Archivo a1 = new Archivo();
		
		a1.setRuta("C:\\Users\\Lenovo\\Desktop\\PORFOLIONEW\\TPWEB\\TP3\\TP3_GRUPO_7\\src\\Archivo\\personas.txt");
		if(a1.existe()) {
			System.out.println("El archivo ya existe!");
		}else {
			System.out.println("El archivo NO existe!");
		}
		
		System.out.println(" Lectura del archivo: ");
		a1.leerArchivoPorLinea();
		
		System.out.println(" CORTE PARA VERIFICAR DUPLICADOS  ");
		a1.leerSinDuplicados();
		
		
	}


}
