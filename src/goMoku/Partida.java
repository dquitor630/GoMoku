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
		boolean exit = false;
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
			game = true;
			System.out.println("Ha ganado el jugador " + jugador.getNombre());
			System.out.println("¿Volver a jugar? s/n");
			if (consoleIn.readBooleanUsingChar('s', 'n')) {
				game = false;
				numTurno = 0;
				tablero = new Tablero(opciones);
				tablero.pintarTablero();
			}
		}
		return game;
	}

	private void turno(Jugador jugador) {
		numTurno = numTurno + 1;
		boolean exit;
		System.out.println("Turno " + numTurno + ", Jugador " + jugador.getNombre());
		do {
			exit = tablero.modificarTablero(jugador.indicarCoordenada(tablero), jugador.getFicha(),
					jugador.getClass().getSimpleName());
		} while (!exit);
		try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//programar mensaje de derrota si es una ia
}
