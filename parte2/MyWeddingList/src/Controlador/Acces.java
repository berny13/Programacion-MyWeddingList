package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.User;
import Modelo.Principal;
import Vista.Bienvenida;
import Vista.Fondo;
import Vista.ListaInvitados;
import Vista.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Acces extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acces frame = new Acces();
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
	public Acces() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acces.class.getResource("/Vista/nuevosanillos.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblUsuario.setForeground(new Color(25, 25, 112));
		lblUsuario.setBounds(100, 87, 88, 24);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblContrasea.setForeground(new Color(25, 25, 112));
		lblContrasea.setBounds(77, 146, 111, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 144, 145, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(198, 90, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login tbl = new Login();
				 User usr = new User();
				 
				 Date date = new Date();
				 DateFormat fechahora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 
				 
				 
				 String pass = new String(passwordField.getPassword());
				 if (!textField.getText().equals("") && !pass.equals("") ) {
					 String nuevoPass = hash.sha1(pass);
					 
					 usr.setNombre(textField.getText());
					 usr.setContraseña(nuevoPass);
					 usr.setUltimaconexion(fechahora.format(date));
					 
					if (tbl.login(usr)) {
						ListaInvitados atras1 = new ListaInvitados();
						atras1.setVisible(true);
						setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(null, "Usuario no reconocido");

					}
					
				 } else {
					 
					 JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");

				}	 
				 	 
			}
		});
		btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnAcceder.setForeground(new Color(25, 25, 112));
		btnAcceder.setBounds(239, 207, 89, 23);
		contentPane.add(btnAcceder);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenida atras1 = new Bienvenida();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegresar.setForeground(new Color(25, 25, 112));
		btnRegresar.setBounds(10, 29, 118, 23);
		contentPane.add(btnRegresar);
	}
}
