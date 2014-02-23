/**
 * 
 */
package negocio.factoria.Singleton;

import negocio.factoria.implementacion.FactorySAimp;
import negocio.Grupo.serviciodeaplicacion.interfaz.SAGrupo;
import negocio.Alumno.serviciodeaplicacion.interfaz.SAAlumno;
import negocio.Asignatura.serviciodeaplicacion.interfaz.SAAsignatura;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class FactorySA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static FactorySA factorysainstance;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public static FactorySA getInstance() {
		if(factorysainstance == null)
			factorysainstance = new FactorySAimp();
		
		return factorysainstance;
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract SAGrupo getSAgrupo();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract SAAlumno getSAalumno();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param saasignatura
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public abstract SAAsignatura getSAasignatura(); 
	}