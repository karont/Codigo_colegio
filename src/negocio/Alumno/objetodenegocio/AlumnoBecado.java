/**
 * 
 */
package negocio.Alumno.objetodenegocio;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.AlumnoBecado.findByid", query = "select obj from AlumnoBecado obj where obj.id = :id"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.AlumnoBecado.findBytipobeca", query = "select obj from AlumnoBecado obj where obj.tipobeca = :tipobeca") })
public class AlumnoBecado extends Alumno implements Serializable {
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
	public AlumnoBecado() {
		this.tipobeca="";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private int id;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String tipobeca;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	public void setTipobeca(String  tipobeca){
		this.tipobeca = tipobeca;
	}
	
	public String getTipobeca(){
		return this.tipobeca;
	}
	 @Override
	 public String toString() {

	return getDNI() + " " + getNombre() + " " + getPrimerApellido() + " "
			+ getSegundoApellido()+ " "+getTipoAlumno()+ " "+ tipobeca ;
	}
}