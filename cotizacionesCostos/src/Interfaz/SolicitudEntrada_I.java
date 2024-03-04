package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import baseDeDatos.Conect;
import clasesProyecto.Producto;
import clasesProyecto.SolicitudEntrada;

public class SolicitudEntrada_I extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<Producto> productos = new ArrayList<>();
	Conect conectar = Conect.getInstancia();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudEntrada_I frame = new SolicitudEntrada_I();
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
	public SolicitudEntrada_I() {
		this.setLocationRelativeTo(null);
		this.setTitle("Costos Y Suministros");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(126, 49, 523, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JTextField txtResponsablel = new JTextField();
		txtResponsablel.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtResponsablel.setForeground(SystemColor.textInactiveText);
		txtResponsablel.setBackground(UIManager.getColor("CheckBox.background"));
		txtResponsablel.setBounds(374, 93, 117, 20);
		panel.add(txtResponsablel);
		txtResponsablel.setColumns(10);
		
		JTextField txtTotalBienes = new JTextField();
		txtTotalBienes.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtTotalBienes.setForeground(SystemColor.textInactiveText);
		txtTotalBienes.setColumns(10);
		txtTotalBienes.setBackground(UIManager.getColor("Button.background"));
		txtTotalBienes.setBounds(374, 126, 117, 20);
		panel.add(txtTotalBienes);
		
		JTextField txtTotalEntrega = new JTextField();
		txtTotalEntrega.setBackground(SystemColor.controlHighlight);
		txtTotalEntrega.setForeground(SystemColor.textInactiveText);
		txtTotalEntrega.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtTotalEntrega.setBounds(374, 163, 117, 20);
		panel.add(txtTotalEntrega);
		
		JButton btnProductos = new JButton("Agregar Productos");
		btnProductos.setForeground(new Color(51, 51, 51));
		btnProductos.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		btnProductos.setBackground(new Color(204, 204, 204));
		btnProductos.setBounds(291, 243, 181, 20);
		panel.add(btnProductos);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setForeground(new Color(51, 51, 51));
		btnGenerar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		btnGenerar.setBackground(new Color(204, 204, 204));
		btnGenerar.setBounds(291, 274, 181, 20);
		panel.add(btnGenerar);
		
		JTextField textCantidad = new JTextField();
		textCantidad.setForeground(SystemColor.textInactiveText);
		textCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textCantidad.setBackground(UIManager.getColor("Button.background"));
		textCantidad.setBounds(110, 137, 89, 20);
		panel.add(textCantidad);
		textCantidad.setVisible(false);
		
		JTextField textNombre = new JTextField();
		textNombre.setForeground(SystemColor.textInactiveText);
		textNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textNombre.setColumns(10);
		textNombre.setBackground(UIManager.getColor("Button.background"));
		textNombre.setBounds(110, 93, 89, 20);
		panel.add(textNombre);
		textNombre.setVisible(false);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(78, 217, 89, 23);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnGuardar.setBackground(new Color(153, 153, 153));
		btnGuardar.setVisible(false);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(78, 255, 89, 23);
		panel.add(btnCerrar);
		btnCerrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnCerrar.setBackground(new Color(153, 153, 153));
		btnCerrar.setVisible(false);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setBounds(29, 24, 179, 271);
		panel.add(lblFondo);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Register (Community) (4).png"));
		lblFondo.setVisible(false);
		
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnGenerar.setEnabled(false);
				btnProductos.setEnabled(false);
				textCantidad.setVisible(true);
				textNombre.setVisible(true);
				lblFondo.setVisible(true);
				btnGuardar.setVisible(true);
				btnCerrar.setVisible(true);
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textNombre.getText();
				int quantity = Integer.parseInt(textCantidad.getText());
				String id = Producto.getGenerarId();
				Producto producto = new Producto(name, quantity, id );
				productos.add(producto);
				
				textNombre.setText("");
				textCantidad.setText("");
				
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnGenerar.setEnabled(true);
				btnProductos.setEnabled(true);
				textCantidad.setVisible(false);
				textNombre.setVisible(false);
				lblFondo.setVisible(false);
				btnGuardar.setVisible(false);
				btnCerrar.setVisible(false);
				
			}
		});
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String responsable = txtResponsablel.getText();
				int totalBienes = Integer.parseInt(txtTotalBienes.getText());
				float total = Integer.parseInt(txtTotalEntrega.getText());
				SolicitudEntrada se = new SolicitudEntrada(responsable, totalBienes, total, productos);
				String id = se.getId();
				for (Producto producto : productos) {
					producto.setIdentificador(id);
				}
				
				int selecc = JOptionPane.showConfirmDialog(lblFondo, se);
				if (JOptionPane.YES_OPTION == selecc) {
					
					try {
						
						Connection conexion = conectar.conectarBase();
						for (Producto producto : se.getProducto()) {
							PreparedStatement insertar = conexion.prepareStatement("insert into productos values (?,?,?,?)");
							insertar.setString(1, id);
							insertar.setString(2, producto.getId());
							insertar.setString(3,producto.getName());
							insertar.setInt(4, producto.getQuantity());
							insertar.executeUpdate();
						}
						
						PreparedStatement insertar = conexion.prepareStatement("insert into solicitudentradas values (?,?,?,?,?,?)");
						insertar.setString(1, se.getId());
						insertar.setString(2, se.getResponsible());
						insertar.setInt(3, se.getTotalBienes());
						insertar.setFloat(4, se.getTotalValue());
						insertar.setString(5, id);
						insertar.setString(6, se.getDate().toString());
						insertar.executeUpdate();
						
						conectar.cerrarBase();
						
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, e2);
					}
					
					txtResponsablel.setText("");
					txtTotalBienes.setText("");
					txtTotalEntrega.setText("");
					dispose();
					
				}
			}
			
		});
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (2).png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
	}

}
