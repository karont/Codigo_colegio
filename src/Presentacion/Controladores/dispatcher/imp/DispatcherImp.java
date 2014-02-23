/**
 * 
 */
package Presentacion.Controladores.dispatcher.imp;


import Presentacion.Alumno.singleton.GUIAlumno;
import Presentacion.Asignatura.singleton.GUIAsignatura;
import Presentacion.Comandos.CommandResponse;
import Presentacion.Comandos.IdEventos;
import Presentacion.Controladores.dispatcher.Singleton.Dispatcher;
import Presentacion.Grupo.singleton.GUIGrupo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class DispatcherImp extends Dispatcher {


	public void redirect(CommandResponse respuestacomando) {
		IdEventos eventoActual = respuestacomando.getEvento();
		Object datos = respuestacomando.getDatos();
		
		if (eventoActual == IdEventos.EVENTO_ALTA_ALUMNO
				|| eventoActual == IdEventos.EVENTO_BAJA_ALUMNO
				|| eventoActual == IdEventos.EVENTO_MODIFICAR_ALUMNO
				|| eventoActual == IdEventos.EVENTO_CONSULTAR_ALUMNO
				|| eventoActual == IdEventos.EVENTO_CONSULTAR_TODOS_ALUMNOS
				|| eventoActual == IdEventos.EVENTO_CONSULTAR_ALUMNO_V_BORRAR
				|| eventoActual == IdEventos.EVENTO_CONSULTAR_ALUMNO_V_MODIFICAR
				|| eventoActual == IdEventos.ERROR_ALTA_ALUMNO
				|| eventoActual == IdEventos.ERROR_BAJA_ALUMNO
				|| eventoActual == IdEventos.ERROR_MODIFICAR_ALUMNO
				|| eventoActual == IdEventos.ERROR_CONSULTAR_ALUMNO
				|| eventoActual == IdEventos.ERROR_CONSULTAR_TODOS_ALUMNOS
				|| eventoActual == IdEventos.ERROR_CONSULTAR_ALUMNO_V_BORRAR
				|| eventoActual == IdEventos.ERROR_CONSULTAR_ALUMNO_V_MODIFICAR) {
			
			GUIAlumno.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IdEventos.EVENTO_ALTA_ASIGNATURA
				    || eventoActual == IdEventos.EVENTO_BAJA_ASIGNATURA
				    || eventoActual == IdEventos.EVENTO_CONSULTAR_ASIGNATURA
				    || eventoActual == IdEventos.EVENTO_ALTA_ASIGNATURA
				    || eventoActual == IdEventos.ERROR_MODIFICAR_ASIGNATURA
		    		|| eventoActual == IdEventos.EVENTO_CONSULTAR_ASIGNATURA_V_BORRAR
    				|| eventoActual == IdEventos.ERROR_CONSULTAR_ASIGNATURA_V_BORRAR
    				|| eventoActual == IdEventos.ERROR_CONSULTAR_ASIGNATURA
				    || eventoActual == IdEventos.ERROR_BAJA_ASIGNATURA
				    || eventoActual == IdEventos.ERROR_ALTA_ASIGNATURA) {
	
			GUIAsignatura.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IdEventos.ERROR_ALTA_GRUPO
			    || eventoActual == IdEventos.ERROR_BAJA_GRUPO
			    || eventoActual == IdEventos.ERROR_CONSULTAR_GRUPO
			    || eventoActual == IdEventos.ERROR_MODIFICAR_GRUPO
			    || eventoActual == IdEventos.EVENTO_ALTA_GRUPO
			    || eventoActual == IdEventos.EVENTO_BAJA_GRUPO
			    || eventoActual == IdEventos.EVENTO_CONSULTAR_GRUPO
			    || eventoActual == IdEventos.EVENTO_CONSULTAR_GRUPO_V_BORRAR
	    		|| eventoActual == IdEventos.ERROR_CONSULTAR_GRUPO_V_BORRAR) {
			

			GUIGrupo.getInstance().update(eventoActual, datos);
		}
		
		
	}
}