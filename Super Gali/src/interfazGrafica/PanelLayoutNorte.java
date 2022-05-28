package interfazGrafica;

import java.awt.*;

import javax.swing.*;

public class PanelLayoutNorte extends JPanel{

	public PanelLayoutNorte () {
		
		setLayout(new FlowLayout(FlowLayout.CENTER,1,30));
		
		JLabel jbl = new JLabel ("Login");
		
		
		jbl.setFont(new Font("Serif",Font.BOLD,30));
		jbl.setForeground(Color.GRAY);
		
		add(jbl);
		
		setPreferredSize(new Dimension (100,70));
	}
	
}
