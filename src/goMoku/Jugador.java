package goMoku;

import java.util.Scanner;

public abstract class Jugador {
	protected String nombre;
	private String ficha = Colors.BLUE + "X" + Colors.RESET;
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	protected abstract int[] indicarCoordenada();

	public String getFicha() {
		return ficha;
	}
}
