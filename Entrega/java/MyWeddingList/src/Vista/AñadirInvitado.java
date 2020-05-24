package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.User;
import Controlador.Login;
import Modelo.TablaInvitados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AñadirInvitado extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static Object comboBox_1;
	private User usuario;

	public AñadirInvitado() {
		this(new User());
	}
	public AñadirInvitado(User usuario) {
		this.usuario = usuario;
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setToolTipText(" TIPO DE DIETA");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00D1ADIR INVITADO");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(137, 11, 202, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnRegresar = new JButton("REGRESAR");
		
		btnRegresar.setForeground(new Color(25, 25, 112));
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnRegresar.setBounds(10, 15, 89, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblNombreYApellido = new JLabel("NOMBRE Y APELLIDO");
		lblNombreYApellido.setForeground(new Color(25, 25, 112));
		lblNombreYApellido.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblNombreYApellido.setBounds(24, 64, 142, 20);
		contentPane.add(lblNombreYApellido);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setForeground(new Color(25, 25, 112));
		textField.setBounds(172, 58, 202, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDieta = new JLabel("DIETA");
		lblDieta.setFont(new Font("Arial Black", Font.PLAIN, 9));
		lblDieta.setForeground(new Color(25, 25, 112));
		lblDieta.setBounds(69, 95, 79, 14);
		contentPane.add(lblDieta);
		
		JLabel lblAutobus = new JLabel("AUTOBUS");
		lblAutobus.setFont(new Font("Arial Black", Font.PLAIN, 9));
		lblAutobus.setForeground(new Color(25, 25, 112));
		lblAutobus.setBounds(57, 141, 109, 14);
		contentPane.add(lblAutobus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 10));
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "SI", "NO"}));
		comboBox.setBounds(172, 136, 202, 19);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setFont(new Font("Arial Black", Font.PLAIN, 10));
		comboBox_1.setForeground(new Color(25, 25, 112));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"TIPO DE DIETA", "NO DIETA", "INTOLERANTE LACTOSA", "INTOLERANTE GLUTEN", "VEGANO", "VEGETARIANO", "OTRO"}));
		comboBox_1.setBounds(172, 95, 202, 20);
		contentPane.add(comboBox_1);
		
		
		JButton btnAadir = new JButton("A\u00D1ADIR");
		
		btnAadir.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnAadir.setForeground(new Color(25, 25, 112));
		btnAadir.setBounds(335, 227, 89, 23);
		contentPane.add(btnAadir);
		
		JLabel lblTipoDeInvitado = new JLabel("TIPO_DE _INVITADO");
		lblTipoDeInvitado.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblTipoDeInvitado.setForeground(new Color(25, 25, 112));
		lblTipoDeInvitado.setBounds(24, 183, 121, 14);
		contentPane.add(lblTipoDeInvitado);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial Black", Font.PLAIN, 10));
		comboBox_2.setForeground(new Color(25, 25, 112));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "FAMILIAR NOVIA", "FAMILIAR NOVIO", "AMIGO DE LA NOVIA", "AMIGO DEL NOVIO", "COMPA\u00D1ERO DE TRABAJO NOVIA", "COMPA\u00D1ERO DE TRABAJO NOVIO", "COMPA\u00D1ERO DE CLASES NOVIA", "COMPA\u00D1ERO CLASES NOVIO"}));
		comboBox_2.setBounds(172, 180, 202, 20);
		contentPane.add(comboBox_2);
		
		//ACCIONES
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					ListaInvitados atras1 = new ListaInvitados();
					atras1.setVisible(true);
					setVisible(false);
			}
		});
		
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login tbl = new Login();
				User usr = new User();
				
				
				
				String nomb = new String(textField.getText());
				String autb = new String((String) comboBox.getSelectedItem());
				String diet = new String((String) comboBox_1.getSelectedItem());
				String tipinv = new String((String) comboBox_2.getSelectedItem());
				
				if (textField.getText().equals("") || textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay espacios vacios, debe rellenar todos los espacios");
				} else {	
					usr.setNombre(textField.getText());
					usr.setAutobus((String) comboBox.getSelectedItem());
					usr.setDieta((String) comboBox_1.getSelectedItem());
					usr.setTipo_invitado((String) comboBox_2.getSelectedItem());
					if  (tbl.registrarInvitado(usr) == true) {
						JOptionPane.showMessageDialog(null, "Invitado Creado");	
						limpiar();
						TablaInvitados atras1 = new TablaInvitados();
						atras1.setVisible(true);
						setVisible(false);
						
						String recuerda3 = textField.getText();
						new Controlador.Login().EscribirRecordarNovio(recuerda3);
				} else {
                    JOptionPane.showMessageDialog(null, "Este invitado ya existe");
				}
					
							
			}	
				
				
		}	
			
		private void limpiar() {
				textField.setText("");
					
			}	
			
		});
			}
}
		