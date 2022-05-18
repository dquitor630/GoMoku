package goMoku;

import java.util.Scanner;

/**
 *  Clase que representa al tablero de la partida.
  * @author Diego Quiros Torres
  * @version 1.0
  * @since 1.0
  * 
 *
 */
public class Tablero {
	/**
	 * Atributo de tipo String en array multidimensional que almacena las fichas.
	 */
	private String[][] tablero = new String[15][15];
	/**
	 * Atributo de tipo String en array multidimensional que almacena el diseño del tablero.
	 */
	private final String[][] coordenadas = {
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" },
			{ "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15" } };
	/**
	 * Teclado para el ConsoleInput.
	 */
	Scanner keyboard = new Scanner(System.in);
	/**
	 * ConsoleInput para introducir datos.
	 */
	ConsoleInput consoleIn = new ConsoleInput(keyboard);
	/**
	 * Atributo de tipo boolean que almacena si el tablero esta terminado.
	 */
	private boolean terminado;
	/**
	 * Atributo que almacena un objeto Opciones con las opciones del usuario.
	 */
	private Opciones opciones;
	/**
	 * Atributo de tipo int que almacena donde se guarda la ultima casilla.
	 */
	public int[] ultimaCasilla = new int[2];

	/**
	 * Metodo que devuelve si la partida esta terminada.
	 * @return boolean
	 */
	public boolean isTerminado() {
		return terminado;
	}

	/**
	 * Constructor de la clase tablero que asigna los puntos al tablero.
	 * @param opciones objeto Opciones de la partida.
	 */
	public Tablero(Opciones opciones) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = ".";
			}
		}
		this.opciones = opciones;
	}

	/**
	 * Metodo exclusivo para utilizarlo en el Junit.
	 * @param coordy int coordenada y para introducir.
	 * @param coordx int coordenada x para introducir.
	 */
	public void modificarJUnit(int coordy, int coordx) {
		tablero[coordy][coordx] = Colors.BLUE + "X" + Colors.RESET;
	}

	/**
	 * Metodo para modificar el tablero.
	 * @param coord int[] que almacena la coordenada donde se pondra la ficha.
	 * @param ficha String que almacena la ficha del jugador que la coloca.
	 * @param className String que almacena el nombre de la clase del jugador para saber si debe confirmar su ficha en caso de que la opcion este activada.
	 * @return boolean
	 */
	public boolean modificarTablero(int[] coord, String ficha, String className) {
		boolean valid = true;
		String fichaRival = "";
		if (ficha.equals(Ficha.FICHA1.getFicha())) {
			fichaRival = Ficha.FICHA2.getFicha();
		} else {
			fichaRival = Ficha.FICHA1.getFicha();
		}
		if (tablero[ultimaCasilla[1]][ultimaCasilla[0]].equals(".")) {
			fichaRival = ".";
		}
		//esto es boolean para verificar que la ficha se ponga correctamente, esto se llamara desde un do while
		if (tablero[coord[1]][coord[0]].equals(".")) { //esto lo hago para verificar que esa casilla no esta utilizada
			if (className.equals("Persona")) { //esto lo hago para no preguntarle a la ia si esta seguro
				if (opciones.isConfirmacion()) {
					tablero[coord[1]][coord[0]] = Colors.RED + ficha.substring(5, 6) + Colors.RESET; //Aquí hacer ficha de color distinto
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					pintarTablero();
					System.out.println("el tablero quedaría tal que así ¿desea confirmar? (s/n)");
					if (consoleIn.readBooleanUsingChar('s', 'n')) {
						tablero[ultimaCasilla[1]][ultimaCasilla[0]] = fichaRival;
						tablero[coord[1]][coord[0]] = Colors.GREEN + ficha.substring(5, 6) + Colors.RESET;
						ultimaCasilla[0] = coord[0];
						ultimaCasilla[1] = coord[1];
						verificarVictoria();
					} else {
						tablero[coord[1]][coord[0]] = ".";
						valid = false;
					}
				} else {
					tablero[ultimaCasilla[1]][ultimaCasilla[0]] = fichaRival;
					tablero[coord[1]][coord[0]] = Colors.GREEN + ficha.substring(5, 6) + Colors.RESET; //poner ficha ya de su color
					ultimaCasilla[0] = coord[0];
					ultimaCasilla[1] = coord[1];
					verificarVictoria();
				}

			} else {
				tablero[ultimaCasilla[1]][ultimaCasilla[0]] = fichaRival;
				tablero[coord[1]][coord[0]] = Colors.GREEN + ficha.substring(5, 6) + Colors.RESET;
				ultimaCasilla[0] = coord[0];
				ultimaCasilla[1] = coord[1];
				verificarVictoria();
			}
			//para que nos de la salida en verde la siguiente
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			pintarTablero();
			//deberiamos verificar aquí si el jugador ha ganado
		} else {
			System.out.println("La coordenada ya esta en uso, introduzca otra distinta");
			valid = false;
		}
		return valid;
	}

	/**
	 * Metodo que verifica si se ha ganado
	 * @return boolean
	 */
	public boolean verificarVictoria() {
		int hor = 1;
		int ver = 1;
		int dia1 = 1;
		int dia2 = 1;
		String ficha = tablero[ultimaCasilla[1]][ultimaCasilla[0]];
		if (ficha.substring(5, 6).equals(Ficha.FICHA1.getFicha().substring(5, 6))) {
			ficha = Ficha.FICHA1.getFicha();
		} else {
			ficha = Ficha.FICHA2.getFicha();
		}
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
			} else {
				exit = true;
			}

			if (tablero[j][i].equals(ficha) && !exit) {
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
			} else {
				exit = true;
			}
			if (tablero[j][i].equals(ficha) && !exit) {
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
			} else {
				exit = true;
			}

			if (tablero[j][i].equals(ficha) && !exit) {
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
			} else {
				exit = true;
			}
			if (tablero[j][i].equals(ficha) && !exit) {
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

	/**
	 * Metodo que cambia el atributo tablero.
	 * @param tablero Tablero con coordenadas nuevas
	 */
	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}

	/**
	 * Metodo que devuelve el tablero.
	 * @return String
	 */
	public String[][] getTablero() {
		return tablero;
	}

	/**
	 * Metodo que devuelve la ultima casilla.
	 * @return int[]
	 */
	public int[] getUltimaCasilla() {
		return ultimaCasilla;
	}

	/**
	 * Metodo que pinta por consola el tablero
	 */
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
