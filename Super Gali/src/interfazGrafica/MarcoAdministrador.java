package interfazGrafica;

import java.awt.*;
import javax.swing.*;

/**
* Clase que representa a el Marco de administrador. Sin implementar
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class MarcoAdministrador extends JFrame{
	
	/**
	 * Constructor de el MarcoAdministrador
	 */

	public MarcoAdministrador () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		
		setTitle("Administracion");
		setIconImage(icono);
		
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla/2,alturaPantalla/2);
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
		setVisible(true);
		setResizable(false);
	}
}
