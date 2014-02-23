/**
 * 
 */
package Presentacion.Grupo.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;



import negocio.Grupo.objetodenegocio.Grupo;

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
public class PanelAltaGrupo extends JPanel implements GuiPanelesInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see GuiPanelesInterfaz#actualizarVentana()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCurso;
	private JTextField textLetra;

	
	private JPanel contentPane;
	
	public PanelAltaGrupo(){

			
			contentPane = this;
			
			setPreferredSize(new Dimension(600, 400));
			setMinimumSize(new Dimension(100, 100));
			setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
			
			JLabel lblAltaClientes = new JLabel("Alta Grupo");
			lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(lblAltaClientes, "cell 0 0 9 1,alignx center,aligny top");
			
			JSeparator separator = new JSeparator();
			add(separator, "cell 0 1 9 1,growx,aligny center");
			
			JLabel lblCruso = new JLabel("Curso: ");
			add(lblCruso, "cell 0 3,alignx right,aligny center");
			
			textCurso = new JTextField();
			add(textCurso, "cell 2 3,growx");
			textCurso.setColumns(10);
			
			JLabel lblLetra = new JLabel("Letra: ");
			add(lblLetra, "cell 5 3,alignx trailing");
			
			textLetra = new JTextField();
			add(textLetra, "cell 6 3 3 1,growx");
			textLetra.setColumns(10);
			
			
			
			JSeparator separator_1 = new JSeparator();
			add(separator_1, "cell 0 10 8 1,growx,aligny center");
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Grupo grupo = new Grupo();
					
					if ( !textLetra.getText().equals("") 
							&& !textCurso.getText().equals("")) {
						
						grupo.setCurso(Integer.valueOf(textCurso.getText()));
						grupo.setLetra(textLetra.getText().charAt(0));
						
						
						
						ControladorDeAplicacion.getInstance().handleRequest(IdEventos.EVENTO_ALTA_GRUPO, grupo);
					}
					
					else {
						JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			add(btnAceptar, "cell 7 11,alignx left,aligny top");
	}

	
	public void actualizarVentana(IdEventos idEvento, Object datos) {
		if (IdEventos.EVENTO_ALTA_GRUPO == idEvento){
			
			if ( datos instanceof Grupo ) {
				
				JOptionPane.showMessageDialog(contentPane, "Grupo creado correctamente"+" Su id es:"+((Grupo)datos).getID(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
	
				textLetra.setText("");
				textCurso.setText("");
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al dar de alta un Grupo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if ( IdEventos.ERROR_ALTA_GRUPO == idEvento ) {
			
			if ( datos instanceof ColegioExceptions ) {
				
				JOptionPane.showMessageDialog(contentPane, ((ColegioExceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
		
	}
}