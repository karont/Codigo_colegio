/**
 * 
 */
package negocio.Alumno.objetodenegocio;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.Set;
import negocio.Grupo.objetodenegocio.Grupo;



import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Inheritance(strategy = InheritanceType.JOINED)
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "DNI") })
@Entity
@NamedQueries({
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findByid", query = "select obj from Alumno obj where obj.id = :id and obj,activo = true"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findBynombre", query = "select obj from Alumno obj where obj.nombre = :nombre"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findByprimerapellido", query = "select obj from Alumno obj where obj.primerapellido = :primerapellido"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findBysegundoapellido", query = "select obj from Alumno obj where obj.segundoapellido = :segundoapellido"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findByDNI", query = "select obj from Alumno obj where obj.DNI = :DNI"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findByactivo", query = "select obj from Alumno obj where obj.activo = :activo"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findAll", query = "select obj from Alumno obj where obj.activo = true"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findBygrupo", query = "select obj from Alumno obj where obj.grupo = :grupo"),
		@NamedQuery(name = "negocio.Alumno.objetodenegocio.Alumno.findalleveninactive", query = "select obj from Alumno obj where obj.DNI = :dni") })
public class Alumno implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;
	
	public static final String QUERY_BUSCAR_ALUMNOS_POR_DNI_NOACTIVO = "negocio.Alumno.objetodenegocio.Alumno.findalleveninactive";
	public static final String QUERY_BUSCAR_ALUMNOS_POR_ID = "negocio.Alumno.objetodenegocio.Alumno.findByid";
	public static final String QUERY_BUSCAR_TODOS_LOS_ALUMNOS = "negocio.Alumno.objetodenegocio.Alumno.findAll";

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Alumno() {
		DNI = "";
		nombre = "";
		primerapellido = "";
		segundoapellido = "";
		activo = true;
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
	private String nombre;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String primerapellido;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String segundoapellido;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String DNI;
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
	@ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Set<Grupo> grupo;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	
	public Set<Grupo> getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Set<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setPrimerApellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setSegundoApellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
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
	public String getNombre() {
		return this.nombre;

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getPrimerApellido() {

		return this.primerapellido;

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getSegundoApellido() {

		return this.segundoapellido;

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getDNI() {

		return this.DNI;
	
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
	private TipoAlumno tipo;
	
	public enum TipoAlumno {
		BECADO, NOBECADO
	};
	
	public void setTipoAlumno(TipoAlumno tipo){
		this.tipo=tipo;
	}
	
	public TipoAlumno getTipoAlumno(){
		return this.tipo;
	}
	@Override
    public boolean equals(Object o) {

	return DNI.equals(((Alumno) o).getDNI());
    }
	
	public boolean isActivo(){
		return activo;
	}
	 @Override
	 public String toString() {

	return DNI + " " + nombre + " " + primerapellido + " "
			+ segundoapellido ;
	}
}