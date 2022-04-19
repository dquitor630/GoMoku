package goMoku;

import java.util.Scanner;

public class Tablero {
	private String[][] tablero = new String[15][15];
	private final String[][] coordenadas = {
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" },
			{ "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15" } };
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);

	Tablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = ".";
			}
		}
	}

	public void modificarTablero(int[] coord, String ficha, String className) {
		//esto lo hago para no preguntarle a la ia si esta seguro
		if (className.equals("Persona")) {
			tablero[coord[1]][coord[0]] = Colors.RED + ficha.substring(5, 6) + Colors.RESET; //Aquí hacer ficha de color distinto
			pintarTablero();
			System.out.println("el tablero quedaría tal que así ¿desea confirmar? (s/n)");
			if (consoleIn.readBooleanUsingChar('s', 'n')) {
				tablero[coord[1]][coord[0]] = ficha; //poner ficha ya de su color
			} else {
				tablero[coord[1]][coord[0]] = ".";
			}
		} else {
			tablero[coord[1]][coord[0]] = ficha;
		}

		pintarTablero();
	}

	public void pintarTablero() {
		System.out.print("   ");
		for (int i = 0; i < coordenadas[0].length; i++) {
			System.out.print(coordenadas[0][i] + " ");
		}
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(coordenadas[1][i] + " ");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
}