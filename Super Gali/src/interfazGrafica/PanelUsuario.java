package interfazGrafica;

import java.awt.*;

import javax.swing.*;

public class PanelUsuario extends JPanel{

	private ImageIcon imagen;
	
	
	public void paint (Graphics g) {

		Graphics2D g2 = (Graphics2D)g;
		
		imagen = new ImageIcon(getClass().getResource("src/imagenes/iconoUsuario.jpg"));
		g2.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),null);
		
		setOpaque(false);
		
		super.paint(g);
		
		this.setBounds(250, 100, 250, 250);
		
	}

}
