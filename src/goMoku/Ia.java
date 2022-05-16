package goMoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *  Clase hija de jugador que representa la inteligencia artificial.
  * @author Diego Quiros Torres
  * @version 1.0
  * @since 1.0
  * @see Jugador
  * 
 *
 */
public class Ia extends Jugador {
	/**
	 * Atributo de tipo int que almacena uno de los lados del ataque.
	 */
	private int lado1 = 0;
	/**
	 * Atributo de tipo int que almacena uno de los lados del ataque.
	 */
	private int lado2 = 0;
	/**
	 * Atributo de tipo String que almacena la direccion del ataque actual.
	 */
	private String tipoAtaque = "";
	/**
	 * ArrayList de tipo int que almacena las coordenadas del ataque.
	 */
	private ArrayList<int[]> rangoAtaque = new ArrayList<>();

	/**
	 * Constructor de la clase ia.
	 * @param numJugador int del Numero del jugador.
	 */
	Ia(int numJugador) {
		super(numJugador, BaseDeDatos.INSTANCE.getRandomName());
	}

	/**
	 * Metodo de la ia para calcular la coordenada, realizando segun que situacion un ataque o una defensa.
	 * @param tableroOriginal objeto Tablero actual de la partida.
	 * @return int[]
	 */
	protected int[] indicarCoordenada(Tablero tableroOriginal) {
		int[] values = new int[2];
		int hor = 1;
		int ver = 1;
		int dia1 = 1;
		int dia2 = 1;
		int intentos = 0;
		int storedRandom = 0;
		boolean nAtaque = true;
		boolean decision = false;
		int[] ataqueInicial = new int[2];
		Random random = new Random();
		int[] ultimaCasilla = tableroOriginal.getUltimaCasilla();
		String[][] tablero = tableroOriginal.getTablero();
		String ficha = tablero[ultimaCasilla[1]][ultimaCasilla[0]];
		String fichaVerde = tablero[ultimaCasilla[1]][ultimaCasilla[0]];
		boolean exit = false;
		if (!(ficha.equals("."))) {
			if (ficha.substring(5, 6).equals(Ficha.FICHA1.getFicha().substring(5, 6))) {
				ficha = Ficha.FICHA1.getFicha();
			} else {
				ficha = Ficha.FICHA2.getFicha();
			}
		}
		tablero[ultimaCasilla[1]][ultimaCasilla[0]] = ficha;
		if (!(rangoAtaque.size() == 0)) {
			nAtaque = validarAtaque(tableroOriginal, ultimaCasilla, ficha, fichaVerde);
		}
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
		if (hor == 1 || ver == 1 || dia1 == 1 || dia2 == 1) {
			if (hor >= 1 && hor >= ver && hor >= dia1 && hor >= dia2 && !decision) { //programar que tenga prioridades segun situación
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".") && i < 13) {
							if (tablero[ultimaCasilla[1]][i + 1].equals(ficha)) {
								values[0] = i;
								values[1] = ultimaCasilla[1];
								decision = true;
							}

						}
						exit = true;
					}
				}
				exit = false;
				for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".") && i > 1) {
							if (tablero[ultimaCasilla[1]][i - 1].equals(ficha)) {
								values[0] = i;
								values[1] = ultimaCasilla[1];
								decision = true;
							}
						}
						exit = true;
					}
				}
				exit = false;
			}
			if (ver == 1 && !decision && ver >= hor && ver >= dia1 && ver >= dia2) {
				for (int i = ultimaCasilla[1]; i < 15 && !exit; i++) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".") && i < 13) {
							if (tablero[i + 1][ultimaCasilla[0]].equals(ficha)) {
								values[1] = i;
								values[0] = ultimaCasilla[0];
								decision = true;
							}

						}
						exit = true;
					}
				}
				exit = false;
				for (int i = ultimaCasilla[1]; i >= 0 && !exit; i--) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".") && i > 1) {
							if (tablero[i - 1][ultimaCasilla[0]].equals(ficha)) {
								values[1] = i;
								values[0] = ultimaCasilla[0];
								decision = true;
							}
						}
						exit = true;
					}
				}
				exit = false;
			}
			if (dia1 >= 1 && !decision && dia1 >= hor && dia1 >= ver && dia1 >= dia2) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (j != 0) {
						j--;
					}

					if (tablero[j][i].equals(ficha)) {
					} else {
						if (!decision && tablero[j][i].equals(".") && j < 13 && i > 1) {
							if (tablero[j + 1][i - 1].equals(ficha) && tablero[j + 2][i - 2].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}

						}
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
					} else {
						if (!decision && tablero[j][i].equals(".") && j > 1 && i < 13) {
							if (tablero[j - 1][i + 1].equals(ficha) && tablero[j - 2][i + 2].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}

						}
						exit = true;
					}
				}
				exit = false;
			}
			if (dia2 >= 1 && !decision && dia2 >= hor && dia2 >= ver && dia2 >= dia1) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (j != 14) {
						j++;
					}
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (!decision && tablero[j][i].equals(".") && j < 13 && i < 13) {
							if (tablero[j + 1][i + 1].equals(ficha) && tablero[j + 2][i + 2].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}
						}
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
					} else {
						if (!decision && tablero[j][i].equals(".") && j > 1 && i > 1) {
							if (tablero[j - 1][i - 1].equals(ficha) && tablero[j - 2][i - 2].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}
						}
						exit = true;
					}
				}
				exit = false;
			}

		}
		if (hor == 2 || ver == 2 || dia1 == 2 || dia2 == 2) {
			if (hor >= 2 && hor >= ver && hor >= dia1 && hor >= dia2 && !decision) { //programar que tenga prioridades segun situación
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".") && i != 14) {
							if (tablero[ultimaCasilla[1]][i + 1].equals(ficha)) {
								values[0] = i;
								values[1] = ultimaCasilla[1];
								decision = true;
							}

						}
						exit = true;
					}
				}
				exit = false;
				for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".") && i != 0) {
							if (tablero[ultimaCasilla[1]][i - 1].equals(ficha)) {
								values[0] = i;
								values[1] = ultimaCasilla[1];
								decision = true;
							}
						}
						exit = true;
					}
				}
				exit = false;
			}
			if (ver == 2 && !decision && ver >= hor && ver >= dia1 && ver >= dia2) {
				for (int i = ultimaCasilla[1]; i < 15 && !exit; i++) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".") && i != 14) {
							if (tablero[i + 1][ultimaCasilla[0]].equals(ficha)) {
								values[1] = i;
								values[0] = ultimaCasilla[0];
								decision = true;
							} else {
								exit = true;
							}
						}
					}
				}
				exit = false;
				for (int i = ultimaCasilla[1]; i >= 0 && !exit; i--) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".") && i != 0) {
							if (tablero[i - 1][ultimaCasilla[0]].equals(ficha)) {
								values[1] = i;
								values[0] = ultimaCasilla[0];
								decision = true;
							} else {
								exit = true;
							}
						}
					}
				}
				exit = false;
			}
			if (dia1 >= 2 && !decision && dia1 >= hor && dia1 >= ver && dia1 >= dia2) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (j != 0) {
						j--;
					}
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (!decision && tablero[j][i].equals(".") && j != 14 && i != 0) {
							if (tablero[j + 1][i - 1].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}

						}
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
					} else {
						if (!decision && tablero[j][i].equals(".") && j != 0 && i != 14) {
							if (tablero[j - 1][i + 1].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}

						}
						exit = true;
					}
				}
				exit = false;
			}
			if (dia2 >= 2 && !decision && dia2 >= hor && dia2 >= ver && dia2 >= dia1) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (j != 14) {
						j++;
					}
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (!decision && tablero[j][i].equals(".") && j != 14 && i != 14) {
							if (tablero[j + 1][i + 1].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}
						}
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
					} else {

						if (!decision && tablero[j][i].equals(".") && j != 0 && i != 0) {
							if (tablero[j - 1][i - 1].equals(ficha)) {
								values[0] = i;
								values[1] = j;
								decision = true;
							}
						}
						exit = true;
					}
				}
				exit = false;
			}
		}
		if (hor >= 3 || ver >= 3 || dia1 >= 3 || dia2 >= 3) {
			if (hor >= 3 && hor >= ver && hor >= dia1 && hor >= dia2) { //programar que tenga prioridades segun situación
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".")) {
							values[0] = i;
							values[1] = ultimaCasilla[1];
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
				for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".")) {
							values[0] = i;
							values[1] = ultimaCasilla[1];
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
			}
			if (ver >= 3 && !decision && ver >= hor && ver >= dia1 && ver >= dia2) {
				for (int i = ultimaCasilla[1]; i < 15 && !exit; i++) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".")) {
							values[1] = i;
							values[0] = ultimaCasilla[0];
							decision = true;
						} else {
							exit = true;
						}
					}
				}
				exit = false;
				for (int i = ultimaCasilla[1]; i >= 0 && !exit; i--) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".")) {
							values[0] = ultimaCasilla[0];
							values[1] = i;
							decision = true;
						} else {
							exit = true;
						}
					}
				}
				exit = false;
			}
			if (dia1 >= 3 && !decision && dia1 >= hor && dia1 >= ver && dia1 >= dia2) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0]; i < 15 && !exit; i++) {
					if (tablero[j][i].equals(ficha)) {

					} else {
						if (i >= 2 && j <= 13) {
							i = i - 2;
							j = j + 1;
						}
						if (!decision && tablero[j][i].equals(".")) {
							values[0] = i;
							values[1] = j;
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (i <= 12 && j >= 1) {
							i = i + 2;
							j = j - 1;
						}
						if (!decision && tablero[j][i].equals(".")) {
							values[0] = i;
							values[1] = j;
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
			}
			if (dia2 >= 3 && !decision && dia2 >= hor && dia2 >= ver && dia2 >= dia1) {
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0]; i < 15 && !exit; i++) {
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (j <= 13) {
							j = j + 1;
						}

						if (!decision && tablero[j][i].equals(".")) {
							values[0] = i;
							values[1] = j;
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
				j = ultimaCasilla[1];
				for (int i = ultimaCasilla[0]; i >= 0 && !exit; i--) {
					if (tablero[j][i].equals(ficha)) {
					} else {
						if (j >= 1) {
							j = j - 1;
						}

						if (!decision && tablero[j][i].equals(".")) {
							values[0] = i;
							values[1] = j;
							decision = true;
						}
						exit = true;
					}
				}
				exit = false;
			}
		}
		if (!decision) {
			hor = 1;
			ver = 1;
			do {
				if (nAtaque) {
					rangoAtaque.clear();
					values[0] = random.nextInt(15);
					values[1] = random.nextInt(15);
					hor = 1;
					ver = 1;
					lado1 = 0;
					lado2 = 0;
					ver = validarVertical(values, ver, tablero);
					lado1 = 0;
					lado2 = 0;
					hor = validarHorizontal(values, hor, tablero);
					if (hor >= 5 && ver >= 5) {
						switch (random.nextInt(2)) {
						case 0:
							tipoAtaque = "ver";
							break;
						case 1:
							tipoAtaque = "hor";
							break;
						}
					} else if (hor >= 5) {
						tipoAtaque = "hor";
					} else if (ver >= 5) {
						tipoAtaque = "ver";
					}
					if (tipoAtaque.equals("ver")) {
						lado1 = 0;
						lado2 = 0;
						ver = 1;
						ver = validarVertical(values, ver, tablero);
						ataqueInicial[0] = values[0];
						ataqueInicial[1] = values[1];
						rangoAtaque.add(values);
						for (int i = 1; i <= lado1; i++) {
							if (i > lado1) {

							} else {
								values[1] = ataqueInicial[1] + i;
								rangoAtaque.add(Arrays.copyOf(values, 2));
							}

						}
						for (int i = lado2; i > 0; i--) {
							values[1] = ataqueInicial[1] - i;
							rangoAtaque.add(Arrays.copyOf(values, 2));
						}
						if (rangoAtaque.size() < 5) {
							System.out.println();
						}
						values[0] = ataqueInicial[0];
						values[1] = ataqueInicial[1];
						decision = true;
						nAtaque = false;
					}
					if (tipoAtaque.equals("hor")) {
						lado1 = 0;
						lado2 = 0;
						hor = 1;
						validarHorizontal(values, hor, tablero);
						ataqueInicial[0] = values[0];
						ataqueInicial[1] = values[1];
						rangoAtaque.add(values);
						for (int i = 1; i <= lado1; i++) {
							if (i > lado1) {
							} else {
								values[0] = ataqueInicial[0] + i;
								rangoAtaque.add(Arrays.copyOf(values, 2));
							}
						}
						for (int i = lado2; i > 0; i--) {
							values[0] = ataqueInicial[0] - i;
							rangoAtaque.add(Arrays.copyOf(values, 2));
						}
						if (rangoAtaque.size() < 5) {
							System.out.println();
						}
						values[0] = ataqueInicial[0];
						values[1] = ataqueInicial[1];
						decision = true;
						nAtaque = false;
						intentos++;
					}
				} else {
					do {
						storedRandom = random.nextInt(rangoAtaque.size());
						values[1] = rangoAtaque.get(storedRandom)[1];
						values[0] = rangoAtaque.get(storedRandom)[0];
						if (tablero[values[1]][values[0]].equals(this.getFicha())) {
							exit = false;
						} else {
							exit = true;
							decision = true;
						}

					} while (!exit);
					exit = false;
				}
			} while (!decision && intentos <= 30);
			if (!decision && intentos >= 30) {
				values[0] = random.nextInt(15);
				values[0] = random.nextInt(15);
				intentos = 0;
			} else {
				intentos = 0;
			}
		}

		decision = false;
		/*Random random = new Random();
		values[0] = random.nextInt(15);
		values[1] = random.nextInt(15);
		*/
		return values;
	}

	/**
	 * Valida que el ataque actual puede continuarse.
	 * @param tablero objeto Tablero actual de la partida.
	 * @param ultimaCasilla int[] de la Ultima casilla utilizada.
	 * @param ficha Cadena de la ficha del jugador.
	 * @param fichaVerde Cadena de la ficha del jugador.
	 * @return
	 */
	public boolean validarAtaque(Tablero tablero, int[] ultimaCasilla, String ficha, String fichaVerde) {
		boolean result = false;
		for (int i = 0; i < rangoAtaque.size() && !result; i++) {
			if (tablero.getTablero()[rangoAtaque.get(i)[1]][rangoAtaque.get(i)[0]].equals(ficha)
					|| tablero.getTablero()[rangoAtaque.get(i)[1]][rangoAtaque.get(i)[0]].equals(fichaVerde)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * valida que se puede realizar un ataque horizontal.
	 * @param values int[] de la Coordenada escogida al azar de la que partiremos.
	 * @param hor int del Numero de fichas encadenadas horizontalmente.
	 * @param tablero objeto Tablero de la partida.
	 * @return int
	 */

	public int validarHorizontal(int[] values, int hor, String[][] tablero) {
		boolean exit = false;
		for (int i = values[0] + 1; i <= 14 && !exit; i++) {
			if (tablero[values[1]][i].equals(".") && hor < 5) {
				if (i < 15) {
					hor = hor + 1;
					lado1 = lado1 + 1;
				}
			} else if (tablero[values[1]][i].equals(this.getFicha()) && hor < 5) {
				if (i < 15) {
					hor = hor + 1;
					lado1 = lado1 + 1;
				}
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = values[0] - 1; i >= 0 && hor < 5; i--) {
			if (tablero[values[1]][i].equals(".") && hor < 5) {
				hor = hor + 1;
				lado2 = lado2 + 1;
			} else if (tablero[values[1]][i].equals(this.getFicha()) && hor < 5) {
				hor = hor + 1;
				lado2 = lado2 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		return hor;
	}

	/**
	 * valida que se puede realizar un ataque vertical.
	 * @param values int[] de la Coordenada escogida al azar de la que partiremos.
	 * @param ver int del Numero de fichas encadenadas verticalmente.
	 * @param tablero String[][] del  Tablero de la partida.
	 * @return int
	 */
	public int validarVertical(int[] values, int ver, String[][] tablero) {
		boolean exit = false;
		for (int i = values[1] + 1; i <= 14 && !exit; i++) {
			if (tablero[i][values[0]].equals(".") && ver < 5) {
				if (i < 15) {
					ver = ver + 1;
					lado1 = lado1 + 1;
				}
			} else if (tablero[i][values[0]].equals(this.getFicha()) && ver < 5) {
				if (i < 15) {
					ver = ver + 1;
					lado1 = lado1 + 1;
				}
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = values[1] - 1; i >= 0 && ver < 5; i--) {
			if (tablero[i][values[0]].equals(".") && ver < 5) {
				ver = ver + 1;
				lado2 = lado2 + 1;
			} else if (tablero[i][values[0]].equals(this.getFicha()) && ver < 5) {
				ver = ver + 1;
				lado2 = lado2 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		return ver;
	}

}
