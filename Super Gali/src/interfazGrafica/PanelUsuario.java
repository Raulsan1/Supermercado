package interfazGrafica;

import java.awt.*;

import javax.swing.*;

public class PanelUsuario extends JPanel{

	private Image imagen;
	
	public void paint (Graphics g) {
		
		imagen = new ImageIcon(getClass().getResource("src/interfazGrafica/iconoUsuario.jpg")).getImage();
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
		
		setOpaque(false);
		
		super.paint(g);
		
	}
}
