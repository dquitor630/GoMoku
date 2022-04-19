package goMoku;

public class Persona extends Jugador {

	@Override
	protected int[] indicarCoordenada() {
		int coord[] = new int[2];
		coord[0] = 2;
		coord[1] = 4;
		return coord;

	}

}
