/**
 * 
 */
package Presentacion.Grupo.imp;

import Presentacion.Comandos.IdEventos;
import Presentacion.Grupo.singleton.GUIGrupo;
import Presentacion.Grupo.paneles.PanelAltaGrupo;
import Presentacion.Grupo.paneles.PanelConsultaGrupo;
import Presentacion.Grupo.paneles.PanelBajaGrupo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIGrupoImp extends GUIGrupo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelAltaGrupo panelAltaGrupo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelConsultaGrupo panelConsultaGrupo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelBajaGrupo panelBajaGrupo;

	public PanelBajaGrupo getPanelBajaGrupo() {
		if (panelBajaGrupo == null){
			panelBajaGrupo = new PanelBajaGrupo();
		}
		return panelBajaGrupo;
	}
	
	public PanelConsultaGrupo getPanelConsultaGrupo() {
		if (panelConsultaGrupo == null){
			panelConsultaGrupo = new PanelConsultaGrupo();
		}
		return panelConsultaGrupo;
	}

	public void update(IdEventos evento_actual, Object datos) {
		
	
		switch (evento_actual) {
		
		case EVENTO_ALTA_GRUPO:
		case ERROR_ALTA_GRUPO:
			getPanelAltaGrupo().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_BAJA_GRUPO:
		case ERROR_BAJA_GRUPO:
		case EVENTO_CONSULTAR_GRUPO_V_BORRAR:
		case ERROR_CONSULTAR_GRUPO_V_BORRAR:
			getPanelBajaGrupo().actualizarVentana(evento_actual, datos);
			break;
	
		
		case EVENTO_CONSULTAR_GRUPO:
		case ERROR_CONSULTAR_GRUPO:
			getPanelConsultaGrupo().actualizarVentana(evento_actual, datos);
			break;
		

		default:
			break;
		
		}
	}

	public PanelAltaGrupo getPanelAltaGrupo() {
		if (panelAltaGrupo == null){
			panelAltaGrupo = new PanelAltaGrupo();
		}
		return panelAltaGrupo;
	}
}