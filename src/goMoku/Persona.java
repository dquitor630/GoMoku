package goMoku;

/**
 *  Clase hija de jugador que representa un usuario.
  * @author Diego Quiros Torres
  * @version 1.0
  * @since 1.0
  * @see Jugador
  * 
 *
 */
public class Persona extends Jugador {

	/**
	 * Constructor de la clase Persona.
	 * @param numJugador int del numero del jugador.
	 * @param nombre String del nombre del jugador.
	 */
	Persona(int numJugador, String nombre) {
		super(numJugador, nombre);
	}

	/**
	 * Metodo para indicar coordenadas.
	 */
	@Override
	public int[] indicarCoordenada(Tablero tablero) {
		boolean exit;
		int[] result = new int[2];
		System.out.println("Introduce la Coordenada X (a-o)");
		//cambiar a unicode
		do {
			exit = true;
			result[0] = (int) Character.toLowerCase(consoleIn.readChar()) - 97;
			if (result[0] < 0 || result[0] > 14) {
				exit = false;
				System.out.println("Has introducido una coordenada no válida, vuelve a introducirla");
			}
		} while (!exit);
		System.out.println("Introduce la coordenada Y (1-15)");
		result[1] = consoleIn.readIntInRange(1, 15) - 1;
		return result;
	}

}
