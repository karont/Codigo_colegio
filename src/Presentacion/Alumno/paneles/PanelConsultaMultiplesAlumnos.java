/**
 * 
 */
package presentacion.Alumnos.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import negocio.Alumnos.transfer.TransferAlumno;
import negocio.excepciones.BSoDException;
import net.miginfocom.layout.LC;
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
public class PanelConsultaMultipleAlumnos extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JList<TransferAlumno> list;
	
	private JPanel contentPane;
	
	public PanelConsultaMultipleAlumnos() {
		
		contentPane = this;
		
		setLayout(new BorderLayout(0, 0));

		list = new JList<TransferAlumno>();
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMinimumSize(new Dimension(15, 14));
		add(panel, BorderLayout.SOUTH);
		
		LC layoutconstraits = new LC();
		layoutconstraits.fillX();
		
		panel.setLayout(new MigLayout("fillx", "[208.00,right]", "[]"));
		
		JButton btnNewButton = new JButton("Consultar Alumnos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_ALUMNO, null);
			}
		});
		panel.add(btnNewButton, "cell 0 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDni = new JLabel("DNI");
		panel_1.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel_1.add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("Direcci�n");
		panel_1.add(lblDireccin);
		
		JLabel lblTelefono = new JLabel("Telefono");
		panel_1.add(lblTelefono);
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazAlumnos#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_TODOS_ALUMNO == idEvento ) {
			
			if ( datos instanceof List) {
				
				@SuppressWarnings("unchecked")
				List<TransferAlumno> listaAlumnos = (List<TransferAlumno>) datos;
				
				TransferAlumno[] Alumnos = new TransferAlumno[listaAlumnos.size()];
				listaAlumnos.toArray(Alumnos);
				
				list.setListData(Alumnos);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se pudieron recuperar los Alumnos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_TODOS_ALUMNO == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error gen�rico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}