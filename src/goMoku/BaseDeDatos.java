package goMoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum BaseDeDatos {
	INSTANCE;

	private List<String> nombres = new ArrayList<>();
	private Random random = new Random();

	private BaseDeDatos() {

		nombres.add("Hernán");
		nombres.add("Matías");
		nombres.add("Rosendo");
		nombres.add("Candelaria");
		nombres.add("Ignacio");
		nombres.add("Wálter");
		nombres.add("Eloy");
		nombres.add("Augusto");
		nombres.add("Elías");
		nombres.add("Ambrosio");
		nombres.add("Martina");
		nombres.add("Carmen");
		nombres.add("Cintia");
		nombres.add("Bruno");
		nombres.add("Eulogio");
		nombres.add("Wilson");
		nombres.add("Amaro");
		nombres.add("Pablo");
		nombres.add("Maria");
		nombres.add("Lola");
		nombres.add("Eva");
		nombres.add("Ana");
		nombres.add("Julio César");
		nombres.add("Gertrudis");
		nombres.add("Gerardo");
		nombres.add("Adolfo");
		nombres.add("Rafael");
		nombres.add("Octavio");
		nombres.add("Hermenegildo");
		nombres.add("Lorenzo");
		nombres.add("Yoselin");
		nombres.add("Sebastián");
		nombres.add("Arturo");
		nombres.add("Fortunato");
		nombres.add("Estrella");
		nombres.add("Ezequiel");
		nombres.add("Justo");
		nombres.add("HTML");
		nombres.add("CSS");
		nombres.add("Java");
		nombres.add("Margin:0;");
		nombres.add("Display:flex;");
		nombres.add("Aura");
		nombres.add("Dionisio");
		nombres.add("Fabio");
		nombres.add("Fibonacci");
		nombres.add("Alexander");
		nombres.add("Adán");
		nombres.add("Maximino");
		nombres.add("Diana");
		nombres.add("Almudena");
		nombres.add("Josué");
		nombres.add("Vanesa");
		nombres.add("Mercedes");
		nombres.add("Adrián");
		nombres.add("Florentino");
		nombres.add("Calixto");
		nombres.add("Custodio");
		nombres.add("Cristián");
		nombres.add("Bernardo");
		nombres.add("Viviana");
		nombres.add("Óscar");
		nombres.add("Zaida");
		nombres.add("Juan Manuel");
		nombres.add("Leandro");
		nombres.add("Hipólito");
		nombres.add("Tatiana");
		nombres.add("Toni");
		nombres.add("Nico");
		nombres.add("Alberto");
		nombres.add("El Truqui");
		nombres.add("Javier");
		nombres.add("Leyre");
		nombres.add("Marcial");
		nombres.add("Fulgencio");
		nombres.add("Baldomero");
		nombres.add("Héctor");
		nombres.add("Cristina");
		nombres.add("Máximo");
		nombres.add("Unai");
		nombres.add("Carlos");
		nombres.add("El Bicho Pelao");
		nombres.add("Marisela");
		nombres.add("Amadeo");
		nombres.add("Gloria");
		nombres.add("Rebeca");
		nombres.add("Dina");
		nombres.add("Juanma");
		nombres.add("Juan Pablo");
		nombres.add("Claudia");
		nombres.add("Elvis");
		nombres.add("Yoel");
		nombres.add("Roque");
		nombres.add("Elisa");
		nombres.add("Judit");
		nombres.add("Agapito");
		nombres.add("Olivia");
		nombres.add("Manolo");
		nombres.add("Iván");
		nombres.add("SuperMachine V2.0");
		nombres.add("Erro404");
		nombres.add("Error de compilación");
		nombres.add("Chollometro");
		nombres.add("Eclipse");
		nombres.add("Git");
		nombres.add("Vinicio");
		nombres.add("Gualberto");
		nombres.add("Redunduncia");
		nombres.add("Clausula Having");
		nombres.add("La Máquina");
		nombres.add("Lalo");
		nombres.add("Virginia");
		nombres.add("Teodosio");
		nombres.add("Torres De Hanoi");
		nombres.add("Francis");
		nombres.add("Mordekaiser");
		nombres.add("Sion");
		nombres.add("Nasus");
		nombres.add("Caballero De La Orden Teutónica");
		nombres.add("Oh Long Jhonson");
		nombres.add("Rodrigo");
		nombres.add("Almagro");

	}

	public String getRandomName() {
		return nombres.get(random.nextInt(nombres.size()));
	}

	public List<String> queryAllNames() {
		return nombres;
	}
}