package goMoku;

public class Juego {

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		tablero.pintarTablero();
		Jugador persona = new Persona(1, "Diego");
		Jugador persona2 = new Persona(2, "Pepe");
		Jugador ia1 = new Ia(1);
		Jugador ia2 = new Ia(2);
		Partida partida = new Partida(persona, ia2, tablero);

	}

}
