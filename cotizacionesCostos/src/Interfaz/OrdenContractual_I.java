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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import baseDeDatos.Conect;
import clasesProyecto.Items;
import clasesProyecto.OrdenContractual;

import javax.swing.DefaultComboBoxModel;

public class OrdenContractual_I extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNit;
	private JTextField txtProveedor;
	private JTextField txtFechaE;
	private JButton btnItems;
	private JButton btnGenerar;
	private JTextField textCantidad;
	private JTextField textNombre;
	private JTextField textValor;
	ArrayList<Items> items = new ArrayList<>();
	Conect conectar = Conect.getInstancia();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenContractual_I frame = new OrdenContractual_I();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OrdenContractual_I() {
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
		
		
		txtNit = new JTextField();
		txtNit.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtNit.setForeground(SystemColor.textInactiveText);
		txtNit.setBackground(UIManager.getColor("CheckBox.background"));
		txtNit.setBounds(374, 93, 117, 20);
		panel.add(txtNit);
		txtNit.setColumns(10);
		
		txtProveedor = new JTextField();
		txtProveedor.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtProveedor.setForeground(SystemColor.textInactiveText);
		txtProveedor.setColumns(10);
		txtProveedor.setBackground(UIManager.getColor("Button.background"));
		txtProveedor.setBounds(374, 126, 117, 20);
		panel.add(txtProveedor);
		
		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setBackground(SystemColor.controlHighlight);
		txtValorTotal.setForeground(SystemColor.textInactiveText);
		txtValorTotal.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtValorTotal.setBounds(374, 163, 117, 20);
		panel.add(txtValorTotal);
		
		txtFechaE = new JTextField();
		txtFechaE.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtFechaE.setBounds(374, 196, 117, 20);
		panel.add(txtFechaE);
		txtFechaE.setForeground(SystemColor.textInactiveText);
		txtFechaE.setColumns(10);
		txtFechaE.setBackground(UIManager.getColor("Button.background"));
		
		btnItems = new JButton("Agregar Items");
		btnItems.setForeground(new Color(51, 51, 51));
		btnItems.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		btnItems.setBackground(new Color(204, 204, 204));
		btnItems.setBounds(291, 243, 181, 20);
		panel.add(btnItems);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setForeground(new Color(51, 51, 51));
		btnGenerar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		btnGenerar.setBackground(new Color(204, 204, 204));
		btnGenerar.setBounds(291, 274, 181, 20);
		panel.add(btnGenerar);
		
		textCantidad = new JTextField();
		textCantidad.setForeground(SystemColor.textInactiveText);
		textCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textCantidad.setColumns(10);
		textCantidad.setBackground(UIManager.getColor("Button.background"));
		textCantidad.setBounds(110, 111, 89, 20);
		panel.add(textCantidad);
		textCantidad.setVisible(false);
		
		textNombre = new JTextField();
		textNombre.setForeground(SystemColor.textInactiveText);
		textNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textNombre.setColumns(10);
		textNombre.setBackground(UIManager.getColor("Button.background"));
		textNombre.setBounds(110, 80, 89, 20);
		panel.add(textNombre);
		textNombre.setVisible(false);
		
		JComboBox comboxMedida = new JComboBox();
		comboxMedida.setModel(new DefaultComboBoxModel(new String[] {"", "m", "cm", "Kg", "g"}));
		comboxMedida.setForeground(SystemColor.textInactiveText);
		comboxMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		comboxMedida.setBackground(UIManager.getColor("Button.background"));
		comboxMedida.setBounds(110, 139, 89, 20);
		panel.add(comboxMedida);
		comboxMedida.setVisible(false);
		
		textValor = new JTextField();
		textValor.setForeground(SystemColor.textInactiveText);
		textValor.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textValor.setColumns(10);
		textValor.setBackground(UIManager.getColor("Button.background"));
		textValor.setBounds(110, 170, 89, 20);
		panel.add(textValor);
		textValor.setVisible(false);
		
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
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Register (Community) (1).png"));
		lblFondo.setVisible(false);
		
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnGenerar.setEnabled(false);
				btnItems.setEnabled(false);
				textCantidad.setVisible(true);
				comboxMedida.setVisible(true);
				textNombre.setVisible(true);
				textValor.setVisible(true);
				lblFondo.setVisible(true);
				btnGuardar.setVisible(true);
				btnCerrar.setVisible(true);
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textNombre.getText();
				int quantity = Integer.parseInt(textCantidad.getText());
				String unitM = comboxMedida.getSelectedItem().toString();
				float value = Integer.parseInt(textValor.getText());
				
				Items nuevoItem = new Items(name, quantity, unitM, value);
				items.add(nuevoItem);
				
				textCantidad.setText("");
				textNombre.setText("");
				textValor.setText("");
				comboxMedida.setSelectedItem("");
				
				textCantidad.setText("");
				textNombre.setText("");
				textValor.setText("");
				comboxMedida.setSelectedItem("");
				
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnGenerar.setEnabled(true);
				btnItems.setEnabled(true);
				textCantidad.setVisible(false);
				comboxMedida.setVisible(false);
				textNombre.setVisible(false);
				textValor.setVisible(false);
				lblFondo.setVisible(false);
				btnGuardar.setVisible(false);
				btnCerrar.setVisible(false);
				
			}
		});
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nit = Integer.parseInt(txtNit.getText());
				String provider = txtProveedor.getText();
				String deadline = txtFechaE.getText();
				int total = Integer.parseInt(txtValorTotal.getText());
				
				OrdenContractual orden = new OrdenContractual(nit, provider, deadline, total, items);
				String id = orden.getId();
				for (Items items : orden.getItems()) {
					items.setIdentificador(id);
				}
				
				int selecc = JOptionPane.showConfirmDialog(lblFondo, orden);
				if (JOptionPane.YES_OPTION == selecc) {
					
					try {
						Connection conexion = conectar.conectarBase();	
						for (Items items : orden.getItems()) {
							PreparedStatement insertarItem = conexion.prepareStatement("insert into itemscompra values(?,?,?,?,?,?,?)");
							insertarItem.setString(1, id);
							insertarItem.setString(2, items.getId());
							insertarItem.setString(3, items.getName());
							insertarItem.setInt(4, items.getQuantity());
							insertarItem.setString(5, items.getUnitM());
							insertarItem.setFloat(6, items.getValue());
							insertarItem.setFloat(7, items.getTotalValue());
							insertarItem.executeUpdate();


						}
						
						PreparedStatement insertar = conexion.prepareStatement("insert into ordencontractual values(?,?,?,?,?,?,?)");
						insertar.setString(1, orden.getId().trim());
						insertar.setString(2, orden.getDate().toString());
						insertar.setInt(3, orden.getNit());
						insertar.setString(4, orden.getProvider().trim());
						insertar.setInt(5, orden.getTotal());
						insertar.setString(6, orden.getDeadline().trim());
						insertar.setString(7, id);
						insertar.executeUpdate();

						conectar.cerrarBase();
						
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, e2);
					}
					
					txtNit.setText("");
					txtProveedor.setText("");
					txtValorTotal.setText("");
					txtFechaE.setText("");
					dispose();
				}
			}
			
		});
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (1).png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
		
	}
	
}
