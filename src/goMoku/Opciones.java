package goMoku;

/**
 * Clase que almacena las opciones del juego.
 * @author Diego Quiros Torres
 * @version 1.0
 * @since 1.0
 * 
 *
 */
public class Opciones {
	/**
	 * Atributo de tipo boolean que almacena si el usuario desea confirmar las jugadas.
	 */
	private boolean confirmacion;
	/**
	 * Atributo de tipo int que almacena si hay retraso en la salida de la consola.
	 */
	private int retrasoConsola;

	/**
	 * Metodo que devuelve el retraso de la consola.
	 * @return int
	 */
	public int getRetrasoConsola() {
		return retrasoConsola;
	}

	/**
	 * Metodo que establece el retraso de la consola.
	 * @param retrasoConsola Int de la Cantidad del retraso.
	 */
	public void setRetrasoConsola(int retrasoConsola) {
		this.retrasoConsola = retrasoConsola;
	}

	/**
	 * Constructor que pone las opciones por defecto.
	 */
	public Opciones() {
		confirmacion = true;
		retrasoConsola = 1;

	}

	/**
	 * Metodo que devuelve si hay confirmacion
	 * @return boolean
	 */
	public boolean isConfirmacion() {
		return confirmacion;
	}

	/**
	 * Metodo que establece si el usuario quiere confirmacion
	 * @param boolean de la confirmacion
	 */
	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
}
