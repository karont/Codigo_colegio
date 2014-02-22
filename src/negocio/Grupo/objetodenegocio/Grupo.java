/**
 * 
 */
package negocio.Grupo.objetodenegocio;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.Set;
import negocio.Alumno.objetodenegocio.Alumno;
import javax.persistence.ManyToMany;
import negocio.Asignatura.objetodenegocio.Asignatura;


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
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByid", query = "select obj from Grupo obj where obj.id = :id and obj.activo = true"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByidinactive", query = "select obj from Grupo obj where obj.id = :id"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByletra", query = "select obj from Grupo obj where obj.letra = :letra"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByactivo", query = "select obj from Grupo obj where obj.activo = :activo"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findBycurso", query = "select obj from Grupo obj where obj.curso = :curso"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByalumno", query = "select obj from Grupo obj where obj.alumno = :alumno"),
		@NamedQuery(name = "negocio.Grupo.objetodenegocio.Grupo.findByasignatura", query = "select obj from Grupo obj where obj.asignatura = :asignatura and obj.activo = true") })
public class Grupo implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;
	public static final String QUERY_BUSCAR_GRUPO_POR_ID_INACTIVO = "negocio.Grupo.objetodenegocio.Grupo.findByidinactive";
	public static final String QUERY_BUSCAR_GRUPO_POR_ID= "negocio.Grupo.objetodenegocio.Grupo.findByid";
	public static final String QUERY_BUSCAR_GRUPO_POR_ASIGNATURA = "negocio.Grupo.objetodenegocio.Grupo.findByasignatura";

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Grupo() {
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
	private Character letra;
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
	private Integer curso;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@ManyToMany(mappedBy = "grupo")
	private Set<Alumno> alumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Set<Alumno> getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Set<Alumno> alumno) {
		this.alumno = alumno;
	}
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
	private Asignatura asignatura;
	
	
	public Asignatura getAsignaturas() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setID(int id) {
		this.id=id;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setLetra(Character letra) {
		this.letra = letra;
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
	public void setCurso(Integer curso) {
		this.curso = curso;
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
	public Character getLetra() {

		return this.letra;

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
	public Integer getCurso() {
		
		return this.curso;
	
	}
	public boolean isActivo(){
		return activo;
	}
	 @Override
	 public String toString() {

	return curso + " " + letra ;
	}
}