/**
 * 
 */
package presentacion.Alumnos.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.Alumnos.transfer.TransferAlumno;
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelModificacionAlumnos extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	private JTextField textDNIBusqueda;
	private JTextField textNombre;
	private JTextField textSegundoApellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private Integer idAlumno;
	private JTextField textPrimerApellido;
	
	private JPanel contentPane;
	
	public PanelModificacionAlumnos() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][][60.00,grow][][36.00][][grow][]", "[][][][][18.00][17.00][][10.00][][9.00][][16.00][13.00][]"));
		
		JLabel lblModificacinDeAlumnos = new JLabel("Modificación de Alumnos");
		add(lblModificacinDeAlumnos, "cell 0 0 7 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 6 1, growx, aligny center");
		
		JLabel label = new JLabel("DNI: ");
		add(label, "cell 1 3,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		textDNIBusqueda.setColumns(10);
		add(textDNIBusqueda, "cell 2 3 2 1,growx");
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textDNIBusqueda.setEditable(false);
				
				String dniAlumno = textDNIBusqueda.getText();
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_ALUMNO_V_MODIFICAR, dniAlumno);
			}
		});
		add(buttonBuscar, "cell 5 3");
		
		JButton btnNuevaBsqueda = new JButton("Nueva búsqueda");
		btnNuevaBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				idAlumno = null;
				textDNIBusqueda.setText("");
				textDNIBusqueda.setEditable(true);
				textNombre.setText("");
				textNombre.setEditable(false);
				textPrimerApellido.setText("");
				textPrimerApellido.setEditable(false);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(false);
				textDireccion.setText("");
				textDireccion.setEditable(false);
				textTelefono.setText("");
				textTelefono.setEditable(false);
			}
		});
		add(btnNuevaBsqueda, "cell 6 3");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 6 1, growx, aligny center");
		
		JLabel label_1 = new JLabel("Nombre: ");
		add(label_1, "cell 1 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		add(textNombre, "cell 2 6 2 1,growx");
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 5 6,alignx trailing");
		
		textPrimerApellido = new JTextField();
		textPrimerApellido.setEditable(false);
		add(textPrimerApellido, "cell 6 6,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel label_3 = new JLabel("Dirección: ");
		add(label_3, "cell 1 8,alignx trailing");
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		add(textDireccion, "cell 2 8 2 1,growx");
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido: ");
		add(lblSegundoApellido, "cell 5 8,alignx trailing");
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setToolTipText("Más de dos apellidos serán ingonrados.");
		textSegundoApellido.setEditable(false);
		textSegundoApellido.setColumns(10);
		add(textSegundoApellido, "cell 6 8,growx");
		
		JLabel label_4 = new JLabel("Telefono: ");
		add(label_4, "cell 5 10,alignx trailing");
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		add(textTelefono, "cell 6 10,growx");
		
		JButton btnModificarAlumno = new JButton("Modificar Alumno");
		btnModificarAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textDNIBusqueda.setEditable(false);
				
				TransferAlumno Alumno = new TransferAlumno();
				
				if ( idAlumno != null 
						&& !textDNIBusqueda.getText().equals("")
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& !textDireccion.getText().equals("")
						&& !textTelefono.getText().equals("")) {
					
					Alumno.setDNI(textDNIBusqueda.getText());
					Alumno.setNombre(textNombre.getText());
					Alumno.setDireccion(textDireccion.getText());
					
					if ( textPrimerApellido.getText().equals("") ) {
						JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Alumno.setPrimerApellido(textPrimerApellido.getText().trim());
						if ( !textSegundoApellido.getText().equals("") )
							Alumno.setSegundoApellido(textSegundoApellido.getText().trim());
						
						
						try {
							Alumno.setNumTelefono( Integer.valueOf(textTelefono.getText()) );
						}
						catch(NumberFormatException nu) {
							JOptionPane.showMessageDialog(contentPane, "El teléfono contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_Alumno, Alumno);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 12 7 1,growx,aligny center");
		add(btnModificarAlumno, "cell 6 13");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazAlumnos#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_MODIFICAR_ALUMNO == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textDNIBusqueda.setText("");
					textDNIBusqueda.setEditable(true);
					textNombre.setText("");
					textNombre.setEditable(true);
					textPrimerApellido.setText("");
					textPrimerApellido.setEditable(true);
					textSegundoApellido.setText("");
					textSegundoApellido.setEditable(true);
					textDireccion.setText("");
					textDireccion.setEditable(true);
					textTelefono.setText("");
					textTelefono.setEditable(true);
					
					JOptionPane.showMessageDialog(contentPane, "El Alumno se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "El Alumno no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				idAlumno = null;
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_ALUMNO_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof TransferAlumno) {
				
				TransferAlumno Alumno = (TransferAlumno) datos;
				
					
				idAlumno = Alumno.getID();
				textNombre.setText(Alumno.getNombre());
				textNombre.setEditable(true);
				textPrimerApellido.setText(Alumno.getPrimerApellido());
				textPrimerApellido.setEditable(true);
				textSegundoApellido.setText(Alumno.getSegundoApellido());
				textSegundoApellido.setEditable(true);
				textDireccion.setText(Alumno.getDireccion());
				textDireccion.setEditable(true);
				textTelefono.setText( String.valueOf(Alumno.getNumTelefono()) );
				textTelefono.setEditable(true);
			}
		}
		else if ( IDEventos.ERROR_MODIFICAR_ALUMNO == idEvento || IDEventos.ERROR_CONSULTAR_ALUMNO_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}