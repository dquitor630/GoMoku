package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import goMoku.Colors;
import goMoku.Opciones;
import goMoku.Tablero;

class GoMokuT {
	String x = Colors.BLUE + "X" + Colors.RESET;

	@Test
	void cualquierBordeSuperior1() {
		int[] ultimaCasilla = new int[] { 4, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior2() {
		int[] ultimaCasilla = new int[] { 4, 1 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior3() {
		int[] ultimaCasilla = new int[] { 4, 2 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		tablero.modificarJUnit(2, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior4() {
		int[] ultimaCasilla = new int[] { 4, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		tablero.modificarJUnit(2, 4);
		tablero.modificarJUnit(3, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior5() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		tablero.modificarJUnit(2, 4);
		tablero.modificarJUnit(3, 4);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior6() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		tablero.modificarJUnit(2, 4);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior7() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(1, 4);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeSuperior8() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 4);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior1() {
		int[] ultimaCasilla = new int[] { 4, 14 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior2() {
		int[] ultimaCasilla = new int[] { 4, 13 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(13, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior3() {
		int[] ultimaCasilla = new int[] { 4, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(13, 4);
		tablero.modificarJUnit(12, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior4() {
		int[] ultimaCasilla = new int[] { 4, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(13, 4);
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior5() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(13, 4);
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 4);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierBordeInferior6() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(13, 4);
		tablero.modificarJUnit(11, 4);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior7() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(11, 4);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierBordeInferior8() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 4);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo1() {
		int[] ultimaCasilla = new int[] { 0, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo2() {
		int[] ultimaCasilla = new int[] { 1, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 1);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo3() {
		int[] ultimaCasilla = new int[] { 2, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 1);
		tablero.modificarJUnit(0, 2);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo4() {
		int[] ultimaCasilla = new int[] { 3, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 1);
		tablero.modificarJUnit(0, 2);
		tablero.modificarJUnit(0, 3);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo5() {
		int[] ultimaCasilla = new int[] { 4, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 1);
		tablero.modificarJUnit(0, 2);
		tablero.modificarJUnit(0, 3);
		tablero.modificarJUnit(0, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo6() {
		int[] ultimaCasilla = new int[] { 4, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 2);
		tablero.modificarJUnit(0, 3);
		tablero.modificarJUnit(0, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo7() {
		int[] ultimaCasilla = new int[] { 4, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 3);
		tablero.modificarJUnit(0, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeIzquierdo8() {
		int[] ultimaCasilla = new int[] { 4, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(0, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho1() {
		int[] ultimaCasilla = new int[] { 14, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho2() {
		int[] ultimaCasilla = new int[] { 13, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 13);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho3() {
		int[] ultimaCasilla = new int[] { 12, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 13);
		tablero.modificarJUnit(0, 12);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho4() {
		int[] ultimaCasilla = new int[] { 11, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 13);
		tablero.modificarJUnit(0, 12);
		tablero.modificarJUnit(0, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho5() {
		int[] ultimaCasilla = new int[] { 10, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 13);
		tablero.modificarJUnit(0, 12);
		tablero.modificarJUnit(0, 11);
		tablero.modificarJUnit(0, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho6() {
		int[] ultimaCasilla = new int[] { 10, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		tablero.ultimaCasilla = ultimaCasilla;
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 13);
		tablero.modificarJUnit(0, 11);
		tablero.modificarJUnit(0, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho7() {
		int[] ultimaCasilla = new int[] { 10, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 11);
		tablero.modificarJUnit(0, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierPosicionPegadaAlBordeDerecho8() {
		int[] ultimaCasilla = new int[] { 10, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(0, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral1() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral2() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral3() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 8);
		tablero.modificarJUnit(6, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral4() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 8);
		tablero.modificarJUnit(6, 9);
		tablero.modificarJUnit(6, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral5() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 8);
		tablero.modificarJUnit(6, 9);
		tablero.modificarJUnit(6, 10);
		tablero.modificarJUnit(6, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierCentral6() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 9);
		tablero.modificarJUnit(6, 10);
		tablero.modificarJUnit(6, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral7() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 10);
		tablero.modificarJUnit(6, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral8() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(6, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral9() {
		int[] ultimaCasilla = new int[] { 7, 7 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral10() {
		int[] ultimaCasilla = new int[] { 7, 6 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(6, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral11() {
		int[] ultimaCasilla = new int[] { 7, 5 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(5, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral12() {
		int[] ultimaCasilla = new int[] { 7, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(5, 7);
		tablero.modificarJUnit(4, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral13() {
		int[] ultimaCasilla = new int[] { 7, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(5, 7);
		tablero.modificarJUnit(4, 7);
		tablero.modificarJUnit(3, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierCentral14() {
		int[] ultimaCasilla = new int[] { 7, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(6, 7);
		tablero.modificarJUnit(5, 7);
		tablero.modificarJUnit(3, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral15() {
		int[] ultimaCasilla = new int[] { 7, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(5, 7);
		tablero.modificarJUnit(3, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral16() {
		int[] ultimaCasilla = new int[] { 7, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(7, 7);
		tablero.modificarJUnit(3, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral17() {
		int[] ultimaCasilla = new int[] { 5, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral18() {
		int[] ultimaCasilla = new int[] { 6, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(11, 6);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral19() {
		int[] ultimaCasilla = new int[] { 7, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(11, 6);
		tablero.modificarJUnit(10, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral20() {
		int[] ultimaCasilla = new int[] { 8, 9 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(11, 6);
		tablero.modificarJUnit(10, 7);
		tablero.modificarJUnit(9, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral21() {
		int[] ultimaCasilla = new int[] { 9, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(11, 6);
		tablero.modificarJUnit(10, 7);
		tablero.modificarJUnit(9, 8);
		tablero.modificarJUnit(8, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierCentral22() {
		int[] ultimaCasilla = new int[] { 9, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(10, 7);
		tablero.modificarJUnit(9, 8);
		tablero.modificarJUnit(8, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral23() {
		int[] ultimaCasilla = new int[] { 9, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(9, 8);
		tablero.modificarJUnit(8, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral24() {
		int[] ultimaCasilla = new int[] { 9, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 5);
		tablero.modificarJUnit(8, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral25() {
		int[] ultimaCasilla = new int[] { 12, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral26() {
		int[] ultimaCasilla = new int[] { 11, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral27() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral28() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(9, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral29() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(9, 9);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierCentral30() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(9, 9);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral31() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(9, 9);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral32() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cuaquierCentral33() {
		int[] ultimaCasilla = new int[] { 4, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral34() {
		int[] ultimaCasilla = new int[] { 5, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 5);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral35() {
		int[] ultimaCasilla = new int[] { 6, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 5);
		tablero.modificarJUnit(10, 6);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral36() {
		int[] ultimaCasilla = new int[] { 7, 9 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 5);
		tablero.modificarJUnit(10, 6);
		tablero.modificarJUnit(9, 7);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral37() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 5);
		tablero.modificarJUnit(10, 6);
		tablero.modificarJUnit(9, 7);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void cualquierCentral38() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(11, 5);
		tablero.modificarJUnit(9, 7);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral39() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(9, 7);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral40() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 4);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral41() {
		int[] ultimaCasilla = new int[] { 12, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualqueirCentral42() {
		int[] ultimaCasilla = new int[] { 11, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral43() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void cualquierCentral44() {
		int[] ultimaCasilla = new int[] { 9, 9 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(9, 9);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	void cualquierCentral45() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(9, 9);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	void cualquierCentral46() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(9, 9);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	void cualquierCentral47() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(10, 10);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	void cualquierCentral48() {
		int[] ultimaCasilla = new int[] { 8, 8 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(8, 8);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda1() {
		int[] ultimaCasilla = new int[] { 0, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda2() {
		int[] ultimaCasilla = new int[] { 1, 1 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(1, 1);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda3() {
		int[] ultimaCasilla = new int[] { 2, 2 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(1, 1);
		tablero.modificarJUnit(2, 2);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda4() {
		int[] ultimaCasilla = new int[] { 3, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(1, 1);
		tablero.modificarJUnit(2, 2);
		tablero.modificarJUnit(3, 3);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda5() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(1, 1);
		tablero.modificarJUnit(2, 2);
		tablero.modificarJUnit(3, 3);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda6() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(1, 1);
		tablero.modificarJUnit(2, 2);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda7() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(2, 2);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorIzquierda8() {
		int[] ultimaCasilla = new int[] { 4, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 0);
		tablero.modificarJUnit(4, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha1() {
		int[] ultimaCasilla = new int[] { 14, 0 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha2() {
		int[] ultimaCasilla = new int[] { 13, 1 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(1, 13);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha3() {
		int[] ultimaCasilla = new int[] { 12, 2 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(1, 13);
		tablero.modificarJUnit(2, 12);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha4() {
		int[] ultimaCasilla = new int[] { 11, 3 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(1, 13);
		tablero.modificarJUnit(2, 12);
		tablero.modificarJUnit(3, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha5() {
		int[] ultimaCasilla = new int[] { 10, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(1, 13);
		tablero.modificarJUnit(2, 12);
		tablero.modificarJUnit(3, 11);
		tablero.modificarJUnit(4, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha6() {
		int[] ultimaCasilla = new int[] { 10, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(2, 12);
		tablero.modificarJUnit(3, 11);
		tablero.modificarJUnit(4, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha7() {
		int[] ultimaCasilla = new int[] { 10, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(2, 12);
		tablero.modificarJUnit(4, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaSuperiorDerecha8() {
		int[] ultimaCasilla = new int[] { 10, 4 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(0, 14);
		tablero.modificarJUnit(4, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda1() {
		int[] ultimaCasilla = new int[] { 0, 14 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda2() {
		int[] ultimaCasilla = new int[] { 1, 13 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(13, 1);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda3() {
		int[] ultimaCasilla = new int[] { 2, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(13, 1);
		tablero.modificarJUnit(12, 2);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda4() {
		int[] ultimaCasilla = new int[] { 3, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(13, 1);
		tablero.modificarJUnit(12, 2);
		tablero.modificarJUnit(11, 3);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda5() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(13, 1);
		tablero.modificarJUnit(12, 2);
		tablero.modificarJUnit(11, 3);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda6() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(12, 2);
		tablero.modificarJUnit(11, 3);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda7() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(12, 2);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorIzquierda8() {
		int[] ultimaCasilla = new int[] { 4, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 0);
		tablero.modificarJUnit(10, 4);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha1() {
		int[] ultimaCasilla = new int[] { 14, 14 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha2() {
		int[] ultimaCasilla = new int[] { 13, 13 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha3() {
		int[] ultimaCasilla = new int[] { 12, 12 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		tablero.modificarJUnit(12, 12);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha4() {
		int[] ultimaCasilla = new int[] { 11, 11 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha5() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		tablero.modificarJUnit(12, 12);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(true, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha6() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		tablero.modificarJUnit(11, 11);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha7() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(13, 13);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

	@Test
	void esquinaInferiorDerecha8() {
		int[] ultimaCasilla = new int[] { 10, 10 };
		Opciones opciones = new Opciones();
		Tablero tablero = new Tablero(opciones);
		//me da igual que apunten a la misma dirección, sirve igual
		tablero.ultimaCasilla = ultimaCasilla;
		tablero.modificarJUnit(14, 14);
		tablero.modificarJUnit(10, 10);
		boolean equalityDescription = tablero.verificarVictoria();
		assertEquals(false, equalityDescription);
	}

}
