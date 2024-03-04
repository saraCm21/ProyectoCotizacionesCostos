package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import baseDeDatos.Conect;
import clasesProyecto.ProductoInventario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class inventario_i extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textResponsable;
	private JTextField textLocalizacion;
	private JTextField textFecha;
	private JTextField textCantidad;
	private JButton btnLimpiar;
	private JButton btnNewButton_1;
	private JTextField textBuscar;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	Conect conectar = Conect.getInstancia();
	ProductoInventario pi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventario_i frame = new inventario_i();
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
	public inventario_i() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 794, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(127, 49, 523, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(249, 90, 230, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		textResponsable = new JTextField();
		textResponsable.setBounds(249, 133, 230, 20);
		panel.add(textResponsable);
		textResponsable.setColumns(10);
		
		textLocalizacion = new JTextField();
		textLocalizacion.setBounds(249, 181, 230, 20);
		panel.add(textLocalizacion);
		textLocalizacion.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(249, 226, 168, 20);
		panel.add(textFecha);
		textFecha.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(430, 226, 75, 20);
		panel.add(textCantidad);
		textCantidad.setColumns(10);
		
		btnLimpiar = new JButton("Cerrar");
		btnLimpiar.setBounds(274, 257, 89, 23);
		panel.add(btnLimpiar);
		
		btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(394, 257, 89, 23);
		panel.add(btnNewButton_1);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(310, 300, 173, 20);
		panel.add(textBuscar);
		textBuscar.setColumns(10);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (8).png"));
		btnNewButton_2.setBounds(490, 299, 29, 23);
		panel.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 2 (1).png"));
		lblNewLabel.setBounds(310, 29, 149, 20);
		panel.add(lblNewLabel);
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (6).png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = textName.getText();
				int quantity = Integer.parseInt(textCantidad.getText());
				String deadline = textFecha.getText();
				String responsible = textResponsable.getText();
				String location = textLocalizacion.getText();
				String id = ProductoInventario.getGenerarId();
				
				pi = new ProductoInventario(name, quantity, id, deadline, responsible, location);
				
				int selecc = JOptionPane.showConfirmDialog(lblFondoMenu, pi);
				if (selecc == JOptionPane.YES_OPTION) {
					
					try {
						
						Connection conexion = conectar.conectarBase();
						PreparedStatement insertar = conexion.prepareStatement("insert into productoinventario values(?,?,?,?,?,?)");
						
						insertar.setString(1, pi.getId());
						insertar.setString(2, pi.getName());
						insertar.setString(3, pi.getResponsible());
						insertar.setString(4, pi.getLocation());
						insertar.setString(5, pi.getDeadline());
						insertar.setInt(6, pi.getQuantity());
						insertar.executeUpdate();
						conectar.cerrarBase();
						
					} catch (SQLException e1) {
						
						JOptionPane.showConfirmDialog(lblFondoMenu, e1);
					}
					
					textName.setText("");
					textLocalizacion.setText("");
					textResponsable.setText("");
					textFecha.setText("");
					textCantidad.setText("");
					
				}
				
				if (selecc == JOptionPane.CANCEL_OPTION ) {
					
					textName.setText("");
					textLocalizacion.setText("");
					textResponsable.setText("");
					textFecha.setText("");
					textCantidad.setText("");
					
				}
			} 
			
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String texto = textBuscar.getText();
				int comfirmacion = 0;
				
				try {
					
					Connection conexion = conectar.conectarBase();
					PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM productoinventario");
					ResultSet consulta = seleccionar.executeQuery();
					
					while (consulta.next()) {
						
						if (texto.equalsIgnoreCase(consulta.getString(1))) {
							
							String name = consulta.getString(2);
							int quantity = consulta.getInt(6);
							String deadline = consulta.getString(5);
							String responsible = consulta.getString(3);
							String location = consulta.getString(4);
							String id = consulta.getString(1);
							
							pi = new ProductoInventario(name, quantity, id, deadline, responsible, location);
							JOptionPane.showMessageDialog(lblFondoMenu, pi);
							comfirmacion = 1;
						}
						
						if (texto.equalsIgnoreCase(consulta.getString(2))) {
							
							String name = consulta.getString(2);
							int quantity = consulta.getInt(6);
							String deadline = consulta.getString(5);
							String responsible = consulta.getString(3);
							String location = consulta.getString(4);
							String id = consulta.getString(1);
							
							pi = new ProductoInventario(name, quantity, id, deadline, responsible, location);
							JOptionPane.showMessageDialog(lblFondoMenu, pi);
							comfirmacion = 1;
						}
					}
					
					if (comfirmacion == 0) {
						JOptionPane.showMessageDialog(lblFondoMenu, "No se encontro el producto");
					}
					
					conectar.cerrarBase();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(lblFondoMenu, e2);
				}
				
				textBuscar.setText("");
			}
		});
	}
}
