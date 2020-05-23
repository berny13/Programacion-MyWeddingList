package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import Beans.User;
import Controlador.Acces;
import Controlador.LoginNovios;
import Modelo.Principal;
import javafx.scene.control.TextField;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO  " + Modelo.Principal.textField.getText());
		lblBienvenido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblBienvenido.setForeground(new Color(25, 25, 112));
		lblBienvenido.setBounds(185, 27, 184, 35);
		contentPane.add(lblBienvenido);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");		
		btnRegistrarse.setForeground(new Color(25, 25, 112));
		btnRegistrarse.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegistrarse.setBounds(159, 177, 162, 43);
		contentPane.add(btnRegistrarse);
		
		JButton btnAcceder = new JButton("ACCEDER");		
		btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnAcceder.setForeground(new Color(25, 25, 112));
		btnAcceder.setBounds(159, 114, 162, 43);
		contentPane.add(btnAcceder);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnRegresar.setForeground(new Color(25, 25, 112));
		btnRegresar.setBounds(10, 27, 113, 23);
		contentPane.add(btnRegresar);
		
		
		//acciones
		
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Acces atras1 = new Acces();
				atras1.setVisible(true);
				setVisible(false);
				 
			}
		});
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal atras1 = new Principal();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginNovios atras1 = new LoginNovios();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
	}
}
