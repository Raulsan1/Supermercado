package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import supermercadoDAO.ProductoDAO;
import supermercadoModelo.ProductoDTO;

public class MarcoCaja extends JFrame{

	private String [] columnas = {"Nombre","Precio","Iva","Cantidad"};
	private Object [][] datosFila = {{"---------","---------","--------","--------"}};
	
	private JButton eliminar;
	private JButton comprobar;
	private JButton agregar;
	private JButton generar;
	
	private JTextField textoCodigo;
	private JTextField textoNombre;
	private JTextField textoPrecio;
	private JTextField textoIva;	
	
	private JPanel este;
	private JPanel oeste;
	private JPanel sur;
	
	private JTable datos;
	private ArrayList <String> productos;
	
	private int contador;
	private double preciostot;

	public MarcoCaja () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		productos = new ArrayList<String>();
		setLayout(new BorderLayout());
		
		JLabel codigo = new JLabel("Codigo");
		textoCodigo = new JTextField (20);
		JLabel nombre = new JLabel("Nombre");
		textoNombre = new JTextField (20);
		JLabel precio = new JLabel("Precio");
		textoPrecio = new JTextField (20);
		JLabel iva = new JLabel("IVA");
		textoIva = new JTextField (20);
		
		oeste = new JPanel();
		oeste.setLayout(new FlowLayout(FlowLayout.RIGHT,50,50));
		oeste.setPreferredSize(new Dimension(400,200));
		oeste.add(codigo);
		oeste.add(textoCodigo);
		oeste.add(nombre);
		oeste.add(textoNombre);
		oeste.add(precio);
		oeste.add(textoPrecio);
		oeste.add(iva);
		oeste.add(textoIva);
		add(oeste,BorderLayout.WEST);
		
		este = new JPanel();
		datos = new JTable (new DefaultTableModel(columnas,0));
		este.add(new JScrollPane(datos));
		este.setPreferredSize(new Dimension (500,200));
		add(este, BorderLayout.EAST);
		
		
		eliminar = new JButton ("Quitar producto");
		comprobar = new JButton ("Comprobar codigo");
		agregar = new JButton ("Agregar producto");
		generar = new JButton ("Generar factura");
		
		sur = new JPanel();
		sur.setLayout(new FlowLayout (FlowLayout.CENTER,25,25));
		sur.setPreferredSize(new Dimension (1000,100));
		sur.add(comprobar);
		sur.add(agregar);
		sur.add(eliminar);
		sur.add(generar);
		add(sur,BorderLayout.SOUTH);
		
		eliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		comprobar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				contador = 1;
				
				Integer codigo = Integer.parseInt(textoCodigo.getText());
				
				ProductoDAO dao = new ProductoDAO();
				ProductoDTO producto = new ProductoDTO(codigo);
				
				producto = dao.buscarProducto(producto);
				
				if (producto == null) {
					JOptionPane.showMessageDialog(MarcoCaja.this, "El codigo introducido no pertenece a ningun producto.","Advertencia",0);
					textoNombre.setText("");
					textoPrecio.setText("");
					textoIva.setText("");
				} else {
					
					textoNombre.setText(producto.getNombreProd());
					textoPrecio.setText(Double.toString(producto.getPrecio()));
					textoIva.setText(Double.toString(producto.getTipoIva()));
				}
			}
			
		});
		
		agregar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) datos.getModel();
				int fila = 0;

				if (productos.contains(textoNombre.getText())) {

					for (int i=0;i<model.getRowCount();i++) {
						if (model.getValueAt(i, 0).equals(textoNombre.getText())) {
							fila = i;
						}
					}
					contador++;
					double precios = Double.parseDouble(textoPrecio.getText());
					preciostot = precios * contador;
					model.setValueAt(contador, fila, 3);
					model.setValueAt(Double.toString(preciostot), fila, 1);
				} else{
					model.addRow(new Object [] {textoNombre.getText(),textoPrecio.getText(),textoIva.getText(),contador});
				}
				
				productos.add(textoNombre.getText());
			}
		});
		
		generar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setTitle("Caja");
		setIconImage(icono);
		Dimension tamanoPantalla = pantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(900,600);
		setLocation(anchoPantalla/4, alturaPantalla/4);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
}
