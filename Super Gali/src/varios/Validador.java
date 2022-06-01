package varios;

public class Validador {
	
	public boolean validarVacio (String texto) {
		
		boolean comp = false;
		
		if (texto.equals("")) {
			comp = false;
		}else {
			comp = true;
		}
		
		return comp;
	}

}
