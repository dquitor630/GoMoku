package goMoku;

public abstract class Jugador {
	protected String nombre;
	private String ficha = "X";

	protected abstract int[] indicarCoordenada();

	public String getFicha() {
		return ficha;
	}
}
