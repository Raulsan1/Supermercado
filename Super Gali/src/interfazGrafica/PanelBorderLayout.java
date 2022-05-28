package interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelBorderLayout extends JPanel{
	
	public PanelBorderLayout () {
		
		setLayout(new BorderLayout(10,50));
		
		PanelLayoutNorte norte = new PanelLayoutNorte();
		PanelLayoutCentro centro = new PanelLayoutCentro();
		PanelLayoutSur sur = new PanelLayoutSur();
		 
		add(norte,BorderLayout.NORTH);
		add(centro,BorderLayout.CENTER);
		add(sur,BorderLayout.SOUTH);
		
		
		
		setBounds(42,31,755,380);
		
	}
	
}
