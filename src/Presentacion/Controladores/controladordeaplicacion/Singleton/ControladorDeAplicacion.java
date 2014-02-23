/**
 * 
 */
package Presentacion.Controladores.controladordeaplicacion.Singleton;


import Presentacion.Comandos.IdEventos;
import Presentacion.Controladores.controladordeaplicacion.imp.ControladorDeAplicacionImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class ControladorDeAplicacion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static ControladorDeAplicacion controladordeaplicacioninstance;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public static ControladorDeAplicacion getInstance() {
		if (controladordeaplicacioninstance == null){
			controladordeaplicacioninstance = new ControladorDeAplicacionImp();
		}
		return controladordeaplicacioninstance;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract void handleRequest(IdEventos evento, Object datos);
}