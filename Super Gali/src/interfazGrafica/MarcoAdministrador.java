package interfazGrafica;

import java.awt.*;
import javax.swing.*;

public class MarcoAdministrador extends JFrame{

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
}
