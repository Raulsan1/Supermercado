package interfazGrafica;

import java.awt.*;
import javax.swing.*;

public class PanelLayoutCentro extends JPanel{

	
	public PanelLayoutCentro() {
		
		setLayout(new FlowLayout(FlowLayout.RIGHT,150,20));
		
		add(new JLabel("Usuario"));
		JTextField textoUsu = new JTextField(20);
		add(textoUsu);
		add(new JLabel("Contraseña"));
		JTextField textoCont = new JTextField(20);
		add(textoCont);
		
		setPreferredSize (new Dimension (100,200));
		
	}
}
