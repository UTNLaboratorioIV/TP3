package ejercicio1;

import exceptions.DniInvalido;

public class Validador {
	
	public static void verificarDniInvalido(String dni) throws DniInvalido{
		if (!dni.matches("\\d+")) {
            throw new DniInvalido("El DNI '" + dni + "' no es válido. Debe contener solo números.");
        }
        System.out.println("DNI válido.");
	}
}