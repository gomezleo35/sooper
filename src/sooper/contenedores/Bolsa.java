package sooper.contenedores;

import sooper.Caducable;
import sooper.enums.TipoContenedor;

import java.time.LocalDate;

public class Bolsa extends Contenedor implements Caducable {

	private int ancho;
	private LocalDate fechaCompra;

	public Bolsa(String referencia, int alto, int ancho, int resistencia) {
		super(referencia, alto, resistencia);
		this.ancho = ancho;
		this.fechaCompra = LocalDate.now();
	}

	@Override
	public TipoContenedor getTipo() {
		return TipoContenedor.BOLSA;
	}

	@Override
	public int getSuperficie() {
		int radio = getDiametro()/2;
		return (int)(Math.PI * radio * radio);
	}
	
	private int getDiametro() {
		return (int)((2 * ancho) / Math.PI);		
	}


	@Override
	public boolean estaCaducado() {
		return fechaCompra.isBefore(LocalDate.now());
	}
}
