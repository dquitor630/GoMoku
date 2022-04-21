package goMoku;

public enum Ficha {

	FICHA1(Colors.BLUE + "X" + Colors.RESET), FICHA2(Colors.YELLOW + "O" + Colors.RESET);

	protected final String ficha;

	public String getFicha() {
		return this.ficha;
	}

	private Ficha(String ficha) {
		this.ficha = ficha;
	}
}
