package goMoku;

public class Juego {

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		tablero.pintarTablero();
		Jugador persona = new Persona(1, "Diego");
		Jugador persona2 = new Persona(2, "Pepe");
		Partida partida = new Partida(persona, persona2, tablero);

	}

}
