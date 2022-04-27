package goMoku;

import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput consoleIn = new ConsoleInput(keyboard);

		byte opcion;
		do {
			Tablero tablero = new Tablero();
			Jugador ia1 = new Ia(1);
			Jugador ia2 = new Ia(2);
			Jugador persona = new Persona(1, "null");
			Jugador persona2 = new Persona(2, "null");
			//estaría interesante tirar una moneda para ver quien empieza primero
			System.out.println("   _____  ____    __  __  ____  _  ___    _  \r\n"
					+ "  / ____|/ __ \\  |  \\/  |/ __ \\| |/ / |  | | \r\n"
					+ " | |  __| |  | | | \\  / | |  | | ' /| |  | | \r\n"
					+ " | | |_ | |  | | | |\\/| | |  | |  < | |  | | \r\n"
					+ " | |__| | |__| | | |  | | |__| | . \\| |__| | \r\n"
					+ "  \\_____|\\____/  |_|  |_|\\____/|_|\\_\\\\____/  \n" + "\t © Diego Quirós Torres 2022\n");
			System.out.println("Menú Principal:\n" + "1. Jugador vs Jugador\n" + "2. Jugador vs Ia \n" + "3. Ia vs Ia");
			opcion = consoleIn.readByteInRange((byte) 1, (byte) 3);
			switch (opcion) {
			case 1:
				System.out.println("Introduce el nombre para el jugador 1:");
				persona = new Persona(1, consoleIn.readString());
				System.out.println("Introduce el nombre para el jugador 2:");
				persona2 = new Persona(2, consoleIn.readString());
				tablero.pintarTablero();
				Partida partida = new Partida(persona, persona2, tablero);
				break;
			case 2:
				System.out.println("introduce el nombre para el jugador: ");
				persona = new Persona(1, consoleIn.readString());
				ia1 = new Ia(2);
				tablero = new Tablero();
				tablero.pintarTablero();
				partida = new Partida(persona, ia1, tablero);
				break;
			case 3:
				ia1 = new Ia(1);
				ia2 = new Ia(2);
				tablero = new Tablero();
				tablero.pintarTablero();
				partida = new Partida(ia1, ia2, tablero);
				break;
			}

		} while (!exit);

	}

}
