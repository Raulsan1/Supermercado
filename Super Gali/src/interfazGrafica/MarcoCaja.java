package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import supermercadoDAO.DetalleFacturaDAO;
import supermercadoDAO.FacturaDAO;
import supermercadoDAO.ProductoDAO;
import supermercadoModelo.DetalleFacturaDTO;
import supermercadoModelo.FacturaDTO;
import supermercadoModelo.ProductoDTO;
import varios.Validador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
* Clase que representa a el Marco de el cajero
* @author Raúl Sanz Andrés
* @version 1.0
*/

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
	
	private int contador,i;

	private ProductoDTO producto;

	double precioTotal,preciosJunto;
	
	/**
	 * Constructor del marco de la caja
	 */

	public MarcoCaja () {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/imagenes/supergali.jpg");
		
		productos = new TreeMap<Integer,Integer>();
		productosNombre = new LinkedHashSet<String>();
		precioTotal = 0.00;
		
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
		JLabel total = new JLabel ("Precio total: ");
		JLabel numTotal = new JLabel ("0.00");
		
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
		oeste.add(total);
		oeste.add(numTotal);
		add(oeste,BorderLayout.WEST);
		
		
		model = new DefaultTableModel (columnas,0);
		datos = new JTable (model);
		
		este = new JPanel();
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

				model.setRowCount(0);
				productosNombre.clear();
				productos.clear();
				textoCodigo.setText("");
				textoNombre.setText("");
				textoPrecio.setText("");
				textoIva.setText("");
				textoPrecioIva.setText("");
			}
			
		});
		
		eliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int fila = datos.getSelectedRow();
				int i = 0;
				String nombre = "";
				
				if (datos.getSelectedRow()!=-1) {
					
					for (String elemento: productosNombre) {
						
						if (i == fila){
							
			                productosNombre.remove(elemento);
			                nombre = elemento;
			                break;
			            }
			            i++;
			            
					}
					
					ProductoDTO dto = new ProductoDTO(nombre);
					ProductoDAO dao = new ProductoDAO();
					ProductoDTO producto = dao.buscarProducto(dto);
					
					productos.remove(producto.getCodProducto());
					model.removeRow(fila);
				}
			}
		});
		
		comprobar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double preciosIva;
				contador = 0;
			
				Validador vacio = new Validador();
				if (vacio.isInteger(textoCodigo.getText())) {
					
					if (vacio.isVacio(textoCodigo.getText())==false) {
						
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
				} else {
					JOptionPane.showMessageDialog(MarcoCaja.this,"Por favor, escriba dato valido","Advertencia",1);
				}
				
								
			}		
		});
		
		agregar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double preciosIva;			
				
				Validador vacio = new Validador();
				
				if (vacio.isInteger(textoCodigo.getText())) {
					
					if (vacio.isVacio(textoCodigo.getText())==false) {
						
						JOptionPane.showMessageDialog(MarcoCaja.this,"Por favor, escriba un codigo","Advertencia",1);	
						
					}else {
						
						ProductoDAO dao = new ProductoDAO();
						producto = new ProductoDTO(Integer.parseInt(textoCodigo.getText()));
						producto = dao.buscarProducto(producto);
						
						int fila = 0;
						
						if (dao.comprobarPorducto(producto)==false) {
							
							JOptionPane.showMessageDialog(MarcoCaja.this,"El codigo de producto "+textoCodigo.getText()+" no existe.","Advertencia",0);
							
						} else {
							
							int stock = producto.getStock();
							int stockReduc = 0;
							
							if (stock==0) {
								
								JOptionPane.showMessageDialog(MarcoCaja.this,"No existe mas stock de este producto","Advertencia",0);
								
							} else {
								
								if (productosNombre.contains(producto.getNombreProd())) {

									for (int i=0;i<model.getRowCount();i++) {
										if (model.getValueAt(i, 0).equals(producto.getNombreProd())) {
											fila = i;
										}
										
									}
									
									numTotal.setText(String.format("%.2f",precioTotal));
									contador++;
									stockReduc = stock - contador;
									
									if (stockReduc<=-1) {
										
										JOptionPane.showMessageDialog(MarcoCaja.this,"No existe mas stock de este producto","Advertencia",0);
										
									} else {

										preciosIva = (producto.getPrecio() * producto.getTipoIva() /100)+producto.getPrecio();
										preciosJunto = preciosIva * contador;
										preciosJunto = (double)Math.round(preciosJunto * 100) / 100;
										
										model.setValueAt(contador, fila, 2);
										model.setValueAt(preciosJunto, fila, 1);
										model.setValueAt(producto.getNombreProd(), fila, 0);
										productos.put(producto.getCodProducto(), contador);
										
									}
									
								} else{
									
									if (stockReduc<=-1) {
										
										JOptionPane.showMessageDialog(MarcoCaja.this,"No existe mas stock de este producto","Advertencia",0);
										
									} else {
									
										preciosIva = (producto.getPrecio() * producto.getTipoIva() /100)+producto.getPrecio();
										model.addRow(new Object [] {producto.getNombreProd(),String.format("%.2f", preciosIva),1});
										contador = 1;
										productos.put(producto.getCodProducto(), contador);
										
									}

								}
								productosNombre.add(producto.getNombreProd());
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(MarcoCaja.this,"Por favor, escriba dato valido","Advertencia",1);
				}
					
			}
		});
		
		generar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if (productosNombre.isEmpty()) {
					
					JOptionPane.showMessageDialog(MarcoCaja.this,"No ha introducido ningun producto","Advertencia",0);
					
				} else {
					
					precioTotal = 0.00;

					
					for (Entry<Integer, Integer> codigo: productos.entrySet()) {
						
						ProductoDTO dto1 = new ProductoDTO(codigo.getKey());
						ProductoDAO dao1 = new ProductoDAO();
						dto1 = dao1.buscarProducto(dto1);
						
						double preciosIva = (dto1.getPrecio() * dto1.getTipoIva() /100)+dto1.getPrecio();
						precioTotal = preciosIva * codigo.getValue() + precioTotal;
						
					}
					numTotal.setText(String.format("%.2f", precioTotal));
					
					try {
						
						String sdinero = JOptionPane.showInputDialog("Escribe el dinero a pagar");
						double dinero = Double.parseDouble(sdinero);
						if (dinero < precioTotal) {
							JOptionPane.showMessageDialog(MarcoCaja.this,"Valor escrito por debajo del precio a pagar","Error",1);
						}else {
							
							i++;
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					        		
							FacturaDAO daof = new FacturaDAO();
							FacturaDTO dtof = new FacturaDTO("T"+i,01, dtf.format(LocalDateTime.now()), (double)Math.round(precioTotal * 100) / 100,dinero);
							daof.nuevaFactura(dtof);
							
							for (Entry<Integer, Integer> codigo: productos.entrySet()) {
								
								ProductoDTO dto = new ProductoDTO(codigo.getKey());
								ProductoDAO dao = new ProductoDAO();
								dto = dao.buscarProducto(dto);
								
								dto.setStock(dto.getStock() - codigo.getValue());
								dao.actualizarStock(dto);
								
								double precioIva = (dto.getPrecio()*dto.getTipoIva()/100)+dto.getPrecio();
								double precioPorProducto = precioIva * codigo.getValue();
								
								DetalleFacturaDTO dtod = new DetalleFacturaDTO("T"+i, codigo.getKey(), codigo.getValue(), (double)Math.round(precioPorProducto * 100) / 100);
								DetalleFacturaDAO daod = new DetalleFacturaDAO();
								daod.nuevaDetalleFactura(dtod);
							}
							
							crearPdf(dtf,dtof);
							
							model.setRowCount(0);
							productosNombre.clear();
							productos.clear();
							precioTotal = 0.00;
							numTotal.setText(String.format("%.2f",precioTotal));
							
						}
						
					} catch (Exception e2) {
					 System.out.println(e2.getLocalizedMessage());	
					}
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
		setResizable(false);
	}
	
	/**
	 * Metodo que crea un pdf externo donde se imprime toda la informacion respecto a la factura
	 * @param dtf fecha y hora actual
	 * @param factura factura que antes se ha obtendido de la base de datos
	 */
	
	public void crearPdf (DateTimeFormatter dtf,FacturaDTO factura) {
		
		
		try {
			double precioSinIva1 = 0;
			double precioSinIva2 = 0;
			double precioSinIva3 = 0;
			
			double tipoIva1 = 0;
			double tipoIva2 = 0;
			double tipoIva3 = 0;
			
			String espacio = "      ";
			String espacio2 = "     ";
			String codigo = factura.getCodFactura();
			
			FacturaDAO daof = new FacturaDAO();
			FacturaDTO dtof = new FacturaDTO(codigo);
			dtof = daof.buscarFactura(dtof);
			
			DecimalFormat f = new DecimalFormat("00.00");
			
			DetalleFacturaDAO daod = new DetalleFacturaDAO();
			DetalleFacturaDTO dtod = new DetalleFacturaDTO(codigo);
			ArrayList <DetalleFacturaDTO> detalles = daod.buscarDetalleFactura(dtod);

			
			Document documento = new Document();

			PdfWriter.getInstance(documento, new FileOutputStream("Facturas/Factura "+i+".pdf"));
			
			documento.open();
			
			Paragraph titulo = new Paragraph("SUPER GALI",FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);
			
			Paragraph fechaHora = new Paragraph(dtf.format(LocalDateTime.now()),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			fechaHora.setAlignment(Element.ALIGN_CENTER);
			documento.add(fechaHora);
			
			Paragraph facturaCaja = new Paragraph("N. FACTURA: "+dtof.getCodFactura()+"                    N. CAJA: "+dtof.getCaja(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			facturaCaja.setAlignment(Element.ALIGN_CENTER);
			documento.add(facturaCaja);
			
			documento.add(Chunk.NEWLINE);
			
			for (DetalleFacturaDTO producto : detalles) {
				
				ProductoDAO dao = new ProductoDAO();
				ProductoDTO dto = new ProductoDTO(producto.getCodigoProducto());
				dto = dao.buscarProducto(dto);
				
				Paragraph p = new Paragraph(null, FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
				p.add(dto.getNombreProd());
				p.add(espacio2+espacio2+espacio2+espacio2+espacio2+"   ");
				p.add(producto.getCantidad().toString());
				p.add("X");
				p.add(espacio2+espacio2+espacio2+espacio2+espacio2+"   ");
				p.add(f.format(producto.getPrecio()));
				p.add(espacio2+espacio2+espacio2+espacio2+espacio2+"   ");
				p.add(f.format(dto.getTipoIva()));
				p.add("%");
				p.setAlignment(Element.ALIGN_RIGHT);
				
				if (dto.getTipoIva()==4.00) {
					tipoIva1 = dto.getTipoIva();
					precioSinIva1 = (dto.getPrecio()*producto.getCantidad())+precioSinIva1;
				}
				
				if (dto.getTipoIva()==10.00) {
					tipoIva2 = dto.getTipoIva();
					precioSinIva2 = (dto.getPrecio()*producto.getCantidad())+precioSinIva2;
				}
				if (dto.getTipoIva()==21.00) {
					tipoIva3 = dto.getTipoIva();
					precioSinIva3 = (dto.getPrecio()*producto.getCantidad())+precioSinIva3;
				}

				documento.add(p);
			}
			
			
			Paragraph __ = new Paragraph("**************************************************************",FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			__.setAlignment(Element.ALIGN_CENTER);
			documento.add(__);
			
			documento.add(Chunk.NEWLINE);
			
			Paragraph pago = new Paragraph("TOTAL A PAGAR"+"                                                                           "+dtof.getPrecioTotal(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			pago.setAlignment(Element.ALIGN_LEFT);
			documento.add(pago);
			
			Paragraph efectivo = new Paragraph("EFECTIVO"+"                                                                                      "+dtof.getDinero(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			pago.setAlignment(Element.ALIGN_LEFT);
			documento.add(efectivo);
			
			
			double cambioo = (double)Math.round((dtof.getDinero()-dtof.getPrecioTotal()) * 100) / 100;
			
			Paragraph cambio = new Paragraph("CAMBIO"+"                                                                                          "+cambioo,FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			pago.setAlignment(Element.ALIGN_LEFT);
			documento.add(cambio);
			
			documento.add(Chunk.NEWLINE);
			
			double cuota1 = (precioSinIva1 * tipoIva1)/100;
			double cuota2 = (precioSinIva2 * tipoIva2)/100;
			double cuota3 = (precioSinIva3 * tipoIva3)/100;
			
			//IVA 			BASE 			CUOTA			TOTAL
			Paragraph row = new Paragraph("   IVA                 BASE                 CUOTA              TOTAL",FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			row.setAlignment(Element.ALIGN_CENTER);
			documento.add(row);
			
			Paragraph ___ = new Paragraph("**************************************************************",FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			___.setAlignment(Element.ALIGN_CENTER);
			documento.add(___);
			
			
			Paragraph iva1 = new Paragraph(f.format(tipoIva1)+espacio+espacio+espacio+f.format(precioSinIva1)+espacio+espacio+espacio+f.format(cuota1)+espacio+espacio+espacio+"  "+f.format(precioSinIva1+cuota1),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			iva1.setAlignment(Element.ALIGN_CENTER);
			documento.add(iva1);
			Paragraph iva2 = new Paragraph(f.format(tipoIva2)+espacio+espacio+espacio+f.format(precioSinIva2)+espacio+espacio+espacio+f.format(cuota2)+espacio+espacio+espacio+"  "+f.format(precioSinIva2+cuota2),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			iva2.setAlignment(Element.ALIGN_CENTER);
			documento.add(iva2);
			Paragraph iva3 = new Paragraph(f.format(tipoIva3)+espacio+espacio+espacio+f.format(precioSinIva3)+espacio+espacio+espacio+f.format(cuota3)+espacio+espacio+espacio+"  "+f.format(precioSinIva3+cuota3),FontFactory.getFont(FontFactory.TIMES_ROMAN,15, Font.BOLD, BaseColor.BLACK));
			iva3.setAlignment(Element.ALIGN_CENTER);
			documento.add(iva3);
			
			documento.close();

		
			JOptionPane.showMessageDialog(MarcoCaja.this,"Factura creada","Confirmacion",2);
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}catch (DocumentException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
}
