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
import clasesProyecto.SolicitudSalida;

public class SolicitudSalida_I extends JFrame {

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
					SolicitudSalida_I frame = new SolicitudSalida_I();
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
	public SolicitudSalida_I() {
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
		
		
		JTextField txtResponsable = new JTextField();
		txtResponsable.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtResponsable.setForeground(SystemColor.textInactiveText);
		txtResponsable.setBackground(UIManager.getColor("CheckBox.background"));
		txtResponsable.setBounds(374, 93, 117, 20);
		panel.add(txtResponsable);
		txtResponsable.setColumns(10);
		
		JTextField txtEntrega = new JTextField();
		txtEntrega.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtEntrega.setForeground(SystemColor.textInactiveText);
		txtEntrega.setColumns(10);
		txtEntrega.setBackground(UIManager.getColor("Button.background"));
		txtEntrega.setBounds(374, 126, 117, 20);
		panel.add(txtEntrega);
		
		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setBackground(SystemColor.controlHighlight);
		txtValorTotal.setForeground(SystemColor.textInactiveText);
		txtValorTotal.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtValorTotal.setBounds(374, 163, 117, 20);
		panel.add(txtValorTotal);
		
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
		textCantidad.setColumns(10);
		textCantidad.setBackground(UIManager.getColor("Button.background"));
		textCantidad.setBounds(110, 136, 89, 20);
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
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (4).png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
		
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
				
				textCantidad.setText("");
				textNombre.setText("");
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
				
				String responsable = txtResponsable.getText();
				String fecha = txtEntrega.getText();
				int total = Integer.parseInt(txtValorTotal.getText());
				
				SolicitudSalida ss = new SolicitudSalida(responsable, fecha, total, productos);
				String id = ss.getId();
				for (Producto producto : ss.getProduct()) {
					producto.setIdentificador(id);
				}
				
				int selecc = JOptionPane.showConfirmDialog(lblFondoMenu, ss);
				if (JOptionPane.YES_OPTION == selecc) {
					
					try {
						Connection conexion = conectar.conectarBase();
						for (Producto producto : ss.getProduct()) {
							PreparedStatement insertar = conexion.prepareStatement("insert into productos values (?,?,?,?)");
							insertar.setString(1, id);
							insertar.setString(2, producto.getId());
							insertar.setString(3,producto.getName());
							insertar.setInt(4, producto.getQuantity());
							insertar.executeUpdate();
						}
						
						PreparedStatement insertar = conexion.prepareStatement("insert into solicitudsalida values (?,?,?,?,?,?)");
						insertar.setString(1, ss.getId());
						insertar.setString(2, ss.getDate().toString());
						insertar.setString(3, ss.getResponsible());
						insertar.setString(4, ss.getDeadline());
						insertar.setInt(5, ss.getTotal());
						insertar.setString(6, id);
						insertar.executeUpdate();
						
						conectar.cerrarBase();
						
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, e2);
					}
					
					txtResponsable.setText("");
					txtEntrega.setText("");
					txtValorTotal.setText("");
					dispose();
				}
			}
			
		});
		
		
	}
}
