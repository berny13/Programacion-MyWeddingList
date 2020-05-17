package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Connection;

import BBDD.conexion;
import Modelo.Principal;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaInvitados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaInvitados frame = new ListaInvitados();
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
	public ListaInvitados() {
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
		
		JLabel lblListaDeInvitados = new JLabel("LISTA DE INVITADOS NOVIO & NOVIA");
		lblListaDeInvitados.setForeground(new Color(25, 25, 112));
		lblListaDeInvitados.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblListaDeInvitados.setBounds(54, 11, 349, 38);
		contentPane.add(lblListaDeInvitados);
		
		JButton btnVerListaCompleta = new JButton("VER LISTA \r\n\r\nCOMPLETA");		
		
		btnVerListaCompleta.setForeground(new Color(25, 25, 112));
		btnVerListaCompleta.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnVerListaCompleta.setBounds(10, 172, 155, 56);
		contentPane.add(btnVerListaCompleta);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR INVITADO");		
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton.setBounds(260, 172, 143, 56);
		contentPane.add(btnNewButton);
		
		JButton btnRegresar = new JButton("REGRESAR");		
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegresar.setForeground(new Color(25, 25, 112));
		btnRegresar.setBounds(0, 60, 99, 23);
		contentPane.add(btnRegresar);
		
		
		//ACCIONES
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Principal atras = new Principal();
					atras.setVisible(true);
					setVisible(false);
				}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirInvitado Inv1 = new AñadirInvitado();
				Inv1.setVisible(true);
				setVisible(false);
			}
		});
		
		btnVerListaCompleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaInvitados atras = new TablaInvitados();
				atras.setVisible(true);
				setVisible(false);
			}
		});
		
		
	}
}
