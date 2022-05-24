package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import supermercadoModelo.TrabajadorDTO;

public class MarcoLogin extends JFrame{

	public MarcoLogin () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		setTitle("Login");
		
		Image icono = pantalla.getImage("src/interfazGrafica/supergali.jpg");
		
		setIconImage(icono);
		
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		
		int anchoPantalla = tamanoPantalla.width;
		
		setSize(anchoPantalla/3,alturaPantalla/3);
		
		setLocation(anchoPantalla/3,alturaPantalla/3);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
