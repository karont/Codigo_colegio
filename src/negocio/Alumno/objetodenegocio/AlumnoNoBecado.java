/**
 * 
 */
package negocio.Alumno.objetodenegocio;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQuery(name = "negocio.Alumno.objetodenegocio.AlumnoNoBecado.findByid", query = "select obj from AlumnoNoBecado obj where obj.id = :id")
public class AlumnoNoBecado extends Alumno implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public AlumnoNoBecado() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private int id;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	 @Override
	 public String toString() {

	return getDNI() + " " + getNombre() + " " + getPrimerApellido() + " "
			+ getSegundoApellido()+ " "+getTipoAlumno();
	}
}