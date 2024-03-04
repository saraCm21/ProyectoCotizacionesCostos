package baseDeDatos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registro_ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	Conect conectar = Conect.getInstancia();
	private JTextField txt_nombre;
	private JTextField txt_edad;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_ frame = new Registro_();
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
	public Registro_() {
		this.setLocationRelativeTo(null);
		this.setTitle("Base de datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite su nombre");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(26, 36, 111, 26);
		contentPane.add(lblNewLabel);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(168, 39, 195, 26);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		JLabel lblDigiteSuEdad = new JLabel("Digite su edad");
		lblDigiteSuEdad.setForeground(Color.BLACK);
		lblDigiteSuEdad.setBackground(Color.LIGHT_GRAY);
		lblDigiteSuEdad.setBounds(26, 107, 111, 29);
		contentPane.add(lblDigiteSuEdad);
		
		txt_edad = new JTextField();
		txt_edad.setColumns(10);
		txt_edad.setBounds(168, 110, 195, 26);
		contentPane.add(txt_edad);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo");
		lblNewLabel_1.setBounds(26, 193, 57, 26);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Sexo", "Masculino ", "Femenino"}));
		comboBoxSexo.setToolTipText("");
		comboBoxSexo.setBounds(168, 195, 195, 22);
		contentPane.add(comboBoxSexo);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion = conectar.conectarBase();	
					PreparedStatement insertar = conexion.prepareStatement("insert into solicitudCompra values(?,?,?)");
					
					insertar.setString(1, txt_nombre.getText().trim());
					insertar.setString(2, txt_edad.getText().trim());
					insertar.setString(3, comboBoxSexo.getSelectedItem().toString());
					insertar.executeUpdate();
					
					JOptionPane.showConfirmDialog(null, "Datos Registrados");
					conectar.cerrarBase();
					
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, e);
					
				}
				
			}
		});
		btnNewButton.setBounds(98, 284, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_nombre.setText("");
				txt_edad.setText("");
			}
		});
		btnNewButton_1.setBounds(228, 284, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
