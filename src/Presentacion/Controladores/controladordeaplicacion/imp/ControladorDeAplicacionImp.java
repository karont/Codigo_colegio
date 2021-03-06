/**
 * 
 */
package Presentacion.Controladores.controladordeaplicacion.imp;


import Presentacion.Comandos.CommandResponse;
import Presentacion.Comandos.IdEventos;
import Presentacion.Comandos.Factoria.Singleton.CommandFactory;
import Presentacion.Comandos.interfaz.Command;
import Presentacion.Controladores.controladordeaplicacion.Singleton.ControladorDeAplicacion;
import Presentacion.Controladores.dispatcher.Singleton.Dispatcher;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ControladorDeAplicacionImp extends ControladorDeAplicacion {

	
	public void handleRequest(IdEventos evento, Object datos) {
		Command c = CommandFactory.getInstance().nuevoComando(evento);
		CommandResponse rc = c.execute(datos);
		Dispatcher.getInstance().redirect(rc);
		
	}
}