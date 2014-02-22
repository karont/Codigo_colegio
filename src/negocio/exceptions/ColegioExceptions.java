package negocio.exceptions;

public class ColegioExceptions extends Exception {
	
private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public ColegioExceptions(String mensajeError) {
		
		mensaje = mensajeError;
	}
	
	public String getMensaje() {
		
		return mensaje;
	}
	
	public void setMensaje(String mensajeError) {
		
		mensaje = mensajeError;
	}
}
