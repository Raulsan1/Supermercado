package varios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* Clase que representa a varios tipos de metodos y validadores 
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class Validador {
	
	/**
	 * Metodo que valida si el texto pasado como parametro esta vacio
	 * @param texto texto de tipo string que se quiere validar
	 * @return comp regresa un booleano con el resultado
	 */
	public boolean isVacio (String texto) {
		
		boolean comp = false;
		
		if (texto.equals("")) {
			comp = false;
		}else {
			comp = true;
		}
		
		return comp;
	}
	
	/**
	 * Metodo que valida si el texto pasado como parametro es un numero
	 * @param texto texto de tipo string que se quiere validar
	 * @return comp regresa un booleano con el resultado
	 */
	public boolean isInteger (String texto) {
		
		boolean comp = false;
		
		try {
			Integer.parseInt(texto);
			comp = true;
		} catch (NumberFormatException e) {
			comp = false;
		}
		
		return comp;
	}
	
	/**
	 * Metodo para encriptar la contraseña pasada como parametro
	 * @param texto contraseña que se quiere encriptar
	 * @return hash el hash que se ha generado
	 */
	public String encriptarContrasena (String texto) {
		
		String hash;
		
		try {
			 
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            byte[] messageDigest = md.digest(texto.getBytes());
  
            BigInteger no = new BigInteger(1, messageDigest);
  
            hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            
        } 
  
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		return hash;
	}

}
