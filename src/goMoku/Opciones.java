package goMoku;

public class Opciones {
	private boolean confirmacion;
	private int retrasoConsola;

	public int getRetrasoConsola() {
		return retrasoConsola;
	}

	public void setRetrasoConsola(int retrasoConsola) {
		this.retrasoConsola = retrasoConsola;
	}

	public Opciones() {
		confirmacion = true;
		retrasoConsola = 1;

	}

	public boolean isConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
}
