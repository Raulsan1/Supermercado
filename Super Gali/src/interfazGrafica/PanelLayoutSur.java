package interfazGrafica;

import java.awt.*;
import javax.swing.*;

public class PanelLayoutSur extends JPanel{
	
	public PanelLayoutSur () {
		
		setLayout (new FlowLayout (FlowLayout.CENTER,100,10));
		
		JButton borrar = new JButton ("Borrar");
		add(borrar);
		
		JButton aceptar = new JButton ("Aceptar");
		add(aceptar);
		
		setPreferredSize (new Dimension (100,120));
		
	}

}
