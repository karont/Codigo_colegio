/**
 * 
 */
package negocio.Grupo.serviciodeaplicacion.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Presentacion.principal.Colegio;



import negocio.Alumno.objetodenegocio.Alumno;
import negocio.Grupo.serviciodeaplicacion.interfaz.SAGrupo;
import negocio.Grupo.objetodenegocio.Grupo;
import negocio.exceptions.ColegioExceptions;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAGrupoImp implements SAGrupo {
	/** 
	 * (sin Javadoc)
	 * @see SAGrupo#añadirGrupo(Grupo nuevogrupo)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Grupo añadirGrupo(Grupo nuevogrupo) throws ColegioExceptions{
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Grupo resultado = null;
		TypedQuery<Grupo> query = null;

		nuevogrupo.setActivo(true);
		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Grupo.QUERY_BUSCAR_GRUPO_POR_ID_INACTIVO, Grupo.class);
		    query.setParameter("id", nuevogrupo.getID());
		    resultado = query.getSingleResult();
		    
		    if(resultado.isActivo()){
			
		    	entityManager.getTransaction().rollback();
		    	throw new ColegioExceptions("EL grupo ya existe en la base de datos");
		    
		    }else{
		   //alumnonuevo.setID(resultado.getID());
			entityManager.merge(nuevogrupo);
			entityManager.getTransaction().commit();
		    }
		   
		    
		} catch (NoResultException ex) {
		    entityManager.persist(nuevogrupo);

		    entityManager.getTransaction().commit();
		    

		}catch (Exception ex) {
		    if(ex instanceof ColegioExceptions) throw ex;
		    else{
			 entityManager.getTransaction().rollback();
			throw new ColegioExceptions(ex.getMessage());
		    }
		    
		}finally {
		    entityManager.detach(nuevogrupo);
		    entityManager.close();
		    entityManagerFactory.close();
		}

		return nuevogrupo;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAGrupo#borrarGrupo(int idgrupo, boolean borrado)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean borrarGrupo(Grupo grupoaborrar) throws ColegioExceptions {
		boolean borrado = false;
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TypedQuery<Grupo> query = null;
		Grupo resultado = null;

		try {
			TypedQuery<Alumno> query2 = null;
		    entityManager.getTransaction().begin();
		    query2 = entityManager.createNamedQuery(
		    		Alumno.QUERY_BUSCAR_ALUMNOS_POR_GRUPO, Alumno.class);
		    query2.setParameter("grupo", grupoaborrar);

		    List<Alumno> grupos = query2.getResultList();
		    if ( !grupos.isEmpty() ) {
				throw new ColegioExceptions("No se puede borrar un grupo con alumnos");
			 }
		    
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Grupo.QUERY_BUSCAR_GRUPO_POR_ID, Grupo.class);
		    query.setParameter("id", grupoaborrar.getID());

		    resultado = query.getSingleResult();
		    resultado.setActivo(false);
		  
		  
		    entityManager.merge(resultado);

		    entityManager.getTransaction().commit();

		    borrado = true;

		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();
		    throw new ColegioExceptions("El grupo no existe, no se puede borrar");

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
	 * @see SAGrupo#obtenerGrupo(int idgrupo, Grupo grupo)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Grupo obtenerGrupo(int idgrupo) throws ColegioExceptions {
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Colegio.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		TypedQuery<Grupo> query = null;
		Grupo resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
		    		Grupo.QUERY_BUSCAR_GRUPO_POR_ID, Grupo.class);
		    query.setParameter("id", idgrupo);
		    resultado = query.getSingleResult();
		    
	
		} catch (NoResultException ex) {

		    entityManager.getTransaction().rollback();

		    throw new ColegioExceptions("No se pudo encontrar el Alumno con ID "
			    + idgrupo);
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