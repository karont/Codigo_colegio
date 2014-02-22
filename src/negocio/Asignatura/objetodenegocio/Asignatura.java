/**
 * 
 */
package negocio.Asignatura.objetodenegocio;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;

import negocio.Grupo.objetodenegocio.Grupo;


import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
@NamedQueries({
		@NamedQuery(name = "negocio.Asignatura.objetodenegocio.Asignatura.findByid", query = "select obj from Asignatura obj where obj.id = :id and obj.activo = true"),
		@NamedQuery(name = "negocio.Asignatura.objetodenegocio.Asignatura.findByactivo", query = "select obj from Asignatura obj where obj.activo = :activo"),
		@NamedQuery(name = "negocio.Asignatura.objetodenegocio.Asignatura.findBynombre", query = "select obj from Asignatura obj where obj.nombre = :nombre and obj.activo = true"),
		@NamedQuery(name = "negocio.Asignatura.objetodenegocio.Asignatura.findBygrupo", query = "select obj from Asignatura obj where obj.grupo = :grupo"),
		@NamedQuery(name = "negocio.Asignatura.objetodenegocio.Asignatura.findBynombreinactive", query = "select obj from Asignatura obj where obj.nombre = :nombre") })
public class Asignatura implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;
	
	public static final String QUERY_BUSCAR_ASIGNATURA_POR_NOMBRE_NOACTIVO = "negocio.Asignatura.objetodenegocio.Asignatura.findBynombreinactive";
	public static final String QUERY_BUSCAR_ASIGNATURA_POR_NOMBRE = "negocio.Asignatura.objetodenegocio.Asignatura.findBynombre";
	public static final String QUERY_BUSCAR_ASIGNATURA_POR_ID = "negocio.Asignatura.objetodenegocio.Asignatura.findByid";
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Asignatura() {
		this.activo= true;
		this.nombre = "";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Boolean activo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String nombre;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@OneToMany(mappedBy = "asignatura")
	private Set<Grupo> grupo;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	
	public void setGrupo (Set<Grupo> grupo){
		this.grupo = grupo;
	}
	
	public Set<Grupo> getGrupo(){
		return this.grupo;
	}
	public void setID(int id) {
		this.id = id;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setNombre( String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int getID() {
	
		return this.id;

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean getActivo() {

		return this.activo;
	
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getNombre() {
	
		return this.nombre;
		
	}
	public boolean isActivo(){
		return activo;
	}
	  @Override
	    public String toString() {

		return nombre;
	    }
}