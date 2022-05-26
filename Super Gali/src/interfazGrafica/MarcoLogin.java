package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import supermercadoModelo.TrabajadorDTO;

public class MarcoLogin extends JFrame{
	
	BorderLayout border;
	JLabel usuario,contrasena;
	JTextField usuarioText,contrasenaText;
	JButton aceptar,Borrar;

	public MarcoLogin () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		
		border = new BorderLayout(3,3);	

		Fondo fondo = new Fondo();
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
