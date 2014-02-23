/**
 * 
 */
package Presentacion.Comandos.Factoria.imp;

import Presentacion.Comandos.IdEventos;
import Presentacion.Comandos.Alumno.comandos.CommandAltaAlumno;
import Presentacion.Comandos.Alumno.comandos.CommandBajaAlumno;
import Presentacion.Comandos.Alumno.comandos.CommandConsultaAlumno;
import Presentacion.Comandos.Alumno.comandos.CommandConsultaMultiplesAlumnos;
import Presentacion.Comandos.Alumno.comandos.CommandModificarAlumno;
import Presentacion.Comandos.Asignatura.comandos.CommandAltaAsignatura;
import Presentacion.Comandos.Asignatura.comandos.CommandBajaAsignatura;
import Presentacion.Comandos.Asignatura.comandos.CommandConsultarAsignatura;
import Presentacion.Comandos.Factoria.Singleton.CommandFactory;
import Presentacion.Comandos.Grupo.comandos.CommandAltaGrupo;
import Presentacion.Comandos.Grupo.comandos.CommandBajaGrupo;
import Presentacion.Comandos.Grupo.comandos.CommandConsultaGrupo;
import Presentacion.Comandos.interfaz.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandFactoryImp extends CommandFactory {


	public Command nuevoComando(IdEventos id_comando) {
		Command c = null;
		
		switch (id_comando) {
		
			/*Alumno*/
			case EVENTO_ALTA_ALUMNO:
				c = new CommandAltaAlumno();
			break;
			
			case EVENTO_BAJA_ALUMNO:
				c = new CommandBajaAlumno();
			break;
			
			case EVENTO_CONSULTAR_ALUMNO:
				c= new CommandConsultaAlumno();
			break;
			case EVENTO_CONSULTAR_TODOS_ALUMNOS:
				c=new CommandConsultaMultiplesAlumnos();
			break;
			
			case EVENTO_MODIFICAR_ALUMNO:
				c = new CommandModificarAlumno();
			break;
			
			/*Asignatura*/
			case EVENTO_ALTA_ASIGNATURA:
				c = new CommandAltaAsignatura();
			break;
			
			case EVENTO_BAJA_ASIGNATURA:
				c = new CommandBajaAsignatura();
			break;
			
			case EVENTO_CONSULTAR_ASIGNATURA:
				c= new CommandConsultarAsignatura();
			break;
			
			/*Grupo*/
			case EVENTO_ALTA_GRUPO:
				c = new CommandAltaGrupo();
			break;
			
			case EVENTO_BAJA_GRUPO:
				c = new CommandBajaGrupo();
			break;
			
			case EVENTO_CONSULTAR_GRUPO:
				c= new CommandConsultaGrupo();
			break;
		default:
			break;
		}
		return c;
	}
}