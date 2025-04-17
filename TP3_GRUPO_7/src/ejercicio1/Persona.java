package ejercicio1;

import exceptions.DniInvalido;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	
	public Persona(String nombre, String apellido, String dni) throws DniInvalido {
	    this.nombre = nombre;
	    this.apellido = apellido;
	    setDni(dni);
	}
	
	public Persona() {
		
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) throws DniInvalido {
		Validador.verificarDniInvalido(dni);
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Persona \nNombre: " + nombre + "\nApellido: " + apellido + "\nDni: " + dni + "\n";
	}	
}
