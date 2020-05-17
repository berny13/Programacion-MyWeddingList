package Modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.LoginNovios;
import Vista.Bienvenida;
import Vista.Fondo;

import java.awt.GridLayout;
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
	private JTextField textField;

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
		btnNewButton.setBounds(300, 187, 89, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NOVIA");		
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(172, 187, 89, 31);
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
		lblIndicanosTuNombre.setBounds(10, 153, 157, 14);
		contentPane.add(lblIndicanosTuNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 10));
		textField.setForeground(new Color(25, 25, 112));
		textField.setBounds(20, 178, 112, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Bienvenida atras3 = new Bienvenida();
					atras3.setVisible(true);
					setVisible(false);
		
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
