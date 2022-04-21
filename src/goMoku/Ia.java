package goMoku;

public class Ia extends Jugador {
	Ia(int numJugador) {
		super(numJugador, BaseDeDatos.INSTANCE.getRandomName());
	}

	protected int[] indicarCoordenada(Tablero tablero) {

		return null;
	}
}
