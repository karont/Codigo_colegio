/**
 * 
 */
package negocio.Asignatura.serviciodeaplicacion.interfaz;

import negocio.Asignatura.objetodenegocio.Asignatura;
import negocio.exceptions.ColegioExceptions;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public interface SAAsignatura {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nuevaasignatura
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Asignatura añadirAsignatura(Asignatura nuevaasignatura)throws ColegioExceptions;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idAsignatura
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean borrarAsignatura(Asignatura asignaturaaborrar) throws ColegioExceptions;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idasignatura
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Asignatura obtenerAsignatura(int idasignatura) throws ColegioExceptions;
}