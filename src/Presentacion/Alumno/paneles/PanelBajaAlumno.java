/**
 * 
 */
package src.Presentacion.Alumno.paneles;

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
public class PanelBajaAlumnos extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField txtDni;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private Integer idAlumno;
	private JButton btnBorrarAlumno;
	
	private JPanel contentPane;
	
	public PanelBajaAlumnos() {
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][][][][]"));
		
		contentPane = this;
		
		JLabel lblConsultaAlumnos = new JLabel("Baja Alumnos");
		add(lblConsultaAlumnos, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 2 4,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		add(textDNIBusqueda, "cell 3 4,growx");
		textDNIBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniAlumno = textDNIBusqueda.getText();
				
				if ( !"".equals(dniAlumno) ) {
					
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_ALUMNO_V_BORRAR, dniAlumno);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede ser vac�o", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 5 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx,aligny center");
		
		JLabel lblDni_1 = new JLabel("DNI: ");
		add(lblDni_1, "cell 2 6,alignx right");
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		add(txtDni, "cell 3 6,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 5 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 6 6,growx");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 2 8,alignx right");
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		add(textApellidos, "cell 3 8,growx");
		textApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci�n: ");
		add(lblDireccin, "cell 5 8,alignx trailing");
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		add(textDireccion, "cell 6 8,growx");
		textDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		add(lblTelefono, "cell 2 10,alignx trailing");
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		add(textTelefono, "cell 3 10,growx");
		textTelefono.setColumns(10);
		
		btnBorrarAlumno = new JButton("Borrar Alumno");
		btnBorrarAlumno.setEnabled(false);
		btnBorrarAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idAlumno != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_ALUMNO, idAlumno);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al cargar el Alumno, b�squelo otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btnBorrarAlumno, "cell 6 13");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_BAJA_Alumno == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textDNIBusqueda.setText("");
					idAlumno = null;
					txtDni.setText("");
					textNombre.setText("");
					textApellidos.setText("");
					textDireccion.setText("");
					textTelefono.setText("");
					btnBorrarAlumno.setEnabled(false);
					
					JOptionPane.showMessageDialog(contentPane, "El Alumno se ha borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "El Alumno no se ha borrado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_Alumno_V_BORRAR == idEvento ) {
			
			if ( datos instanceof TransferAlumno) {
				
				TransferAlumno Alumno = (TransferAlumno) datos;
				
				idAlumno = Alumno.getID();
				txtDni.setText(Alumno.getDNI());
				textNombre.setText(Alumno.getNombre());
				textApellidos.setText(Alumno.getPrimerApellido() + " " + Alumno.getSegundoApellido());
				textDireccion.setText(Alumno.getDireccion());
				textTelefono.setText( String.valueOf(Alumno.getNumTelefono()) );
				btnBorrarAlumno.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_BAJA_ALUMNO == idEvento || IDEventos.ERROR_CONSULTAR_ALUMNO_V_BORRAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "Error gen�rico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}