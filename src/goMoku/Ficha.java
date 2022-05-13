package goMoku;

/**
 * Enum que almacena las fichas del jugador 1 y del jugador 2.
  * @author Diego Quiros Torres
  * @version 1.0
  * @since 1.0
 *
 */
public enum Ficha {
	/**
	 * Ficha correspondiente al jugador 1.
	 */

	FICHA1(Colors.BLUE + "X" + Colors.RESET),
	/**
	 * Ficha correspondiente al jugador 2.
	 */
	FICHA2(Colors.YELLOW + "O" + Colors.RESET);

	/**
	 * Variable de tipo String donde se almacena la ficha.
	 */
	protected final String ficha;

	/**
	 * Metodo que nos devuelve la cadena de la ficha.
	 * @return String
	 */
	public String getFicha() {
		return this.ficha;
	}

	/**
	 * Constructor de la ficha.
	 */
	private Ficha(String ficha) {
		this.ficha = ficha;
	}
}
