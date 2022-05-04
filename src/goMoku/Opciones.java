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

	Opciones() {
		confirmacion = true;

	}

	public boolean isConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
}
