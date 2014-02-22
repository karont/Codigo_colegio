/**
 * 
 */
package negocio.factoria.implementacion;

import negocio.Alumno.serviciodeaplicacion.implementacion.SAAlumnoImp;
import negocio.Alumno.serviciodeaplicacion.interfaz.SAAlumno;
import negocio.Asignatura.serviciodeaplicacion.implementacion.SAAsignaturaImp;
import negocio.Asignatura.serviciodeaplicacion.interfaz.SAAsignatura;
import negocio.Grupo.serviciodeaplicacion.implementacion.SAGrupoImp;
import negocio.Grupo.serviciodeaplicacion.interfaz.SAGrupo;
import negocio.factoria.Singleton.FactorySA;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class FactorySAimp extends FactorySA {

	
	public SAGrupo getSAgrupo() {
		
		return new SAGrupoImp();
	}


	public SAAlumno getSAalumno() {
	
		return new SAAlumnoImp();
	}

	
	public SAAsignatura getSAasignatura() {
		return new SAAsignaturaImp();
	}
}