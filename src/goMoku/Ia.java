package goMoku;

public class Ia extends Jugador {
	Ia() {
		nombre = BaseDeDatos.INSTANCE.getRandomName();
	}

	@Override
	protected int[] indicarCoordenada() {

		return null;
	}
}
