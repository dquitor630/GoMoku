package goMoku;

public class Opciones {
	private boolean confirmacion;

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
