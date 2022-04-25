package goMoku;

import java.util.Scanner;

public class Tablero {
	private String[][] tablero = new String[15][15];
	private final String[][] coordenadas = {
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" },
			{ "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15" } };
	Scanner keyboard = new Scanner(System.in);
	ConsoleInput consoleIn = new ConsoleInput(keyboard);
	private boolean terminado;

	public boolean isTerminado() {
		return terminado;
	}

	public int[] ultimaCasilla = new int[2];

	Tablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = ".";
			}
		}
	}

	public boolean modificarTablero(int[] coord, String ficha, String className) {
		boolean valid = true;
		//esto es boolean para verificar que la ficha se ponga correctamente, esto se llamara desde un do while
		if (tablero[coord[1]][coord[0]].equals(".")) { //esto lo hago para verificar que esa casilla no esta utilizada
			if (className.equals("Persona")) { //esto lo hago para no preguntarle a la ia si esta seguro
				tablero[coord[1]][coord[0]] = Colors.RED + ficha.substring(5, 6) + Colors.RESET; //Aquí hacer ficha de color distinto
				pintarTablero();
				System.out.println("el tablero quedaría tal que así ¿desea confirmar? (s/n)");
				if (consoleIn.readBooleanUsingChar('s', 'n')) {
					tablero[coord[1]][coord[0]] = ficha; //poner ficha ya de su color
					ultimaCasilla[0] = coord[0];
					ultimaCasilla[1] = coord[1];
					verificarVictoria();
				} else {
					tablero[coord[1]][coord[0]] = ".";
					valid = false;
				}
			} else {
				tablero[coord[1]][coord[0]] = ficha;
				ultimaCasilla[0] = coord[0];
				ultimaCasilla[1] = coord[1];
				verificarVictoria();
			}
			//para que nos de la salida en verde la siguiente
			pintarTablero();
			//deberiamos verificar aquí si el jugador ha ganado
		} else {
			System.out.println("La coordenada ya esta en uso, introduzca otra distinta");
			valid = false;
		}
		return valid;
	}

	public boolean verificarVictoria() {
		int hor = 1;
		int ver = 1;
		int dia1 = 1;
		int dia2 = 1;
		String ficha = tablero[ultimaCasilla[1]][ultimaCasilla[0]];
		//esto deberia hacerlo con do while creo, porque realmente no se las veces que 
		//voy a iterar, pero a la vez debo ponerle un limite
		//igual es mejor simplemente poner un if dentro de un do while
		boolean exit = false;
		for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
			if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
				hor = hor + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
			if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
				hor = hor + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = ultimaCasilla[1] + 1; i < 15 && !exit; i++) {
			if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
				ver = ver + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = ultimaCasilla[1] - 1; i >= 0 && !exit; i--) {
			if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
				ver = ver + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		int j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
			if (j != 0) {
				j--;
			}

			if (tablero[j][i].equals(ficha)) {
				dia1 = dia1 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
			if (j != 14) {
				j++;
			}
			if (tablero[j][i].equals(ficha)) {
				dia1 = dia1 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
			if (j != 14) {
				j++;
			}

			if (tablero[j][i].equals(ficha)) {
				dia2 = dia2 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
			if (j != 0) {
				j--;
			}
			if (tablero[j][i].equals(ficha)) {
				dia2 = dia2 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		if (hor >= 5 || ver >= 5 || dia1 >= 5 || dia2 >= 5) {
			terminado = true;
			tablero[ultimaCasilla[1]][ultimaCasilla[0]] = Colors.GREEN + ficha.substring(5, 6) + Colors.RESET;
			return true;
		} else {
			return false;
		}

	}

	public String[][] getTablero() {
		return tablero;
	}

	public int[] getUltimaCasilla() {
		return ultimaCasilla;
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
