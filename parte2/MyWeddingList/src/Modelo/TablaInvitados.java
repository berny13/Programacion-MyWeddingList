package Modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Connection;

import BBDD.conexion;
import Beans.User;
import Vista.AñadirInvitado;
import Vista.Fondo;
import Vista.ListaInvitados;
import javafx.stage.FileChooser;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class TablaInvitados extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	public TablaInvitados() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo("imagen.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerLista = new JButton("VER LISTA");		
		btnVerLista.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnVerLista.setForeground(new Color(25, 25, 112));
		btnVerLista.setBounds(-2, 87, 89, 23);
		contentPane.add(btnVerLista);
		
		JButton btnNueva = new JButton("NUEVO");		
		btnNueva.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnNueva.setForeground(new Color(25, 25, 112));
		btnNueva.setBounds(0, 121, 89, 23);
		contentPane.add(btnNueva);
		
		JButton btnPdf = new JButton("EXPORTAR");
		btnPdf.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnPdf.setForeground(new Color(25, 25, 112));
		btnPdf.setBounds(-2, 155, 89, 23);
		contentPane.add(btnPdf);
		
		JButton btnEliminar = new JButton("ELIMINAR");		
		btnEliminar.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnEliminar.setForeground(new Color(25, 25, 112));
		btnEliminar.setBounds(-2, 189, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnRegresar = new JButton("REGRESAR");		
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnRegresar.setForeground(new Color(25, 25, 112));
		btnRegresar.setBounds(-2, 44, 89, 23);
		contentPane.add(btnRegresar);
		
		setTable(new JTable());	
		getTable().setFont(new Font("Arial Black", Font.PLAIN, 8));
		getTable().setForeground(new Color(25, 25, 112));
		getTable().setToolTipText("");
		getTable().setBounds(97, 51, 327, 199);
		contentPane.add(getTable());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(398, 218, -318, -170);
		contentPane.add(getTable());
		
		JLabel lblMisInvitados = new JLabel("MIS INVITADOS");
		lblMisInvitados.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMisInvitados.setForeground(new Color(25, 25, 112));
		lblMisInvitados.setBounds(198, 0, 226, 23);
		contentPane.add(lblMisInvitados);
		
		JLabel lblNumero = new JLabel("NUMERO");
		lblNumero.setForeground(new Color(25, 25, 112));
		lblNumero.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNumero.setBounds(97, 34, 66, 14);
		contentPane.add(lblNumero);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNombre.setForeground(new Color(25, 25, 112));
		lblNombre.setBounds(161, 34, 66, 14);
		contentPane.add(lblNombre);
		
		JLabel lblAutobus = new JLabel("AUTOBUS");
		lblAutobus.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblAutobus.setForeground(new Color(25, 25, 112));
		lblAutobus.setBounds(231, 34, 72, 14);
		contentPane.add(lblAutobus);
		
		JLabel lblDieta = new JLabel("DIETA");
		lblDieta.setForeground(new Color(25, 25, 112));
		lblDieta.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblDieta.setBounds(311, 34, 46, 14);
		contentPane.add(lblDieta);
		
		JLabel lblTipoInvitado = new JLabel("TIPO ");
		lblTipoInvitado.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblTipoInvitado.setForeground(new Color(25, 25, 112));
		lblTipoInvitado.setBounds(367, 34, 57, 14);
		contentPane.add(lblTipoInvitado);
	
		
		//ACCIONES
		// este metodo abrira a travez de un boton ver lista la base de datos y lo mostrara en una tabla
		btnVerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				conexion con = new conexion();
				Connection conexion = con.getConexion();
				
				String sql3 = "SELECT * FROM invitado";
				
				java.sql.Statement st;
				
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("idinvitado");
				model.addColumn("nombre");
				model.addColumn("autobus");
				model.addColumn("dieta");
				model.addColumn("tipo_invitado");
				
				getTable().setModel(model);
				
				String[] dato = new String[5];
				
				try {
					st = conexion.createStatement();
					
					ResultSet result = (ResultSet) st.executeQuery(sql3);
					
					while (result.next()) {
						dato[0] = result.getString(1);
						dato[1] = result.getString(2);
						dato[2] = result.getString(3);
						dato[3] = result.getString(4);
						dato[4] = result.getString(5);
						model.addRow(dato);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
	
			}
		});
		// este boton hara que a travez del metodo elimine un invitado seleccionado
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int eli = getTable().getSelectedRow();	
				String idInvitado =	getTable().getModel().getValueAt(eli, 0).toString();
				
				conexion con = new conexion();
				Connection conexion = con.getConexion();
				
				java.sql.Statement st;
	
						st = conexion.createStatement();
						st.executeUpdate("DELETE FROM invitado WHERE idinvitado = "+ idInvitado);
						
						JOptionPane.showMessageDialog(null, "Invitado Eliminado");
						
						TablaInvitados atras1 = new TablaInvitados();
						atras1.setVisible(true);
						setVisible(false);
						
		
				
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Lista vacia o invitado no seleccionado");
					
				}
				
				
		
			}
		});
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaInvitados atras1 = new ListaInvitados();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
		
		// este metodo permitira guardae la tabla en formato .pdf
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton guardarPDF;
				JPanel panel;
				JFileChooser seleccionar_archivo;
				JEditorPane editor;
				
				panel = new JPanel();
				seleccionar_archivo = new JFileChooser();
				editor = new JEditorPane();
				guardarPDF = new JButton();
				
				int opcion = seleccionar_archivo.showSaveDialog(null);
				
				if(opcion == seleccionar_archivo.APPROVE_OPTION) {
					
					try {
						OutputStream texto_salida = new FileOutputStream(seleccionar_archivo.getSelectedFile());
						Document doc = (Document) new DocumentFilter();
					
																																	
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
				
				
				
			}
		});
		
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirInvitado atras1 = new AñadirInvitado();
				atras1.setVisible(true);
				setVisible(false);
			}
		});
		
	
	}

	public static JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	
}
