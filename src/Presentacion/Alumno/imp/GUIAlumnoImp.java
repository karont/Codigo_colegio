/**
 * 
 */
package Presentacion.Alumno.imp;

import Presentacion.Alumno.singleton.GUIAlumno;
import Presentacion.Alumno.paneles.PanelConsultaAlumno;
import Presentacion.Alumno.paneles.PanelBajaAlumno;
import Presentacion.Alumno.paneles.PanelAltaAlumno;
import Presentacion.Alumno.paneles.PanelConsultaMultiplesAlumnos;
import Presentacion.Alumno.paneles.PanelModificarAlumno;
import Presentacion.Comandos.IdEventos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIAlumnoImp extends GUIAlumno {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static PanelConsultaAlumno panelConsultaAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static PanelBajaAlumno panelBajaAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static PanelAltaAlumno panelAltaAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static PanelConsultaMultiplesAlumnos panelConsultaMultiplesAlumnos;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static PanelModificarAlumno panelModificarAlumno;
	
	public void update(IdEventos evento_actual, Object datos) {
		
		switch (evento_actual) {
		
			case EVENTO_ALTA_ALUMNO:
			case ERROR_ALTA_ALUMNO:
				getPanelAltaAlumno().actualizarVentana(evento_actual, datos);
				break;
			case EVENTO_BAJA_ALUMNO:
			case ERROR_BAJA_ALUMNO:
			case EVENTO_CONSULTAR_ALUMNO_V_BORRAR:
			case ERROR_CONSULTAR_ALUMNO_V_BORRAR:
				getPanelBajaAlumno().actualizarVentana(evento_actual, datos);
				break;
			case EVENTO_MODIFICAR_ALUMNO:
			case ERROR_MODIFICAR_ALUMNO:
			case EVENTO_CONSULTAR_ALUMNO_V_MODIFICAR:
			case ERROR_CONSULTAR_ALUMNO_V_MODIFICAR:
				getPanelModificarAlumno().actualizarVentana(evento_actual, datos);
				break;
			case EVENTO_CONSULTAR_ALUMNO:
			case ERROR_CONSULTAR_ALUMNO:
				getPanelConsultaAlumno().actualizarVentana(evento_actual, datos);
				break;
			case EVENTO_CONSULTAR_TODOS_ALUMNOS:
			case ERROR_CONSULTAR_TODOS_ALUMNOS:
				getPanelConsultaMultipleAlumnos().actualizarVentana(evento_actual, datos);
				break;
	
			default:
				break;

		}
		
	}

	public PanelAltaAlumno getPanelAltaAlumno() {
		if(panelAltaAlumno == null){
			panelAltaAlumno = new PanelAltaAlumno();
		}
		return panelAltaAlumno;
	}

	public PanelBajaAlumno getPanelBajaAlumno() {
		
		if(panelBajaAlumno == null){
			panelBajaAlumno = new PanelBajaAlumno();
		}
		return panelBajaAlumno;
	}

	public PanelConsultaAlumno getPanelConsultaAlumno() {
		if(panelConsultaAlumno == null){
			panelConsultaAlumno = new PanelConsultaAlumno();
		}
		return panelConsultaAlumno;
	}

	public PanelModificarAlumno getPanelModificarAlumno() {
		if(panelModificarAlumno == null){
			panelModificarAlumno = new PanelModificarAlumno();
		}
		return panelModificarAlumno;
	}

	public PanelConsultaMultiplesAlumnos getPanelConsultaMultipleAlumnos() {
		if(panelConsultaMultiplesAlumnos == null){
			panelConsultaMultiplesAlumnos = new PanelConsultaMultiplesAlumnos();
		}
		return panelConsultaMultiplesAlumnos;
	}
}