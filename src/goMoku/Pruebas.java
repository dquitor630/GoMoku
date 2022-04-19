package goMoku;

public class Pruebas {

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		tablero.pintarTablero();
		Jugador persona = new Persona();
		tablero.modificarTablero(persona.indicarCoordenada(), persona.getFicha(), persona.getClass().getSimpleName());
	}

}
