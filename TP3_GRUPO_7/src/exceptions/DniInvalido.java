package exceptions;

import java.io.IOException;

public class DniInvalido extends IOException {
    public DniInvalido(String dni) {
        super(String.format("El DNI %s contiene caracteres no válidos.",dni ));
    }
    
    public DniInvalido() {
    	super("El dni contiene caracteres no válidos");
    }

    public DniInvalido(String message, Throwable cause) {
        super(message, cause);
    }
}
