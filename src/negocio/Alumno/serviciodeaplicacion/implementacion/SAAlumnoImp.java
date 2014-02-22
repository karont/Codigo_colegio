/**
 * 
 */
package negocio.Alumno.serviciodeaplicacion.implementacion;

import negocio.Alumno.serviciodeaplicacion.interfaz.SAAlumno;
import negocio.Alumno.objetodenegocio.Alumno;
import negocio.Grupo.objetodenegocio.Grupo;
import negocio.exceptions.ColegioExceptions;



import java.util.HashSet;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Presentacion.principal.Colegio;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAAlumnoImp implements SAAlumno {
	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#añadirAlumno(Alumno alumnonuevo)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Alumno añadirAlumno(Alumno alumnonuevo) throws ColegioExceptions {
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Alumno resultado = null;
		TypedQuery<Alumno> query = null;

		alumnonuevo.setActivo(true);
		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
			    Alumno.QUERY_BUSCAR_ALUMNOS_POR_DNI_NOACTIVO, Alumno.class);
		    query.setParameter("dni", alumnonuevo.getDNI());
		    resultado = query.getSingleResult();
		    
		    if(resultado.isActivo()){
			
		    entityManager.getTransaction().rollback();
		    throw new ColegioExceptions("El Alumno ya existe en la base de datos");
		    
		    }else{
		   //alumnonuevo.setID(resultado.getID());
			entityManager.merge(alumnonuevo);
			entityManager.getTransaction().commit();
		    }
		   
		    
		} catch (NoResultException ex) {
		    entityManager.persist(alumnonuevo);

		    entityManager.getTransaction().commit();
		    

		}catch (Exception ex) {
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			 entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		    
		}finally {
		    entityManager.detach(alumnonuevo);
		    entityManager.close();
		    entityManagerFactory.close();
		}

		return alumnonuevo;
		
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#obtenerTodosAlumnos()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<Alumno> obtenerTodosAlumnos() throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		TypedQuery<Alumno> query = null;
		List<Alumno> resultados = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Alumno.QUERY_BUSCAR_TODOS_LOS_ALUMNOS, Alumno.class);

		    resultados = query.getResultList();

		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();

		    throw new ColegioExceptions("No se encontraron Alumnos");
		} catch (Exception ex) {

		    
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		} finally {
		    for (Alumno alum : resultados) {
			entityManager.detach(alum);
		    }

		    entityManager.close();
		    entityManagerFactory.close();
		}
		return resultados;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#actualizarAlumno(Object alumnoactualizado)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Alumno actualizarAlumno(Alumno alumnoactualizado) throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TypedQuery<Alumno> query = null;
		Alumno resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Alumno.QUERY_BUSCAR_ALUMNOS_POR_ID, Alumno.class);
		    query.setParameter("id", alumnoactualizado.getID());

		    resultado = query.getSingleResult();
		    alumnoactualizado.setID(resultado.getID());


		    entityManager.merge(alumnoactualizado);

		    entityManager.getTransaction().commit();

		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();

		    throw new ColegioExceptions(
			    "No se ha podido actualizar el alumno, por que no existe");
		}catch (Exception ex) {
			    
		    
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		} finally {
		    entityManager.detach(alumnoactualizado);
		    entityManager.close();
		    entityManagerFactory.close();
		}

		return alumnoactualizado;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#borrarAlumno(int alumnoaborrar)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean borrarAlumno(int alumnoaborrar) throws ColegioExceptions{
		
		boolean borrado = false;
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TypedQuery<Alumno> query = null;
		Alumno resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Alumno.QUERY_BUSCAR_ALUMNOS_POR_ID, Alumno.class);
		    query.setParameter("id", alumnoaborrar);

		    resultado = query.getSingleResult();

		    resultado.setActivo(false);
		    resultado.setGrupo(new HashSet<Grupo>());
		    
		    entityManager.merge(resultado);

		    entityManager.getTransaction().commit();

		    borrado = true;

		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();
		    throw new ColegioExceptions("El alumno no existe, no se puede borrar");

		} catch (Exception e) {
		    
		    if(e instanceof ColegioExceptions) throw e;
		    else{
			entityManager.getTransaction().rollback();
			throw new ColegioExceptions(e.getMessage());
		    }
		}finally {
		    
		    entityManager.close();
		    entityManagerFactory.close();
		}

		return borrado;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#obtenerAlumno(int idalumno)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Alumno obtenerAlumno(int idalumno) throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		TypedQuery<Alumno> query = null;
		Alumno resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Alumno.QUERY_BUSCAR_ALUMNOS_POR_ID, Alumno.class);
		    query.setParameter("id", idalumno);
		    resultado = query.getSingleResult();
		    
	
		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();

		    throw new ColegioExceptions("No se pudo encontrar el Alumno con ID "
			    + idalumno);
		} catch (Exception ex) {
		    
		   
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		} finally {
		    if (resultado != null)
			entityManager.detach(resultado);

		    entityManager.close();
		    entityManagerFactory.close();
		}
		return resultado;
	}


}