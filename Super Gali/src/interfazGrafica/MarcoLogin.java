package interfazGrafica;

import javax.swing.*;
import java.awt.*;

/**
* Clase que representa a el Marco de login
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class MarcoLogin extends JFrame{

	/**
	 * Constructor del MarcoLogin
	 */
	
	public MarcoLogin () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		if (alturaPantalla==1080&&anchoPantalla==1920) {
			setSize(768,432);
			setLocation(anchoPantalla/4, alturaPantalla/4);
		} else if(alturaPantalla==900&&anchoPantalla==1600) {
			setSize(640,360);
			setLocation(anchoPantalla/4, alturaPantalla/4);
		} else if (alturaPantalla==1440&&anchoPantalla==2560) {
			setSize(853,480);
			setLocation(anchoPantalla/4, alturaPantalla/4);
		}
		
		PanelFondo fondo = new PanelFondo();
		PanelBorderLayout borderLayout = new PanelBorderLayout();
		add(borderLayout);
		add(fondo);
		
		setTitle("Login");
		setIconImage(icono);
		
		

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}

}
