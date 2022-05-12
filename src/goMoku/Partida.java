package goMoku;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Partida {
	//tengo que hacer que al llegar al turno x la partida termina porque no quedan espacios
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private int numTurno;
	@SuppressWarnings("unused")
	private Opciones opciones;
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	Partida(Jugador jugador1, Jugador jugador2, Opciones opciones) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.opciones = opciones;
		this.tablero = new Tablero(opciones);
		tablero.pintarTablero();
		juego();
	}

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
