package goMoku;

public class Partida {
	//tengo que hacer que al llegar al turno x la partida termina porque no quedan espacios
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private int numTurno;

	Partida(Jugador jugador1, Jugador jugador2, Tablero tablero) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.tablero = tablero;
		juego();
	}

	private void juego() {
		do {
			boolean exit = false;
			numTurno = numTurno + 1;
			System.out.println("Turno " + numTurno + ", Jugador " + jugador1.getNombre());
			do {
				exit = tablero.modificarTablero(jugador1.indicarCoordenada(tablero), jugador1.getFicha(),
						jugador1.getClass().getSimpleName());
			} while (!exit);
			numTurno = numTurno + 1;
			exit = false;
			System.out.println("Turno " + numTurno + ", Jugador " + jugador2.getNombre());
			do {
				exit = tablero.modificarTablero(jugador2.indicarCoordenada(tablero), jugador2.getFicha(),
						jugador2.getClass().getSimpleName());
			} while (!exit);
		} while (true);
	}

	//programar mensaje de derrota si es una ia
}
