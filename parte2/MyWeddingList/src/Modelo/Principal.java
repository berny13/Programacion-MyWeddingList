package Modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Table;

import Controlador.LoginNovios;
import Vista.Bienvenida;
import Vista.Fondo;

import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;

	/**
	 * Create the frame.
	 */
	
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Vista/anillo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblControlDeInvitados = new JLabel("CONTROL DE INVITADOS");
		lblControlDeInvitados.setBounds(94, 11, 387, 50);
		lblControlDeInvitados.setForeground(new Color(25, 25, 112));
		lblControlDeInvitados.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblControlDeInvitados.setBackground(new Color(25, 25, 112));
		contentPane.add(lblControlDeInvitados);
		
		JLabel lblIndicanosQuienEres = new JLabel("INDICANOS QUIEN ERES");
		lblIndicanosQuienEres.setForeground(new Color(25, 25, 112));
		lblIndicanosQuienEres.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblIndicanosQuienEres.setBounds(141, 61, 177, 22);
		contentPane.add(lblIndicanosQuienEres);
		
		JButton btnNewButton = new JButton("NOVIO");		
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setBounds(316, 193, 89, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NOVIA");		
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(190, 193, 89, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnTerminosYCondiciones = new JButton("CONT\u00C1CTANOS");
		btnTerminosYCondiciones.setForeground(new Color(25, 25, 112));
		btnTerminosYCondiciones.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnTerminosYCondiciones.setBounds(0, 229, 167, 14);
		contentPane.add(btnTerminosYCondiciones);
		
		JButton btnContactanos = new JButton("TERMINOS Y CONDICIONES");
		btnContactanos.setForeground(new Color(25, 25, 112));
		btnContactanos.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnContactanos.setBounds(0, 247, 167, 14);
		contentPane.add(btnContactanos);
		
		JLabel lblIndicanosTuNombre = new JLabel("INDICANOS TU NOMBRE");
		lblIndicanosTuNombre.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblIndicanosTuNombre.setForeground(new Color(25, 25, 112));
		lblIndicanosTuNombre.setBounds(10, 110, 157, 14);
		contentPane.add(lblIndicanosTuNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setForeground(new Color(25, 25, 112));
		textField.setBounds(20, 135, 112, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIndicanosElNombre = new JLabel("INDICANOS EL NOMBRE DE TU PAREJA");
		lblIndicanosElNombre.setForeground(new Color(25, 25, 112));
		lblIndicanosElNombre.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblIndicanosElNombre.setBounds(0, 172, 251, 14);
		contentPane.add(lblIndicanosElNombre);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField_1.setForeground(new Color(25, 25, 112));
		textField_1.setBounds(20, 198, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		/*ACCIONES*/
		
		btnTerminosYCondiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "C:\\Users\\34644\\eclipse-workspace\\MyWeddingList\\src\\Vista\\AtencionalCliente.html";
				ProcessBuilder p = new ProcessBuilder();
				p.command("cmd.exe", "/c", url);
				try {
					p.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenida atras3 = new Bienvenida();
				atras3.setVisible(true);
				setVisible(false);
				
				String recuerda3 = Vista.AñadirInvitado.textField.getText();
				new Controlador.Login().EscribirRecordarNovio(recuerda3);
				
		
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenida atras3 = new Bienvenida();
				atras3.setVisible(true);
				setVisible(false);
	
				String recuerda4 = Vista.AñadirInvitado.textField.getText();
				new Controlador.Login().EscribirRecordarNovia(recuerda4);
					
			}
		});
		
		/*btnContactanos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScrollCondicion.setVisible(true);
				Condicion.setVisible(true);
				btnTerminosAceptar.setVisible(true);
			}
		});*/
		
		
		
	}
}
