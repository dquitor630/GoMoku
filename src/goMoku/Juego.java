package goMoku;

import java.util.Scanner;

public class Juego {
	//espacios para mejorar la salida de la consola
	public static void main(String[] args) {
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput consoleIn = new ConsoleInput(keyboard);
		Opciones opciones = new Opciones();
		byte opcion;
		final String espacio = "\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
		Jugador ia1;
		Jugador ia2;
		Jugador persona;
		Jugador persona2;
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
				System.out.println(Colors.BLUE + "Introduce el nombre para el jugador 1:" + Colors.RESET);
				persona = new Persona(1, consoleIn.readString());
				System.out.println(Colors.YELLOW + "Introduce el nombre para el jugador 2:" + Colors.RESET);

				persona2 = new Persona(2, consoleIn.readString());
				System.out.println(espacio);
				@SuppressWarnings("unused")
				Partida partida = new Partida(persona, persona2, opciones);
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						System.out.println(espacio);
						partida = new Partida(persona, persona2, opciones);
						game = false;
					} else {
						game = true;
					}
				} while (!game);

				break;
			case 2:
				System.out.println(Colors.BLUE + "Introduce el nombre para el jugador:" + Colors.RESET);
				persona = new Persona(1, consoleIn.readString());
				ia1 = new Ia(2);
				System.out.println(espacio);
				partida = new Partida(persona, ia1, opciones);
				game = false;
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						System.out.println(espacio);
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
				System.out.println(espacio);
				partida = new Partida(ia1, ia2, opciones);
				game = false;
				do {
					System.out.println("¿Volver a jugar? s/n");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						System.out.println(espacio);
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
							+ "2. Activar/Desactivar retraso de la consola\n" + "3. Salir al menú principal");
					opcion = consoleIn.readByteInRange((byte) 1, (byte) 3);
					switch (opcion) {
					case 1:
						if (opciones.isConfirmacion()) {
							opciones.setConfirmacion(false);
							System.out.println(espacio);
							System.out.println("Confirmación desactivada");
						} else {
							opciones.setConfirmacion(true);
							System.out.println(espacio);
							System.out.println("Confirmación activada");
						}
						break;
					case 2:
						if (opciones.getRetrasoConsola() == 1) {
							opciones.setRetrasoConsola(0);
							System.out.println(espacio);
							System.out.println("Retraso Desactivado");
						} else {
							opciones.setRetrasoConsola(1);
							System.out.println(espacio);
							System.out.println("Retraso Activado");
						}
						//añadir modo para daltónicos
						break;
					case 3:
						exit = true;
					}
				} while (!exit);
				exit = false;
				System.out.println(espacio);
				break;
			}

		} while (!exit);

	}

	public void crearPartida(Jugador jugador1, Jugador jugador2, Opciones opciones) {

	}

}
