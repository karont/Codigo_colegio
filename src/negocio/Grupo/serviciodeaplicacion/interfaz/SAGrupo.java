/**
 * 
 */
package negocio.Grupo.serviciodeaplicacion.interfaz;

import negocio.Grupo.objetodenegocio.Grupo;
import negocio.exceptions.ColegioExceptions;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public interface SAGrupo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nuevogrupo
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Grupo añadirGrupo(Grupo nuevogrupo) throws ColegioExceptions;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idgrupo
	 * @param borrado
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean borrarGrupo(Grupo grupoaborrar)throws ColegioExceptions;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idgrupo
	 * @param grupo
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Grupo obtenerGrupo(int idgrupo)throws ColegioExceptions;
}