package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginNovios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginNovios frame = new LoginNovios();
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
	public LoginNovios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAlRegistro = new JLabel("BIENVENIDO AL REGISTRO DE PAREJAS");
		lblBienvenidoAlRegistro.setBounds(58, 11, 331, 28);
		lblBienvenidoAlRegistro.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblBienvenidoAlRegistro.setForeground(new Color(25, 25, 112));
		contentPane.add(lblBienvenidoAlRegistro);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBounds(10, 46, 103, 23);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login atras4 = new Login();
				atras4.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegresar.setForeground(new Color(25, 25, 112));
		contentPane.add(btnRegresar);
		
		JLabel lblNombreDeUsuario = new JLabel("NOMBRE  DE USUARIO");
		lblNombreDeUsuario.setBounds(29, 103, 145, 14);
		lblNombreDeUsuario.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblNombreDeUsuario.setForeground(new Color(25, 25, 112));
		contentPane.add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setBounds(184, 100, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(38, 150, 120, 14);
		lblContrasea.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblContrasea.setForeground(new Color(25, 25, 112));
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 147, 200, 19);
		contentPane.add(passwordField);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirInvitado atras5 = new AñadirInvitado();
				atras5.setVisible(true);
				setVisible(false);
			}	
		});
		btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnAcceder.setForeground(new Color(25, 25, 112));
		btnAcceder.setBounds(335, 197, 89, 23);
		contentPane.add(btnAcceder);
		
		JButton btnEliminarUsuario = new JButton("ELIMINAR USUARIO");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String nombre = lblNombreDeUsuario.getText();
					String contraseña = lblContrasea.getText();
					new Controlador.Login().deleteUser(nombre, contraseña);
				}
		});
		btnEliminarUsuario.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnEliminarUsuario.setForeground(new Color(25, 25, 112));
		btnEliminarUsuario.setBounds(10, 227, 148, 23);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = lblNombreDeUsuario.getText();
				String contraseña = lblContrasea.getText();
				new Controlador.Login().insertUser(nombre, contraseña);
			
			}
		});
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnCrear.setForeground(new Color(25, 25, 112));
		btnCrear.setBounds(184, 197, 89, 23);
		contentPane.add(btnCrear);
	}
}
