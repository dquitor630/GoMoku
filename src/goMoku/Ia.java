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
		for (int i = ultimaCasilla[0] + 1; i < 15; i++) {
			if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
				hor = hor + 1;
			} else {
				i = 15;
			}
		}
		for (int i = ultimaCasilla[0] - 1; i >= 0; i--) {
			if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
				hor = hor + 1;
			} else {
				i = -1;
			}
		}
		for (int i = ultimaCasilla[1] + 1; i < 15; i++) {
			if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
				ver = ver + 1;
			} else {
				i = 15;
			}
		}
		for (int i = ultimaCasilla[1] - 1; i >= 0; i--) {
			if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
				ver = ver + 1;
			} else {
				i = -1;
			}
		}

		int j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] + 1; i < 15; i++) {
			if (j != 0) {
				j--;
			}

			if (tablero[j][i].equals(ficha)) {
				dia1 = dia1 + 1;
			} else {
				i = 15;
			}
		}

		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] - 1; i >= 0; i--) {
			if (j != 14) {
				j++;
			}
			if (tablero[j][i].equals(ficha)) {
				dia1 = dia1 + 1;
			} else {
				i = -1;
			}
		}

		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] + 1; i < 15; i++) {
			if (j != 14) {
				j++;
			}

			if (tablero[j][i].equals(ficha)) {
				dia2 = dia2 + 1;
			} else {
				i = 15;
			}
		}

		j = ultimaCasilla[1];
		for (int i = ultimaCasilla[0] - 1; i >= 0; i--) {
			if (j != 0) {
				j--;
			}
			if (tablero[j][i].equals(ficha)) {
				dia2 = dia2 + 1;
			} else {
				i = -1;
			}
		}

		if (hor >= 3 || ver >= 3 || dia1 >= 3 || dia2 >= 3) {
			if (hor >= 3) {
				for (int i = ultimaCasilla[0] + 1; i < 15; i++) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".")) {
							values[0] = i;
							values[1] = ultimaCasilla[1];
							decision = true;
						}
						i = 15;
					}
				}
				for (int i = ultimaCasilla[0] - 1; i >= 0; i--) {
					if (tablero[ultimaCasilla[1]][i].equals(ficha)) {
					} else {
						if (!decision && tablero[ultimaCasilla[1]][i].equals(".")) {
							values[0] = i;
							values[1] = ultimaCasilla[1];
							decision = true;
						}
						i = -1;
					}
				}

			}
			if (ver >= 3 && !decision) {
				for (int i = ultimaCasilla[1]; i < 15; i++) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".")) {
							values[1] = i;
							values[0] = ultimaCasilla[0];
							decision = true;
						}
						i = 15;
					}
				}
				for (int i = ultimaCasilla[1]; i >= 0; i--) {
					if (tablero[i][ultimaCasilla[0]].equals(ficha)) {
					} else {
						if (!decision && tablero[i][ultimaCasilla[0]].equals(".")) {
							values[0] = ultimaCasilla[0];
							values[1] = i;
							decision = true;
						}
						i = -1;
					}
				}
			}
			if (!decision) {
				values[0] = random.nextInt(15);
				values[1] = random.nextInt(15);
			}
		} else {
			values[0] = random.nextInt(15);
			values[1] = random.nextInt(15);
		}
		/*Random random = new Random();
		values[0] = random.nextInt(15);
		values[1] = random.nextInt(15);
		*/
		return values;
	}
}
