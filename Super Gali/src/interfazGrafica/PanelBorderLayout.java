package interfazGrafica;

import javax.swing.*;

import supermercadoModelo.TrabajadorDTO;
import varios.Validador;
import supermercadoDAO.TrabajadorDAO;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* Clase que representa a el border layout que se ha añadido al MarcoLogin
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class PanelBorderLayout extends JPanel implements ActionListener{
	
	private JButton borrar;
	private JButton aceptar;
	private JTextField textoUsu;
	private JPasswordField textoCont;
	
	/**
	 * Constructor del PanelBorderLayout
	 */
	
	public PanelBorderLayout () {

		// 1440p/2 = width=1280,height=720
		// 1440p/2,5 = width=1024,height=576
		// 1080p/2 = width=960,height=540
		// 1080p/2,5 = width=768,height=432
		// 900p/2 = width=800,height=450
		// 900p/2,5 = width=640,height=360
		// 960-850 = 110 //540-430 = 110
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = pantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		if (alturaPantalla==1080&&anchoPantalla==1920) {
			this.setBounds(38,27,677,340);
			
			setLayout(new BorderLayout(10,50));
			
			JPanel norte = new JPanel();
			JLabel jbl = new JLabel ("Login");
			
			norte.setLayout(new FlowLayout(FlowLayout.CENTER,1,30));
			jbl.setFont(new Font("Serif",Font.BOLD,30));
			jbl.setForeground(Color.GRAY);
			norte.add(jbl);
			norte.setPreferredSize(new Dimension (100,70));
			
			JPanel centro = new JPanel();
			textoUsu = new JTextField(20);
			textoCont = new JPasswordField(20);
			
			centro.setLayout(new FlowLayout(FlowLayout.RIGHT,150,20));
			centro.add(new JLabel("Usuario"));
			centro.add(textoUsu);
			centro.add(new JLabel("Contraseña"));
			centro.add(textoCont);
			centro.setPreferredSize (new Dimension (100,100));
			
			JPanel sur = new JPanel();
			borrar = new JButton ("Borrar");
			aceptar = new JButton ("Aceptar");
			
			sur.setLayout (new FlowLayout (FlowLayout.CENTER,150,10));
			sur.add(borrar);
			sur.add(aceptar);
			sur.setPreferredSize (new Dimension (100,80));
			
			borrar.addActionListener(this);
			aceptar.addActionListener(this);
			
			add(norte,BorderLayout.NORTH);
			add(centro,BorderLayout.CENTER);
			add(sur,BorderLayout.SOUTH);
			
		} else if(alturaPantalla==900&&anchoPantalla==1600) {

			this.setBounds(32,23,561,275);
			
			setLayout(new BorderLayout(10,50));
			
			JPanel norte = new JPanel();
			JLabel jbl = new JLabel ("Login");
			
			norte.setLayout(new FlowLayout(FlowLayout.CENTER,1,10));
			jbl.setFont(new Font("Serif",Font.BOLD,30));
			jbl.setForeground(Color.GRAY);
			norte.add(jbl);
			norte.setPreferredSize(new Dimension (100,50));
			
			JPanel centro = new JPanel();
			textoUsu = new JTextField(20);
			textoCont = new JPasswordField(20);
			
			centro.setLayout(new FlowLayout(FlowLayout.RIGHT,100,15));
			centro.add(new JLabel("Usuario"));
			centro.add(textoUsu);
			centro.add(new JLabel("Contraseña"));
			centro.add(textoCont);
			centro.setPreferredSize (new Dimension (100,10));
			
			JPanel sur = new JPanel();
			borrar = new JButton ("Borrar");
			aceptar = new JButton ("Aceptar");
			
			sur.setLayout (new FlowLayout (FlowLayout.CENTER,150,1));
			sur.add(borrar);
			sur.add(aceptar);
			sur.setPreferredSize (new Dimension (100,50));
			
			borrar.addActionListener(this);
			aceptar.addActionListener(this);
			
			add(norte,BorderLayout.NORTH);
			add(centro,BorderLayout.CENTER);
			add(sur,BorderLayout.SOUTH);
			
		} else if (alturaPantalla==1440&&anchoPantalla==2560) {

			this.setBounds(42,31,750,380);
			
			setLayout(new BorderLayout(10,50));
			
			JPanel norte = new JPanel();
			JLabel jbl = new JLabel ("Login");
			
			norte.setLayout(new FlowLayout(FlowLayout.CENTER,1,30));
			jbl.setFont(new Font("Serif",Font.BOLD,30));
			jbl.setForeground(Color.GRAY);
			norte.add(jbl);
			norte.setPreferredSize(new Dimension (100,70));
			
			JPanel centro = new JPanel();
			textoUsu = new JTextField(20);
			textoCont = new JPasswordField(20);
			
			centro.setLayout(new FlowLayout(FlowLayout.RIGHT,140,20));
			centro.add(new JLabel("Usuario"));
			centro.add(textoUsu);
			centro.add(new JLabel("Contraseña"));
			centro.add(textoCont);
			centro.setPreferredSize (new Dimension (100,200));
			
			JPanel sur = new JPanel();
			borrar = new JButton ("Borrar");
			aceptar = new JButton ("Aceptar");
			
			sur.setLayout (new FlowLayout (FlowLayout.CENTER,150,10));
			sur.add(borrar);
			sur.add(aceptar);
			sur.setPreferredSize (new Dimension (100,100));
			
			borrar.addActionListener(this);
			aceptar.addActionListener(this);
			
			add(norte,BorderLayout.NORTH);
			add(centro,BorderLayout.CENTER);
			add(sur,BorderLayout.SOUTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == borrar) {
			
			textoUsu.setText("");
			textoCont.setText("");
			
		} else {
			
			String usuario = textoUsu.getText().trim();
			char[] cadena = textoCont.getPassword();
			String contrasena = String.valueOf(cadena);
			Validador comprobacion = new Validador();
			
			String hash = comprobacion.encriptarContrasena(contrasena);
			
			TrabajadorDTO empleado = new TrabajadorDTO(null, usuario, hash,null,null);
			
			TrabajadorDAO t = new TrabajadorDAO();
			
			if (t.comprobarContrasenaUsuario(empleado)==true) {
				
				if (empleado.getUsuario().equals("Administrador")) {
					
					String [] opciones = {"Administracion","Caja"};
					
					int opcion = JOptionPane.showOptionDialog(null, "¿Que ventana quiere utilizar?", "Seleccionar",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,null);
					
					if (opcion == 0) {
						MarcoAdministrador ad = new MarcoAdministrador();
					} else {
						MarcoCaja caja = new MarcoCaja();
					}

				} else {
					
					MarcoCaja caja = new MarcoCaja();
				}	
				
			} else {
				JOptionPane.showMessageDialog(PanelBorderLayout.this, "Contraseña o usuario incorrecto","Advertencia",0);
			}
		}
		
	}
	
}
