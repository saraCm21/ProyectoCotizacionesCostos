package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDeDatos.Conect;
import clasesProyecto.Producto;
import clasesProyecto.SolicitudEntrada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class showSE_I extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBuscador;
	Conect conectar = Conect.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showSE_I frame = new showSE_I();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public showSE_I() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 59, 720, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textAreatexto = new JTextArea();
		textAreatexto.setBounds(225, 59, 485, 191);
		panel.add(textAreatexto);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(225, 271, 55, 17);
		panel.add(lblBuscar);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(271, 269, 194, 20);
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		JButton btnBusacar = new JButton("");
		btnBusacar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (8).png"));
		btnBusacar.setBounds(475, 268, 29, 23);
		panel.add(btnBusacar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(514, 268, 99, 23);
		panel.add(btnActualizar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(623, 268, 89, 23);
		panel.add(btnCerrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (12).png"));
		lblFondo.setBounds(0, 0, 720, 297);
		panel.add(lblFondo);
		
		try {
			
			Connection conexion = conectar.conectarBase();
			PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudentradas");
			ResultSet consulta = seleccionar.executeQuery();
			
			while (consulta.next()){
				
				textAreatexto.append("      ");
				textAreatexto.append(consulta.getString(1));
				textAreatexto.append("      ");
				textAreatexto.append(consulta.getString(2));
				textAreatexto.append("      ");
				textAreatexto.append(consulta.getString(3));
				textAreatexto.append("      ");
				textAreatexto.append("\n");
				
			}
			
			conectar.cerrarBase();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lblFondo, e);
		}

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreatexto.setText("");
				try {
					
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudentradas");
					ResultSet consulta = seleccionar.executeQuery();
					
					while (consulta.next()){
						
						textAreatexto.append("      ");
						textAreatexto.append(consulta.getString(1));
						textAreatexto.append("      ");
						textAreatexto.append(consulta.getString(2));
						textAreatexto.append("      ");
						textAreatexto.append(consulta.getString(3));
						textAreatexto.append("      ");
						textAreatexto.append("\n");
						
					}
					
					conectar.cerrarBase();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(lblFondo, e1);
				}
			}
		});
		
		btnBusacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String texto = textBuscador.getText();
				ArrayList<Producto> listaProducto = new ArrayList<>();
				int resultado = 0;
				
				 try {
					 
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudentradas");
					ResultSet consulta = seleccionar.executeQuery();
					
						while (consulta.next()) {
							if (texto.equalsIgnoreCase(consulta.getString(1))) {
								
								String responsible = consulta.getString(2);
								int totalbienes = consulta.getInt(3);
								float totalvalue = consulta.getFloat(4);
								
								try {	
									Connection conexion2 = conectar.conectarBase();
									PreparedStatement seleccionar2 = conexion2.prepareStatement("SELECT * FROM productos");
									ResultSet consultaProducto = seleccionar2.executeQuery();
									
									while (consultaProducto.next()) {
										if (consultaProducto.getString(1).equalsIgnoreCase(consulta.getString(5))) {
											
											String name = consultaProducto.getString(2);
											int quantity = consulta.getInt(4);
											String id = consulta.getString(1);
											
											Producto producto = new Producto(name, quantity, id);
											listaProducto.add(producto);
											break;
										}
									}
									
									break;
									
								} catch (Exception e3) {
									JOptionPane.showMessageDialog(lblFondo, e3);
								}
								
								SolicitudEntrada solicitud1 = new SolicitudEntrada(responsible, totalbienes, totalvalue, listaProducto);
								solicitud1.setId(consulta.getString(1));
								JOptionPane.showMessageDialog(lblFondo, solicitud1);
								resultado = 1;

							}
						}
						
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(lblFondo, e2);
				}
				 
				 if ( resultado == 0) {
					 JOptionPane.showMessageDialog(lblFondo, "No se ha encontrado la orden");
				 }
				 textBuscador.setText("");
				
			}
		});
		
	}

}
