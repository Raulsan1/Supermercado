package interfazGrafica;

import javax.swing.*;

import supermercadoModelo.TrabajadorDTO;
import supermercadoDAO.TrabajadorDAO;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PanelBorderLayout extends JPanel implements ActionListener{
	
	private JButton borrar;
	private JButton aceptar;
	private JTextField textoUsu;
	private JPasswordField textoCont;
	
	public PanelBorderLayout () {
		
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
		
		centro.setLayout(new FlowLayout(FlowLayout.RIGHT,200,20));
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
		
		// width=960,height=540
		//960-850 = 110 //540-430 = 110
		setBounds(47,35,850,430);
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
			
			String hash = encriptarContrasena(contrasena);
			
			TrabajadorDTO empleado = new TrabajadorDTO(null, usuario, hash,null, null,null);
			TrabajadorDAO t = new TrabajadorDAO();
			
			if (t.comprobarContrasenaUsuario(empleado)==true) {
				
				if (usuario.equals("Administrador")) {
					
					String [] opciones = {"Administracion","Caja"};
					
					int opcion = JOptionPane.showOptionDialog(null, "¿Que ventana quiere utilizar?", "Seleccionar",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,null);
					System.out.println(opcion);
					
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
	
	public static String encriptarContrasena (String texto) {
		
		String hash;
		
		try {
			  
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(texto.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		return hash;
	}
	
}
