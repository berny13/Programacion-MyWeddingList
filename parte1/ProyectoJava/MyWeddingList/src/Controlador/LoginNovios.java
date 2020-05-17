package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.User;
import Vista.Bienvenida;
import Vista.Fondo;
import Vista.ListaInvitados;
import Vista.Login;
import Vista.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class LoginNovios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

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
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegresar.setForeground(new Color(25, 25, 112));
		contentPane.add(btnRegresar);
		
		JLabel lblNombreDeUsuario = new JLabel("NOMBRE  DE USUARIO");
		lblNombreDeUsuario.setBounds(20, 80, 145, 14);
		lblNombreDeUsuario.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblNombreDeUsuario.setForeground(new Color(25, 25, 112));
		contentPane.add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setBounds(173, 77, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(10, 157, 120, 14);
		lblContrasea.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblContrasea.setForeground(new Color(25, 25, 112));
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 154, 200, 19);
		contentPane.add(passwordField);
		
		JButton btnCrear = new JButton("CREAR");		
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnCrear.setForeground(new Color(25, 25, 112));
		btnCrear.setBounds(313, 227, 89, 23);
		contentPane.add(btnCrear);
		
		JLabel lblConfirmarContrasea = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		lblConfirmarContrasea.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblConfirmarContrasea.setForeground(new Color(25, 25, 112));
		lblConfirmarContrasea.setBounds(0, 199, 155, 14);
		contentPane.add(lblConfirmarContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(173, 196, 200, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblEmil = new JLabel("EM@IL");
		lblEmil.setForeground(new Color(25, 25, 112));
		lblEmil.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblEmil.setBounds(46, 123, 70, 14);
		contentPane.add(lblEmil);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 120, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		//ACCIONES
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Login tbl = new Login();
				User usr = new User();
				
				
				
				String pass = new String(passwordField.getPassword());
				String passCon = new String(passwordField_1.getPassword());				
				if (textField.getText().equals("") || textField_1.getText().equals("") || passCon.equals("") || pass.equals("")  ) {
					JOptionPane.showMessageDialog(null, "Hay espacios vacios, debe rellenar todos los espacios");
				} else {	
					
				if (pass.equals(passCon)) {
					
					if  (tbl.existeUsuario(getName()) == 0) {
						
						if (tbl.esEmail(textField_1.getText())) {
							
					String nuevoPass = hash.sha1(pass);					
					usr.setNombre(textField.getText());
					usr.setContraseña(nuevoPass);
					usr.setCorreo(textField_1.getText());
					usr.setIdinvitado(1);					
					if (tbl.registrar(usr)) {					
						JOptionPane.showMessageDialog(null, "Usuario Creado");
						
						limpiar();
						
						ListaInvitados atras1 = new ListaInvitados();
						atras1.setVisible(true);
						setVisible(false);
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Error al guardar los datos");					
					}
					
					} else {
                        JOptionPane.showMessageDialog(null, "El email es invalido");
                    }
				} else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
				}
					
				} else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");				
				}			
			}			
		}			
			private void limpiar() {
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				textField_1.setText("");	
			}
		});
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenida atras1 = new Bienvenida();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
	}
}
