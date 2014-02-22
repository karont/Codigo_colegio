/**
 * 
 */
package negocio.Asignatura.serviciodeaplicacion.implementacion;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Presentacion.principal.Colegio;

import negocio.Asignatura.serviciodeaplicacion.interfaz.SAAsignatura;
import negocio.Asignatura.objetodenegocio.Asignatura;
import negocio.Grupo.objetodenegocio.Grupo;


import negocio.exceptions.ColegioExceptions;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAAsignaturaImp implements SAAsignatura {
	/** 
	 * (sin Javadoc)
	 * @see SAAsignatura#añadirAsignatura(Asignatura nuevaasignatura)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Asignatura añadirAsignatura(Asignatura nuevaasignatura) throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Asignatura resultado = null;
		TypedQuery<Asignatura> query = null;

		nuevaasignatura.setActivo(true);
		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Asignatura.QUERY_BUSCAR_ASIGNATURA_POR_NOMBRE_NOACTIVO, Asignatura.class);
		    query.setParameter("nombre", nuevaasignatura.getNombre());
		    resultado = query.getSingleResult();
		    
		    if(resultado.isActivo()){
			
		    entityManager.getTransaction().rollback();
		    throw new ColegioExceptions("La asignatura ya existe en la base de datos");
		    
		    }else{
		   // nuevaasignatura.setID(resultado.getID());
			entityManager.merge(nuevaasignatura);
			entityManager.getTransaction().commit();
		    }
		   
		    
		} catch (NoResultException ex) {
		    entityManager.persist(nuevaasignatura);

		    entityManager.getTransaction().commit();
		    

		}catch (Exception ex) {
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			 entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		    
		}finally {
		    entityManager.detach(nuevaasignatura);
		    entityManager.close();
		    entityManagerFactory.close();
		}

		return nuevaasignatura;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAsignatura#borrarAsignatura(int idAsignatura)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean borrarAsignatura(Asignatura asignaturaaborrar) throws ColegioExceptions{
		boolean borrado = false;
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TypedQuery<Asignatura> query = null;
		Asignatura resultado = null;

		try {
			TypedQuery<Grupo> query2 = null;
		    entityManager.getTransaction().begin();
		    query2 = entityManager.createNamedQuery(
		    		Grupo.QUERY_BUSCAR_GRUPO_POR_ASIGNATURA, Grupo.class);
		    query2.setParameter("asignatura", asignaturaaborrar);

		    List<Grupo> grupos = query2.getResultList();
		    if ( !grupos.isEmpty() ) {
				throw new ColegioExceptions("No se puede borrar una asignatura con grupos");
			 }
		    
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Asignatura.QUERY_BUSCAR_ASIGNATURA_POR_ID, Asignatura.class);
		    query.setParameter("id", asignaturaaborrar.getID());

		    resultado = query.getSingleResult();
		    resultado.setActivo(false);
		  
		  
		    entityManager.merge(resultado);

		    entityManager.getTransaction().commit();

		    borrado = true;

		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();
		    throw new ColegioExceptions("La asignatura no existe, no se puede borrar");

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
	 * @see SAAsignatura#obtenerAsignatura(int idasignatura)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Asignatura obtenerAsignatura(int idasignatura) throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		TypedQuery<Asignatura> query = null;
		Asignatura resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Asignatura.QUERY_BUSCAR_ASIGNATURA_POR_ID, Asignatura.class);
		    query.setParameter("id", idasignatura);
		    resultado = query.getSingleResult();
		    
	
		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();

		    throw new ColegioExceptions("No se pudo encontrar la Asignatura con ID "
			    + idasignatura);
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