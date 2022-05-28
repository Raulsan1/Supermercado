package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class MarcoLogin extends JFrame{

	public MarcoLogin () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		
		PanelFondo fondo = new PanelFondo();
		PanelBorderLayout borderLayout = new PanelBorderLayout();
		add(borderLayout);
		add(fondo);
		
		setTitle("Login");
		setIconImage(icono);
		
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		
		int anchoPantalla = tamanoPantalla.width;
		
		setSize(anchoPantalla/3,alturaPantalla/3);
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}

}
