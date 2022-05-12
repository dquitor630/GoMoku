package goMoku;

import java.util.Scanner;

public abstract class Jugador {
	protected String nombre;
	protected int numJugador;
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	Jugador(int numJugador, String nombre) {
		this.numJugador = numJugador;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	protected abstract int[] indicarCoordenada(Tablero tablero); //se le pasa el tablero aunque solo lo utilizara la ia

	public String getFicha() {
		if (numJugador == 1) {
			return Ficha.FICHA1.getFicha();
		} else {
			return Ficha.FICHA2.getFicha();
		}

	}

	public int getNumJugador() {
		return numJugador;
	}
}
