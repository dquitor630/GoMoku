package goMoku;

import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput consoleIn = new ConsoleInput(keyboard);
		Opciones opciones = new Opciones();
		byte opcion;
		Jugador ia1 = new Ia(1);
		Jugador ia2 = new Ia(2);
		Jugador persona = new Persona(1, "null");
		Jugador persona2 = new Persona(2, "null");
		boolean game = false;
		do {
			//estaría interesante tirar una moneda para ver quien empieza primero
			System.out.println("   _____  ____    __  __  ____  _  ___    _  \r\n"
					+ "  / ____|/ __ \\  |  \\/  |/ __ \\| |/ / |  | | \r\n"
					+ " | |  __| |  | | | \\  / | |  | | ' /| |  | | \r\n"
					+ " | | |_ | |  | | | |\\/| | |  | |  < | |  | | \r\n"
					+ " | |__| | |__| | | |  | | |__| | . \\| |__| | \r\n"
					+ "  \\_____|\\____/  |_|  |_|\\____/|_|\\_\\\\____/  \n" + "\t © Diego Quirós Torres 2022\n");
			System.out.println("Menú Principal:\n" + "1. Jugador vs Jugador\n" + "2. Jugador vs Ia \n" + "3. Ia vs Ia\n"
					+ "4. Menú de opciones");
			opcion = consoleIn.readByteInRange((byte) 1, (byte) 4);
			switch (opcion) {
			case 1:
				System.out.println("Introduce el nombre para el jugador 1:");
				persona = new Persona(1, consoleIn.readString());
				System.out.println("Introduce el nombre para el jugador 2:");
				persona2 = new Persona(2, consoleIn.readString());
				@SuppressWarnings("unused")
				Partida partida = new Partida(persona, persona2, opciones);
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						partida = new Partida(persona, persona2, opciones);
						game = false;
					} else {
						game = true;
					}
				} while (!game);

				break;
			case 2:
				System.out.println("introduce el nombre para el jugador: ");
				persona = new Persona(1, consoleIn.readString());
				ia1 = new Ia(2);
				partida = new Partida(persona, ia1, opciones);
				game = false;
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						partida = new Partida(persona, ia1, opciones);
						game = false;
					} else {
						game = true;
					}
				} while (!game);
				break;
			case 3:
				ia1 = new Ia(1);
				ia2 = new Ia(2);
				partida = new Partida(ia1, ia2, opciones);
				game = false;
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						partida = new Partida(ia1, ia2, opciones);
						game = false;
					} else {
						game = true;
					}
				} while (!game);
				break;
			case 4:
				do {
					System.out.println("Menú de opciones:\n" + "1. Activar/Desactivar confirmación de coordenada\n"
							+ "2. Salir al menú principal");
					opcion = consoleIn.readByteInRange((byte) 1, (byte) 2);
					switch (opcion) {
					case 1:
						if (opciones.isConfirmacion()) {
							opciones.setConfirmacion(false);
							System.out.println("Confirmación desactivada");
						} else {
							opciones.setConfirmacion(true);
							System.out.println("Confirmación activada");
						}
						break;
					case 2:
						exit = true;
					}
				} while (!exit);
				exit = false;
				break;
			}

		} while (!exit);

	}

	public void crearPartida(Jugador jugador1, Jugador jugador2, Opciones opciones) {

	}

}
