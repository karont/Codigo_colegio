/**
 * 
 */
package Presentacion.Comandos.Alumno.comandos;


import negocio.Alumno.objetodenegocio.Alumno;
import negocio.exceptions.ColegioExceptions;
import negocio.factoria.Singleton.FactorySA;
import Presentacion.Comandos.CommandResponse;
import Presentacion.Comandos.IdEventos;
import Presentacion.Comandos.interfaz.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandAltaAlumno implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		
		try {

			cr.setDatos(FactorySA.getInstance().getSAalumno().aņadirAlumno((Alumno) datos));
			cr.setEvento(IdEventos.EVENTO_ALTA_ALUMNO);

		} catch (ColegioExceptions bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IdEventos.ERROR_ALTA_ALUMNO);
		}
		
		return cr;
	}
}