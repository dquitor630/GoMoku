package goMoku;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *  Clase donde se desarrollara la partida.
 * @author Diego Quiros Torres
 * @version 1.0
 * @since 1.0
 * 
 *
 */
public class Partida {
	/**
	 * Atributo que almacena un objeto de tipo Jugador.
	 */
	private Jugador jugador1;
	/**
	 * Atributo que almacena un objeto de tipo Jugador.
	 */
	private Jugador jugador2;
	/**
	 * Atributo que almacena un objeto de tipo Tablero.
	 */
	private Tablero tablero;
	/**
	 * Atributo de tipo int que almacena en que turno se encuentra la partida.
	 */
	private int numTurno;
	/**
	 * Atributo del objeto opciones donde se encuentran las opciones de la partida.
	 */
	private Opciones opciones;
	/**
	 * Teclado para el consoleInput
	 */
	Scanner keyboard = new Scanner(System.in);
	/**
	 * ConsoleInput para introducir datos
	 */
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	/**
	 * Constructor de la partida.
	 * @param jugador1 Objeto de tipo jugador del Primer jugador que participa.
	 * @param jugador2 Objeto de tipo jugador del  Segundo jugador que participa.
	 * @param opciones Objeto de la clase Opciones que almacena Opciones de la partida.
	 */
	Partida(Jugador jugador1, Jugador jugador2, Opciones opciones) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.opciones = opciones;
		this.tablero = new Tablero(opciones);
		tablero.pintarTablero();
		juego();
	}

	/**
	 * Metodo void donde se desarrollara el juego.
	 */
	private void juego() {
		//optimizar codigo utilizando metodos para los jugadores y eso
		boolean game = false;
		do {
			turno(jugador1);
			if (tablero.isTerminado()) {
				game = victoria(jugador1);
			} else {
				turno(jugador2);
			}
			if (tablero.isTerminado() && game != true) {
				game = victoria(jugador2);
			}
			try {
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!game);
	}

	/**
	 * Metodo que llama al metodo del tablero para verificar victorias y da por finalizada la partida.
	 * @param jugador Objeto Jugador del turno actual.
	 * @return boolean
	 * @see Tablero
	 *
	 */
	private boolean victoria(Jugador jugador) {
		boolean game = false;
		if (tablero.isTerminado()) {
			if (jugador.getNumJugador() == 1) {
				System.out.println(Colors.BLUE + "Ha ganado el jugador " + jugador.getNombre() + Colors.RESET);
			} else {
				System.out.println(Colors.YELLOW + "Ha ganado el jugador " + jugador.getNombre() + Colors.RESET);
			}
			game = true;

		}
		return game;
	}

	/**
	 * Todas las acciones del turno de un jugador
	 * @param jugador Objeto Jugador que realizara el turno.
	 *  @see Tablero
	 */
	private void turno(Jugador jugador) {
		numTurno = numTurno + 1;
		boolean exit;
		if (jugador.getNumJugador() == 1) {
			System.out.println(Colors.BLUE + "Turno " + numTurno + ", Jugador " + jugador.getNombre() + Colors.RESET);
		} else {
			System.out.println(Colors.YELLOW + "Turno " + numTurno + ", Jugador " + jugador.getNombre() + Colors.RESET);
		}
		do {
			exit = tablero.modificarTablero(jugador.indicarCoordenada(tablero), jugador.getFicha(),
					jugador.getClass().getSimpleName());

		} while (!exit);
		try {
			TimeUnit.SECONDS.sleep(opciones.getRetrasoConsola());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//programar mensaje de derrota si es una ia
}
