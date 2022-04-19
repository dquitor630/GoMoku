package goMoku;

public class Persona extends Jugador {

	@Override
	protected int[] indicarCoordenada() {
		boolean exit;
		int[] result = new int[2];
		System.out.println("Introduce la Coordenada X (a-o)");
		do {
			exit = true;
			switch (Character.toLowerCase(consoleIn.readChar())) {
			case 'a':
				result[0] = 0;
				break;
			case 'b':
				result[0] = 1;
				break;
			case 'c':
				result[0] = 2;
				break;
			case 'd':
				result[0] = 3;
				break;
			case 'e':
				result[0] = 4;
				break;
			case 'f':
				result[0] = 5;
				break;
			case 'g':
				result[0] = 6;
				break;
			case 'h':
				result[0] = 7;
				break;
			case 'i':
				result[0] = 8;
				break;
			case 'j':
				result[0] = 9;
				break;
			case 'k':
				result[0] = 10;
				break;
			case 'l':
				result[0] = 11;
				break;
			case 'm':
				result[0] = 12;
				break;
			case 'n':
				result[0] = 13;
				break;
			case 'o':
				result[0] = 14;
				break;
			default:
				exit = false;
				System.out.println("Has introducido una coordenada no válida, vuelve a introducirla");
			}
		} while (!exit);
		System.out.println("Introduce la coordenada Y (1-15)");
		result[1] = consoleIn.readIntInRange(1, 15) - 1;
		return result;
	}

}
