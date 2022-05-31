package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import supermercadoDAO.ProductoDAO;
import supermercadoModelo.ProductoDTO;

public class MarcoCaja extends JFrame{

	private String [] columnas = {"Nombre","PrecioIva","Cantidad"};
	
	private JButton eliminar;
	private JButton comprobar;
	private JButton agregar;
	private JButton generar;
	
	private JTextField textoCodigo;
	private JTextField textoNombre;
	private JTextField textoPrecio;
	private JTextField textoIva;	
	private JTextField textoPrecioIva;
	
	private JPanel este;
	private JPanel oeste;
	private JPanel sur;
	
	private JTable datos;
	private TreeMap <Integer,Integer> productos;
	private HashSet <String> productosNombre;
	
	private int contador;
	private double preciostot;
	private double preciosIva;

	private ProductoDTO producto;

	public MarcoCaja () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		productos = new TreeMap<Integer,Integer>();
		productosNombre = new HashSet<String>();
		setLayout(new BorderLayout());
		
		JLabel codigo = new JLabel("Codigo");
		textoCodigo = new JTextField (20);
		JLabel nombre = new JLabel("Nombre");
		textoNombre = new JTextField (20);
		JLabel precio = new JLabel("Precio");
		textoPrecio = new JTextField (20);
		JLabel iva = new JLabel("IVA");
		textoIva = new JTextField (20);
		JLabel precioIva = new JLabel("Precio con IVA");
		textoPrecioIva = new JTextField (15); 
		
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
		oeste.add(precioIva);
		oeste.add(textoPrecioIva);
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
				
				int fila = 0;
				
				DefaultTableModel model = (DefaultTableModel) datos.getModel();
				
				if (datos.getSelectedRow() != -1) {
					for (int i=0;i<model.getRowCount();i++) {
						if (model.getValueAt(i, 0).equals(textoNombre.getText())) {
							fila = i;
						}
					}
					System.out.println(fila);
					productosNombre.remove(model.getValueAt(fila, 0));
					model.removeRow(datos.getSelectedRow());	
				}
				System.out.println(productosNombre);
			}
		});
		
		comprobar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				contador = 0;
				
				Integer codigo = Integer.parseInt(textoCodigo.getText());
				
				ProductoDAO dao = new ProductoDAO();
				producto = new ProductoDTO(codigo);
				
				producto = dao.buscarProducto(producto);
				
				if (producto == null) {
					JOptionPane.showMessageDialog(MarcoCaja.this, "El codigo introducido no pertenece a ningun producto.","Advertencia",0);
					textoCodigo.setText("");
					textoNombre.setText("");
					textoPrecio.setText("");
					textoIva.setText("");
					textoPrecioIva.setText("");
				} else {
					
					preciosIva = (producto.getPrecio()*producto.getTipoIva()/100)+producto.getPrecio();
					
					textoNombre.setText(producto.getNombreProd());
					textoPrecio.setText(Double.toString(producto.getPrecio()));
					textoIva.setText(Double.toString(producto.getTipoIva()));
					textoPrecioIva.setText(String.format("%.2f", preciosIva));
				}
			}
			
		});
		
		agregar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProductoDAO dao = new ProductoDAO();
				
				producto = new ProductoDTO(Integer.parseInt(textoCodigo.getText()));
				producto = dao.buscarProducto(producto);
				int stock = producto.getStock();
				
				DefaultTableModel model = (DefaultTableModel) datos.getModel();
				int fila = 0;
				
				if (productosNombre.contains(textoNombre.getText())) {

					for (int i=0;i<model.getRowCount();i++) {
						if (model.getValueAt(i, 0).equals(textoNombre.getText())) {
							fila = i;
						}
					}
					contador++;
					stock = stock - contador;
					if (stock==-1) {
						
						JOptionPane.showMessageDialog(MarcoCaja.this,"No existe mas stock de este producto","Advertencia",0);
						
					} else {
						System.out.println(stock);
						double precio = Double.parseDouble(textoPrecio.getText());
						double iva = Double.parseDouble(textoIva.getText());
						preciosIva = (precio * iva /100)+precio;
						preciostot = preciosIva * contador;
						model.setValueAt(contador, fila, 2);
						model.setValueAt(new DecimalFormat("#.##").format(preciostot), fila, 1);
						model.setValueAt(textoNombre.getText(), fila, 0);
					}
					
				} else{
					model.addRow(new Object [] {textoNombre.getText(),String.format("%.2f", preciosIva),1});
					contador = 1;
					
				}
				productosNombre.add(textoNombre.getText());
				productos.put(producto.getCodProducto(), contador);
				
				System.out.println(productos);
				System.out.println(productosNombre);
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
