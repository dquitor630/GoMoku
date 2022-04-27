package goMoku;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Partida {
	//tengo que hacer que al llegar al turno x la partida termina porque no quedan espacios
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private int numTurno;
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	Partida(Jugador jugador1, Jugador jugador2, Tablero tablero) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.tablero = tablero;
		juego();
	}

	private void juego() {
		boolean exit = false;
		boolean game = false;
		do {
			numTurno = numTurno + 1;
			System.out.println("Turno " + numTurno + ", Jugador " + jugador1.getNombre());
			do {
				exit = tablero.modificarTablero(jugador1.indicarCoordenada(tablero), jugador1.getFicha(),
						jugador1.getClass().getSimpleName());
			} while (!exit);
			try {
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tablero.isTerminado()) {
				game = true;
				System.out.println("Ha ganado el jugador " + jugador1.getNombre());
				System.out.println("¿Volver a jugar? s/n");
				if (consoleIn.readBooleanUsingChar('s', 'n')) {
					game = false;
					numTurno = 0;
					tablero = new Tablero();
				}
			} else {
				numTurno = numTurno + 1;
				exit = false;
				System.out.println("Turno " + numTurno + ", Jugador " + jugador2.getNombre());
				do {
					exit = tablero.modificarTablero(jugador2.indicarCoordenada(tablero), jugador2.getFicha(),
							jugador2.getClass().getSimpleName());
				} while (!exit);
			}
			if (tablero.isTerminado() && game != true) {
				game = true;
				System.out.println("Ha ganado el jugador " + jugador2.getNombre());
				System.out.println("¿Volver a jugar? s/n");
				if (consoleIn.readBooleanUsingChar('s', 'n')) {
					game = false;
					numTurno = 0;
					tablero = new Tablero();
				}
			}
			try {
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!game);
	}

	//programar mensaje de derrota si es una ia
}
