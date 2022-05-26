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
		
		border = new BorderLayout(3,3);
		
		setLayout(border);
		
		usuario = new JLabel("Usuario");		

		/*
		PanelUsuario iconoUsuario = new PanelUsuario();
		add(iconoUsuario);
		iconoUsuario.repaint();
		iconoUsuario.setSize(100,100);
		*/
		setTitle("Login");
		
		Image icono = pantalla.getImage("/supergali.jpg");
		
		setIconImage(icono);
		
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		Double alturaPantalla = (double) tamanoPantalla.height;
		
		Double anchoPantalla = (double) tamanoPantalla.width;
		
		setSize((int)(anchoPantalla/2),(int)(alturaPantalla/1.5));
		
		setLocation((int)(anchoPantalla/4.25),(int) (alturaPantalla/5.5));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}

}
