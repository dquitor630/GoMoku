package goMoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ia extends Jugador {
	private int lado1 = 0;
	private int lado2 = 0;
	int numOpciones = 0;
	private ArrayList<int[]> rangoAtaque = new ArrayList<>();

	Ia(int numJugador) {
		super(numJugador, BaseDeDatos.INSTANCE.getRandomName());
	}

	protected int[] indicarCoordenada(Tablero tableroOriginal) {
		int[] values = new int[2];
		int hor = 1;
		int ver = 1;
		int dia1 = 1;
		int dia2 = 1;
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
							if (tablero[ultimaCasilla[1]][i + 1].equals(ficha)
									&& tablero[ultimaCasilla[1]][i + 2].equals(ficha)) {
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
							if (tablero[ultimaCasilla[1]][i - 1].equals(ficha)
									&& tablero[ultimaCasilla[1]][i - 2].equals(ficha)) {
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
							if (tablero[i + 1][ultimaCasilla[0]].equals(ficha)
									&& tablero[i + 2][ultimaCasilla[0]].equals(ficha)) {
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
							if (tablero[i - 1][ultimaCasilla[0]].equals(ficha)
									&& tablero[i - 2][ultimaCasilla[0]].equals(ficha)) {
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
							}

						}
						exit = true;
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
							}
						}
						exit = true;
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
						}
						exit = true;
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
						}
						exit = true;
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
					hor = validarHorizontal(values, hor, tablero);

					if (hor >= 5) {
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
			} while (!decision);
		}

		decision = false;
		/*Random random = new Random();
		values[0] = random.nextInt(15);
		values[1] = random.nextInt(15);
		*/
		return values;
	}

	public boolean validarAtaque(Tablero tablero, int[] ultimaCasilla, String ficha, String fichaVerde) {
		boolean result = false;
		for (int i = 0; i < rangoAtaque.size() && !result; i++) {
			System.out.println(rangoAtaque.get(i)[0]);
			if (tablero.getTablero()[rangoAtaque.get(i)[1]][rangoAtaque.get(i)[0]].equals(ficha)
					|| tablero.getTablero()[rangoAtaque.get(i)[1]][rangoAtaque.get(i)[0]].equals(fichaVerde)) {
				result = true;
			}
		}
		return result;
	}

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

	public int validarVertical(int[] values, int ver, String[][] tablero) {
		boolean exit = false;
		for (int i = values[0] + 1; i <= 14 && !exit; i++) {
			if (tablero[values[1]][i].equals(".") && ver < 5) {
				if (i < 15) {
					ver = ver + 1;
					lado1 = lado1 + 1;
				}
			} else if (tablero[values[1]][i].equals(this.getFicha()) && ver < 5) {
				if (i < 15) {
					ver = ver + 1;
					lado1 = lado1 + 1;
				}
			} else {
				exit = true;
			}
		}
		exit = false;
		for (int i = values[0] - 1; i >= 0 && ver < 5; i--) {
			if (tablero[values[1]][i].equals(".") && ver < 5) {
				ver = ver + 1;
				lado2 = lado2 + 1;
			} else if (tablero[values[1]][i].equals(this.getFicha()) && ver < 5) {
				ver = ver + 1;
				lado2 = lado2 + 1;
			} else {
				exit = true;
			}
		}
		exit = false;
		return ver;
	}

	public void ataque() {
		/* if (!decision) {
			do {
				if (tipoAtaque.equals("")) {
					hor = 1;
					exit = false;
					do {
						values[0] = random.nextInt(15);
						values[1] = random.nextInt(15);
						lado1 = 0;
						lado2 = 0;
						for (int i = values[0]; i <= 14 && !exit; i++) {
							if (tablero[1][i].equals(".") && hor < 5) {
								hor = hor + 1;
								lado1 = lado1 + 1;
							} else if (tablero[1][i].equals(this.getFicha()) && hor < 5) {
								hor = hor + 1;
								lado1 = lado1 + 1;
							} else {
								exit = true;
							}
						}
						exit = false;
						for (int i = values[0]; i >= 0 && hor < 5; i--) {
							if (tablero[1][i].equals(".") && hor < 5) {
								hor = hor + 1;
								lado2 = lado2 + 1;
							} else if (tablero[1][i].equals(this.getFicha()) && hor < 5) {
								hor = hor + 1;
								lado2 = lado2 + 1;
							} else {
								exit = true;
							}
						}
						exit = false;
						if (hor >= 5) {
							decision = true;
							tipoAtaque = "hor";
							cantidadAtaque++;
							ultimoAtaque[0] = values[0];
							ultimoAtaque[1] = values[1];
							ataqueInicial[0] = values[0];
							ataqueInicial[1] = values[1];
						}
					} while (!decision);
				} else {
					switch (tipoAtaque) {
					case "hor":
						if (ultimoAtaque[0] != 14) {
							if (tablero[ultimoAtaque[1]][ultimoAtaque[0] + 1].equals(".")
									|| tablero[ultimoAtaque[1]][ultimoAtaque[0] + 1].equals(this.getFicha())
											&& lado1 > 0 && !decision) {
								if (tablero[ultimoAtaque[1]][ultimoAtaque[0] + 1].equals(this.getFicha())) {
									if (lado1 == 2) {
										lado1 = lado1 - 2;
										if (ultimoAtaque[0] != 13) {
											if (tablero[ultimoAtaque[1]][ultimoAtaque[0] + 2].equals(".")) {
												values[1] = ultimoAtaque[1];
												values[0] = ultimoAtaque[0] + 2;
												ultimoAtaque[0] = values[0];
												ultimoAtaque[1] = values[1];
												decision = true;
		
											}
										}
		
									}
								} else {
									values[1] = ultimoAtaque[1];
									values[0] = ultimoAtaque[0] + 1;
									ultimoAtaque[0] = values[0];
									ultimoAtaque[1] = values[1];
									lado1--;
									decision = true;
								}
		
								if (lado1 == 0) {
									ultimoAtaque[0] = ataqueInicial[0];
									ultimoAtaque[1] = ataqueInicial[1];
								}
		
							}
		
						}
						if (ultimoAtaque[0] != 0) {
							if (tablero[ultimoAtaque[1]][ultimoAtaque[0] - 1].equals(".")
									|| tablero[ultimoAtaque[1]][ultimoAtaque[0] - 1].equals(this.getFicha())
											&& lado2 > 0 && !decision) {
								if (tablero[ultimoAtaque[1]][ultimoAtaque[0] - 1].equals(this.getFicha())) {
									if (lado2 == 2) {
										if (ultimoAtaque[0] > 1) {
											if (tablero[ultimoAtaque[1]][ultimoAtaque[0] - 2].equals(this.getFicha())) {
												lado2 = lado2 - 2;
												values[1] = ultimoAtaque[1];
												values[0] = ultimoAtaque[0] - 2;
												ultimoAtaque[0] = values[0];
												ultimoAtaque[1] = values[1];
												decision = true;
											}
										}
		
									}
								} else {
									values[1] = ultimoAtaque[1];
									values[0] = ultimoAtaque[0] - 1;
									ultimoAtaque[0] = values[0];
									ultimoAtaque[1] = values[1];
									lado2--;
									decision = true;
								}
							}
						}
						if (decision) {
							cantidadAtaque++;
						}
						if (!decision) {
							tipoAtaque = "";
							cantidadAtaque = 0;
						}
						break;
					}
				}
			} while (!decision);
		}*/
	}
}
