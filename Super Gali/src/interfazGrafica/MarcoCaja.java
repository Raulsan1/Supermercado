package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import supermercadoDAO.Conectar;
import supermercadoDAO.ProductoDAO;
import supermercadoModelo.ProductoDTO;
import varios.Validador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class MarcoCaja extends JFrame{

	private String [] columnas = {"Nombre","Precio con IVA","Cantidad"};
	
	private JButton eliminar;
	private JButton comprobar;
	private JButton agregar;
	private JButton generar;
	private JButton eliminarTodo;
	
	private JTextField textoCodigo;
	private JTextField textoNombre;
	private JTextField textoPrecio;
	private JTextField textoIva;	
	private JTextField textoPrecioIva;
	
	private JPanel este;
	private JPanel oeste;
	private JPanel sur;
	
	private JTable datos;
	private DefaultTableModel model;
	private TreeMap <Integer,Integer> productos;
	private LinkedHashSet <String> productosNombre;
	
	private int contador;

	private ProductoDTO producto;

	public MarcoCaja () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		productos = new TreeMap<Integer,Integer>();
		productosNombre = new LinkedHashSet<String>();
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
		model = new DefaultTableModel (columnas,0);
		datos = new JTable (model);
		este.add(new JScrollPane(datos));
		este.setPreferredSize(new Dimension (500,200));
		add(este, BorderLayout.EAST);
		
		
		eliminar = new JButton ("Quitar producto");
		comprobar = new JButton ("Comprobar codigo");
		agregar = new JButton ("Agregar producto");
		generar = new JButton ("Generar factura");
		eliminarTodo = new JButton ("Eliminar todo");
		
		sur = new JPanel();
		sur.setLayout(new FlowLayout (FlowLayout.CENTER,25,25));
		sur.setPreferredSize(new Dimension (1000,100));
		sur.add(comprobar);
		sur.add(agregar);
		sur.add(eliminar);
		sur.add(eliminarTodo);
		sur.add(generar);
		
		add(sur,BorderLayout.SOUTH);
		eliminarTodo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) datos.getModel();

				model.setRowCount(0);
				productosNombre.clear();
				productos.clear();
			}
			
		});
		
		eliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int fila = datos.getSelectedRow();
				int i = 0;
				
				if (datos.getSelectedRow()!=-1) {
					for (String elemento: productosNombre) {
						
						if (i == fila)
			            {
			                productosNombre.remove(elemento);
			                break;
			            }
			            i++;
					}
					model.removeRow(fila);
					System.out.println(productosNombre);
				} 
			}
		});
		
		comprobar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double preciosIva;
				contador = 0;
			
				Validador vacio = new Validador();
				
				if (vacio.validarVacio(textoCodigo.getText())==false) {
					
					JOptionPane.showMessageDialog(MarcoCaja.this,"Por favor, escriba un codigo","Advertencia",1);	
				} else {
					
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
				
				
			}
			
		});
		
		agregar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double precio = 0;
				double iva = 0;
				double preciostot;
				double preciosIva;
				
				Validador vacio = new Validador();
				
				if (vacio.validarVacio(textoCodigo.getText())==false) {
					
					JOptionPane.showMessageDialog(MarcoCaja.this,"Por favor, escriba un codigo","Advertencia",1);				
				}else {
					
					ProductoDAO dao = new ProductoDAO();
					producto = new ProductoDTO(Integer.parseInt(textoCodigo.getText()));
					producto = dao.buscarProducto(producto);
					
					DefaultTableModel model = (DefaultTableModel) datos.getModel();
					int fila = 0;
					
					if (dao.comprobarPorducto(producto)==false) {
						
						JOptionPane.showMessageDialog(MarcoCaja.this,"El codigo de producto "+textoCodigo.getText()+" no existe.","Advertencia",0);
					} else {
						
						int stock = producto.getStock();
						
						if (productosNombre.contains(producto.getNombreProd())) {

							for (int i=0;i<model.getRowCount();i++) {
								if (model.getValueAt(i, 0).equals(producto.getNombreProd())) {
									fila = i;
								}
							}
							contador++;
							stock = stock - contador;
							if (stock<=-1) {
								JOptionPane.showMessageDialog(MarcoCaja.this,"No existe mas stock de este producto","Advertencia",0);
								
							} else {
								System.out.println(stock);
								precio = producto.getPrecio();
								iva = producto.getTipoIva();
								preciosIva = (precio * iva /100)+precio;
								preciostot = preciosIva * contador;
								model.setValueAt(contador, fila, 2);
								model.setValueAt(new DecimalFormat("#.##").format(preciostot), fila, 1);
								model.setValueAt(producto.getNombreProd(), fila, 0);
								productos.put(producto.getCodProducto(), contador);
							}
							
						} else{
							precio = producto.getPrecio();
							iva = producto.getTipoIva();
							preciosIva = (precio * iva /100)+precio;
							model.addRow(new Object [] {producto.getNombreProd(),String.format("%.2f", preciosIva),1});
							contador = 1;
							
						}
						productosNombre.add(producto.getNombreProd());
						
						
						System.out.println(productos);
						System.out.println(productosNombre);
					}
				}
				
			}
		});
		
		generar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				Document documento = new Document();
				int i = 1;
				
				try {
					PdfWriter.getInstance(documento, new FileOutputStream("/Documentos/Desktop/DAW/PRG/Java/Supermercado/Super Gali/Facturas/Factura numero "+(i++)+".pdf"));
					documento.open();
					
					PdfPTable tabla = new PdfPTable(3);
					tabla.addCell("Nombre");
					tabla.addCell("Precio");
					tabla.addCell("Cantidad");
					
					try {
						
						tabla.addCell(textoNombre.getText());
						tabla.addCell(textoPrecio.getText());
						tabla.addCell(productos.get(1).toString());
						
						documento.add(tabla);
						
					} catch(DocumentException e3) {
						
					}
					
					documento.close();
					JOptionPane.showMessageDialog(MarcoCaja.this,"Factura creada","Confirmacion",2);
					
				} catch (DocumentException | FileNotFoundException e2) {
					
				}
				
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
