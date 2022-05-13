package goMoku;

import java.util.Scanner;

/**
 *  Clase que representa al jugador.
  * @author Diego Quiros Torres
  * @version 1.0
  * @since 1.0
  * 
 *
 */
public abstract class Jugador {
	/**
	 * Atributo de clase String que almacena el nombre del jugador.
	 */
	protected String nombre;
	/**
	 * Atributo de clase Strings que almacena el numero del jugador.
	 */
	protected int numJugador;
	/**
	 * Teclado para ser introducido en el ConsoleInput.
	 */
	Scanner keyboard = new Scanner(System.in);
	/**
	 * ConsoleInput para introducir datos.
	 */
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	/**
	 * Constructor de la clase jugador
	 * @param nombre String del Nombre del jugador.
	 * @param numJugador int del Numero del jugador.
	 */
	Jugador(int numJugador, String nombre) {
		this.numJugador = numJugador;
		this.nombre = nombre;
	}

	/**
	 * devuelve una cadena con el nombre del jugador
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo abstracto para indicar la coordenada donde se colocara la ficha.
	 * @param tablero objeto Tablero donde se colocara la ficha.
	 */
	protected abstract int[] indicarCoordenada(Tablero tablero); //se le pasa el tablero aunque solo lo utilizara la ia

	/**
	 * Metodo que devuelve la ficha del jugador
	 * @return String
	 */

	public String getFicha() {
		if (numJugador == 1) {
			return Ficha.FICHA1.getFicha();
		} else {
			return Ficha.FICHA2.getFicha();
		}

	}

	/**
	 * Metodo que devuelve el numero del jugador.
	 * @return int
	 */
	public int getNumJugador() {
		return numJugador;
	}
}
