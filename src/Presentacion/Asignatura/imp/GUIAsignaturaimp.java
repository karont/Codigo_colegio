/**
 * 
 */
package Presentacion.Asignatura.imp;

import Presentacion.Asignatura.singleton.GUIAsignatura;
import Presentacion.Asignatura.paneles.PanelConsultarAsignatura;
import Presentacion.Asignatura.paneles.PanelAltaAsignatura;
import Presentacion.Asignatura.paneles.PanelBajaAsignatura;
import Presentacion.Comandos.IdEventos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIAsignaturaimp extends GUIAsignatura {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelConsultarAsignatura panelConsultarAsignatura;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelAltaAsignatura panelAltaAsignatura;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private PanelBajaAsignatura panelBajaAsignatura;

	public void update(IdEventos evento_actual, Object datos) {
		
		switch (evento_actual) {
		
		case EVENTO_ALTA_ASIGNATURA:
		case ERROR_ALTA_ASIGNATURA:
			getPanelAltaAsignatura().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_BAJA_ASIGNATURA:
		case ERROR_BAJA_ASIGNATURA:
		case EVENTO_CONSULTAR_ASIGNATURA_V_BORRAR:
		case ERROR_CONSULTAR_ASIGNATURA_V_BORRAR:
			getPanelBajaAsignatura().actualizarVentana(evento_actual, datos);
			break;
	
		
		case EVENTO_CONSULTAR_ASIGNATURA:
		case ERROR_CONSULTAR_ASIGNATURA:
			getPanelConsultarAsignatura().actualizarVentana(evento_actual, datos);
			break;
		

		default:
			break;

	}
		
	}

	public PanelBajaAsignatura getPanelBajaAsignatura() {
		if(panelBajaAsignatura == null){
			panelBajaAsignatura = new PanelBajaAsignatura();
		}
		
		return panelBajaAsignatura;
	}

	public PanelAltaAsignatura getPanelAltaAsignatura() {
		if(panelAltaAsignatura == null){
			panelAltaAsignatura = new PanelAltaAsignatura();
		}
		
		return panelAltaAsignatura;
	}

	public PanelConsultarAsignatura getPanelConsultarAsignatura() {
		
		if(panelConsultarAsignatura == null){
			panelConsultarAsignatura = new PanelConsultarAsignatura();
		}
		
		return panelConsultarAsignatura;
	}
}