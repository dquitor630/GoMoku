package goMoku;

import java.util.Random;

public class Ia extends Jugador {
	Ia(int numJugador) {
		super(numJugador, BaseDeDatos.INSTANCE.getRandomName());
	}

	protected int[] indicarCoordenada(Tablero tableroOriginal) {
		int[] values = new int[2];

		int hor = 1;
		int ver = 1;
		int dia1 = 1;
		int dia2 = 1;
		boolean decision = false;
		Random random = new Random();
		int[] ultimaCasilla = tableroOriginal.getUltimaCasilla();
		String[][] tablero = tableroOriginal.getTablero();
		String ficha = tablero[ultimaCasilla[1]][ultimaCasilla[0]];
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
				for (int i = ultimaCasilla[1]; i < 15; i++) {
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
				for (int i = ultimaCasilla[1]; i >= 0; i--) {
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
				for (int i = ultimaCasilla[1]; i < 15; i++) {
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
				for (int i = ultimaCasilla[1]; i >= 0; i--) {
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
				for (int i = ultimaCasilla[1]; i < 15; i++) {
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
				for (int i = ultimaCasilla[1]; i >= 0; i--) {
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
				for (int i = ultimaCasilla[0] + 1; i < 15 && !exit; i++) {
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
				for (int i = ultimaCasilla[0] - 1; i >= 0 && !exit; i--) {
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
			if (!decision) {
				values[0] = random.nextInt(15);
				values[1] = random.nextInt(15);
			}
		} else {
			if (!decision) {
				values[0] = random.nextInt(15);
				values[1] = random.nextInt(15);
			}

		}
		/*Random random = new Random();
		values[0] = random.nextInt(15);
		values[1] = random.nextInt(15);
		*/
		return values;
	}
}
