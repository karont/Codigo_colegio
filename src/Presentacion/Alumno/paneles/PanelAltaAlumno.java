/**
 * 
 */
package Presentacion.Alumno.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.Alumno.objetodenegocio.Alumno;
import negocio.Alumno.objetodenegocio.AlumnoNoBecado;
import negocio.Alumno.objetodenegocio.Alumno.TipoAlumno;
import negocio.Alumno.objetodenegocio.AlumnoBecado;
import negocio.exceptions.ColegioExceptions;

import net.miginfocom.swing.MigLayout;


import Presentacion.Comandos.IdEventos;
import Presentacion.Controladores.controladordeaplicacion.Singleton.ControladorDeAplicacion;
import Presentacion.Ventanaprincipal.Interfazpaneles.GuiPanelesInterfaz;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class PanelAltaAlumno extends JPanel implements GuiPanelesInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see GuiPanelesInterfaz#actualizarVentana()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textSegundoApellido;
	private JTextField textDNI;
	private JTextField textPrimerApellido;
	
	private JPanel contentPane;
	
	private JComboBox<TipoAlumno> cbTipo;
	private JComboBox<Alumno> cbDepartamento;
	
	private JLabel lblbeca;
	private JTextField textBeca;

	/**
	 * Create the panel.
	 */
	public PanelAltaAlumno() {
		
		contentPane = this;
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][161.00px,grow][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
		
		JLabel lblAltaAlumno = new JLabel("Alta Alumnos");
		lblAltaAlumno.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaAlumno, "cell 0 0 7 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 0 3,alignx right,aligny center");
		
		textDNI = new JTextField();
		add(textDNI, "cell 1 3,growx");
		textDNI.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 3 3,alignx trailing");
		
		textPrimerApellido = new JTextField();
		add(textPrimerApellido, "cell 4 3 2 1,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 5,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 1 5,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo apellido: ");
		add(lblApellido2, "cell 3 5,alignx left,aligny center");
		
		textSegundoApellido = new JTextField();
		add(textSegundoApellido, "cell 4 5 2 1,growx,aligny top");
		textSegundoApellido.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Tipo: ");
		add(lblDireccin, "cell 0 7,alignx right,aligny center");
		
		textBeca = new JTextField();
		textBeca.setVisible(true);
		add(textBeca, "cell 1 8,growx");
		textBeca.setColumns(10);
		
		cbTipo = new JComboBox<TipoAlumno>();	
		cbTipo.setModel(new DefaultComboBoxModel<TipoAlumno>(TipoAlumno.values()));
		cbTipo.setSelectedIndex(-1);
		add(cbTipo, "cell 1 7,growx");
		
		cbTipo.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {

			if (cbTipo.getSelectedIndex() > -1) {
			    
			    if( cbTipo.getSelectedItem().equals(TipoAlumno.NOBECADO)) {
				
				//lblbeca.setVisible(false);
				//textBeca.setVisible(false);
			    }
			    else if (cbTipo.getSelectedItem().equals(TipoAlumno.BECADO)) {
			    	System.out.println("HOLa");
				//lblbeca.setVisible(true);
				//textBeca.setVisible(true);
			    }
			}
		    }
		});
	
		

		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 10 6 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Alumno alumno = null;
				
				if ( !textDNI.getText().equals("") 
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& cbTipo.getSelectedIndex() > -1) {

					if ( cbTipo.getSelectedItem().equals(TipoAlumno.BECADO)) {

					    if ( !textBeca.getText().trim().equals("")) {
					    	alumno = new AlumnoBecado();
					
	
							   
						    alumno.setDNI(textDNI.getText());
						    alumno.setNombre(textNombre.getText());
						    alumno.setTipoAlumno( (TipoAlumno)cbTipo.getSelectedItem());
						    ((AlumnoBecado)alumno).setTipobeca(textBeca.getText());
							alumno.setPrimerApellido(textPrimerApellido.getText().trim());
							alumno.setSegundoApellido(textSegundoApellido.getText().trim());
				
							ControladorDeAplicacion.getInstance().handleRequest(IdEventos.EVENTO_ALTA_ALUMNO, alumno);
								    
						   
						
					    }
					  
					}
					else if (cbTipo.getSelectedItem().equals(TipoAlumno.NOBECADO)){
					    					
						alumno = new AlumnoNoBecado();
						
					    alumno.setDNI(textDNI.getText());
					    alumno.setNombre(textNombre.getText());
					    alumno.setTipoAlumno( (TipoAlumno)cbTipo.getSelectedItem());
						alumno.setPrimerApellido(textPrimerApellido.getText().trim());
						alumno.setSegundoApellido(textSegundoApellido.getText().trim());
			
						ControladorDeAplicacion.getInstance().handleRequest(IdEventos.EVENTO_ALTA_ALUMNO, alumno);
						
					    }
					  
					}
				
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}


		});
		add(btnAceptar, "cell 5 11,alignx left,aligny top");
	}
	public void actualizarVentana(IdEventos idEvento, Object datos) {
		
		if(IdEventos.EVENTO_ALTA_ALUMNO == idEvento){
			
			if(datos instanceof Alumno){
				JOptionPane.showMessageDialog(contentPane, "Alumno creado correctamente. Su id es : "+((Alumno)datos).getID(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
				textDNI.setText("");
				textPrimerApellido.setText("");
				textSegundoApellido.setText("");
				textNombre.setText("");
				textBeca.setText("");
				cbTipo.setSelectedIndex(-1);
			}
		}
		
		else if (IdEventos.ERROR_ALTA_ALUMNO == idEvento){
			if(datos instanceof ColegioExceptions){
				JOptionPane.showMessageDialog(contentPane, ((ColegioExceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}