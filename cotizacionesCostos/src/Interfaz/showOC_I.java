
package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import baseDeDatos.Conect;
import clasesProyecto.Items;
import clasesProyecto.OrdenContractual;
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

public class showOC_I extends JFrame {

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
					showOC_I frame = new showOC_I();
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
	public showOC_I() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 61, 720, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textAreatexto = new JTextArea();
		textAreatexto.setEditable(false);
		textAreatexto.setBounds(223, 60, 485, 191);
		panel.add(textAreatexto);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(223, 269, 56, 19);
		panel.add(lblBuscar);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(269, 268, 184, 20);
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBounds(502, 267, 107, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(619, 267, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (8).png"));
		btnBuscar.setBounds(463, 267, 29, 23);
		panel.add(btnBuscar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (11).png"));
		lblFondo.setBounds(0, 0, 720, 294);
		panel.add(lblFondo);
		
		try {
			
			Connection conexion = conectar.conectarBase();
			PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM ordencontractual");
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreatexto.setText("");
				try {
					
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM ordencontractual");
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
				
				String texto = textBuscador.getText();
				ArrayList<Items> itemslista = new ArrayList<>();
				int resultado = 0;
				
				 try {
					 
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM ordencontractual");
					ResultSet consulta = seleccionar.executeQuery();
					
						while (consulta.next()) {
							if (texto.equalsIgnoreCase(consulta.getString(1))) {
								
								int nit = consulta.getInt(3);
								String provider = consulta.getString(4);
								String deadline = consulta.getString(6);
								int total = consulta.getInt(5);
								
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
								
								OrdenContractual orden = new OrdenContractual(nit, provider, deadline, total, itemslista);
								orden.setId(consulta.getString(1));
								JOptionPane.showMessageDialog(lblFondo, orden);
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
