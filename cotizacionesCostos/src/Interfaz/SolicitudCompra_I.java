package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDeDatos.Conect;
import clasesProyecto.Items;
import clasesProyecto.SolicitudCompra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SolicitudCompra_I extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtResponsable;
	private JTextField txtIdentificacion;
	private JTextField txtRubro;
	private JButton btnItems;
	private JButton btnGenerar;
	private JTextField textCantidad;
	private JTextField textNombre;
	private JTextField textValor;
	private static SolicitudCompra_I frameSC;
	Conect conectar = Conect.getInstancia();
	
	ArrayList<Items> items = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameSC = new SolicitudCompra_I();
					frameSC.setVisible(true);
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
	public SolicitudCompra_I() {
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
		
		
		txtResponsable = new JTextField();
		txtResponsable.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtResponsable.setForeground(SystemColor.textInactiveText);
		txtResponsable.setBackground(UIManager.getColor("CheckBox.background"));
		txtResponsable.setBounds(374, 93, 117, 20);
		panel.add(txtResponsable);
		txtResponsable.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtIdentificacion.setForeground(SystemColor.textInactiveText);
		txtIdentificacion.setColumns(10);
		txtIdentificacion.setBackground(UIManager.getColor("Button.background"));
		txtIdentificacion.setBounds(374, 126, 117, 20);
		panel.add(txtIdentificacion);
		
		JComboBox<?> comboxCentroCostos = new JComboBox();
		comboxCentroCostos.setBackground(SystemColor.controlHighlight);
		comboxCentroCostos.setForeground(SystemColor.textInactiveText);
		comboxCentroCostos.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		comboxCentroCostos.setModel(new DefaultComboBoxModel(new String[] {"", "Central", "Suroeste", "Norte", "Noroeste"}));
		comboxCentroCostos.setBounds(374, 163, 117, 20);
		panel.add(comboxCentroCostos);
		
		txtRubro = new JTextField();
		txtRubro.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtRubro.setBounds(374, 196, 117, 20);
		panel.add(txtRubro);
		txtRubro.setForeground(SystemColor.textInactiveText);
		txtRubro.setColumns(10);
		txtRubro.setBackground(UIManager.getColor("Button.background"));
		
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
		comboxMedida.setModel(new DefaultComboBoxModel(new String[] {"", "M", "Cm", "kg", "g"}));
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
				
				String responsible = txtResponsable.getText();
				int identificationCard = Integer.parseInt(txtIdentificacion.getText());
				String costCenter = comboxCentroCostos.getSelectedItem().toString();
				int budget = Integer.parseInt(txtRubro.getText());
				float total = 0;
				
				for (Items nuevoItem : items) {
					total = nuevoItem.getTotalValue() + total;
				}
				
				SolicitudCompra solicitud1 = new SolicitudCompra(responsible, identificationCard, costCenter, budget, items, total);
				String id = solicitud1.getId();
				for (Items items : solicitud1.getItems()) {
					items.setIdentificador(id);
				}
				
				int selecc = JOptionPane.showConfirmDialog(lblFondo, solicitud1);
				if (JOptionPane.YES_OPTION == selecc) {
					
					try {
						Connection conexion = conectar.conectarBase();	
						for (Items items : solicitud1.getItems()) {
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
						
						PreparedStatement insertar = conexion.prepareStatement("insert into solicitudcompras values(?,?,?,?,?,?,?,?)");
						insertar.setString(1, solicitud1.getId().trim());
						insertar.setString(2, solicitud1.getDate().toString());
						insertar.setString(3, solicitud1.getResponsible().trim());
						insertar.setInt(4, solicitud1.getIdentificationCard());
						insertar.setString(5, solicitud1.getCostCenter());
						insertar.setInt(6, solicitud1.getBudget());
						insertar.setString(7, id);
						insertar.setFloat(8, solicitud1.getTotal());
						insertar.executeUpdate();

						conectar.cerrarBase();
						
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, e2);
					}
					
					txtResponsable.setText("");
					txtIdentificacion.setText("");
					txtRubro.setText("");
					comboxCentroCostos.setSelectedItem("");
					dispose();
				}
				
			}
		});
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1.png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
		
		
		
		
				
				
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
