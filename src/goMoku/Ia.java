package goMoku;

import java.util.Random;

public class Ia extends Jugador {
	Ia(int numJugador) {
		super(numJugador, BaseDeDatos.INSTANCE.getRandomName());
	}

	protected int[] indicarCoordenada(Tablero tablero) {
		Random random = new Random();
		int[] values = new int[2];
		values[0] = random.nextInt(15);
		values[1] = random.nextInt(15);
		return values;
	}
}
