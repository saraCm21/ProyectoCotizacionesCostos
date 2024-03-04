package Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		this.setLocationRelativeTo(null);
		this.setTitle("Costos Y Suministros");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 795, 464);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(126, 49, 523, 326);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JPanel panelSolicitudes = new JPanel();
		panelSolicitudes.setBounds(346, 85, 119, 25);
		panel.add(panelSolicitudes);
		panelSolicitudes.setLayout(null);
		
		JMenuBar menuBarSolicitudes = new JMenuBar();
		menuBarSolicitudes.setBounds(0, 0, 119, 25);
		panelSolicitudes.add(menuBarSolicitudes);
		
		JMenu menuSolicitudes = new JMenu("Solicitudes                ");
		menuBarSolicitudes.add(menuSolicitudes);
		
		JMenuItem menuItemSC = new JMenuItem("Solicitud de Compra");
		menuSolicitudes.add(menuItemSC);
		
		JMenuItem menuItmemOC = new JMenuItem("Orden Contractual");
		menuSolicitudes.add(menuItmemOC);
		
		JMenuItem menuItemSE = new JMenuItem("Solicitud de Entrda");
		menuSolicitudes.add(menuItemSE);
		
		JMenuItem menuItemSS = new JMenuItem("Solicitud de Salida");
		menuSolicitudes.add(menuItemSS);
		
		
		JPanel panelEstados = new JPanel();
		panelEstados.setLayout(null);
		panelEstados.setBounds(346, 157, 119, 25);
		panel.add(panelEstados);
		
		JMenuBar menuBarEstados = new JMenuBar();
		menuBarEstados.setBounds(0, 0, 119, 25);
		panelEstados.add(menuBarEstados);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuBarEstados.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Estados                      ");
		menuBarEstados.add(mnNewMenu_1);
		
		JMenuItem mntmInventario = new JMenuItem("Solicitudes de compra");
		mntmInventario.setSelected(true);
		mnNewMenu_1.add(mntmInventario);
		
		JMenuItem menuItemSC_1 = new JMenuItem("Solicitud de Compra");
		menuBarEstados.add(menuItemSC_1);
		
		
		JPanel panelInventario = new JPanel();
		panelInventario.setLayout(null);
		panelInventario.setBounds(346, 222, 119, 25);
		panel.add(panelInventario);
		
		JMenuBar menuBarInventario = new JMenuBar();
		menuBarInventario.setBounds(0, 0, 119, 25);
		panelInventario.add(menuBarInventario);
		
		JMenu mnNewMenu_2 = new JMenu("Inventario                  ");
		menuBarInventario.add(mnNewMenu_2);
		
		JMenuItem menuItemInventario = new JMenuItem("Inventario                  ");
		mnNewMenu_2.add(menuItemInventario);
		
		JMenuItem menuItemInventarioSC = new JMenuItem("Solicitudes de compra");
		mnNewMenu_2.add(menuItemInventarioSC);
		
		JMenuItem MenuItemOC = new JMenuItem("Ordenes Contractuales");
		mnNewMenu_2.add(MenuItemOC);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Solicitudes de entrada");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Solicitudes de salida");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		textField = new JTextField();
		textField.setBounds(308, 300, 171, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(486, 298, 33, 24);
		panel.add(btnNewButton);
		
		JLabel lblFondoMenu = new JLabel("");
		lblFondoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\image 1 (5).png"));
		lblFondoMenu.setBounds(0, 0, 523, 326);
		panel.add(lblFondoMenu);
		
		JMenuItem menuItem_1 = new JMenuItem("New menu item");
		menuItem_1.setBounds(314, 263, 137, 26);
		panel.add(menuItem_1);
		
		menuItemSC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolicitudCompra_I sc = new SolicitudCompra_I();
				sc.setVisible(true);
			}
		});
		
		menuItmemOC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrdenContractual_I oc = new OrdenContractual_I();
				oc.setVisible(true);
			}
		});
		
		menuItemSE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolicitudEntrada_I se = new SolicitudEntrada_I();
				se.setVisible(true);
			}
		});
		
		menuItemSS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolicitudSalida_I ss = new SolicitudSalida_I();
				ss.setVisible(true);
			}
		});		
		
		menuItemInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventario_i i = new inventario_i();
				i.setVisible(true);
			}
		});
		
		menuItemInventarioSC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showSC_I i_sc = new showSC_I();
				i_sc.setVisible(true);
			}
		});
		
		MenuItemOC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showOC_I i_oc = new showOC_I();	
				i_oc.setVisible(true);
			}
		});
	}
}
