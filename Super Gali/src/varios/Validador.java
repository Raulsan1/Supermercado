package varios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public String encriptarContrasena (String texto) {
		
		String hash;
		
		try {
			  
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(texto.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		return hash;
	}

}
