package interfazGrafica;

import java.awt.*;

import javax.swing.*;

/**
* Clase que representa a el Panel de fondo del MarcoLogin
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class PanelFondo extends JPanel{

	private ImageIcon imagen;
	
	/**
	 * Metodo que obtiene la imagen que se desea del directorio imagenes
	 * @param g graficos para poder dibujar la imagen
	 */
	
	public void paint (Graphics g) {

		Graphics2D g2 = (Graphics2D)g;
		
		imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
		g2.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),null);
		setOpaque(false);
		
		super.paint(g);
		
	}

}