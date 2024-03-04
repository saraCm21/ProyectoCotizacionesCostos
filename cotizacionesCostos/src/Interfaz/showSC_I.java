package Interfaz;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import baseDeDatos.Conect;
import clasesProyecto.Items;
import clasesProyecto.SolicitudCompra;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showSC_I extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Conect conectar = Conect.getInstancia();
	private JTextField textBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showSC_I frame = new showSC_I();
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
	public showSC_I() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 64, 720, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textAreatexto = new JTextArea();
		textAreatexto.setEditable(false);
		textAreatexto.setBounds(225, 60, 485, 191);
		panel.add(textAreatexto);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(511, 262, 100, 23);
		panel.add(btnActualizar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(621, 262, 89, 23);
		panel.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(219, 263, 56, 20);
		panel.add(lblNewLabel);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(268, 265, 192, 20);
		panel.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (8).png"));
		btnBuscar.setBounds(470, 262, 31, 23);
		panel.add(btnBuscar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (10).png"));
		lblFondo.setBounds(0, 0, 719, 297);
		panel.add(lblFondo);
		
		try {
			
			Connection conexion = conectar.conectarBase();
			PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudcompras");
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
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudcompras");
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

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String texto = textBuscar.getText();
				ArrayList<Items> itemslista = new ArrayList<>();
				int resultado = 0;
				
				 try {
					 
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM solicitudcompras");
					ResultSet consulta = seleccionar.executeQuery();
					
						while (consulta.next()) {
							if (texto.equalsIgnoreCase(consulta.getString(1))) {
								
								String responsible = consulta.getString(3);
								int identificationCard = consulta.getInt(4);
								String costCenter = consulta.getString(5);
								int budget = consulta.getInt(6);
								float total = consulta.getInt(8);
								
								try {	
									Connection conexion2 = conectar.conectarBase();
									PreparedStatement seleccionar2 = conexion2.prepareStatement("SELECT * FROM itemscompra");
									ResultSet consultaitems = seleccionar2.executeQuery();
									
									while (consultaitems.next()) {
										if (consultaitems.getString(1).equalsIgnoreCase(consulta.getString(7))) {
											
											String name = consultaitems.getString(3);
											int quantity = consultaitems.getInt(4);
											String UnidadM = consultaitems.getString(5);
											float Value = consultaitems.getFloat(6);
											
											Items item = new Items(name, quantity, UnidadM, Value);
											item.setId(consultaitems.getString(2));
											itemslista.add(item);
											break;
										}
									}
									
								} catch (Exception e3) {
									JOptionPane.showMessageDialog(lblFondo, e3);
								}
								
								SolicitudCompra solicitud1 = new SolicitudCompra(responsible, identificationCard, costCenter, budget, itemslista, total);
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
				 textBuscar.setText("");
			}
		});
		
		
	}
}
