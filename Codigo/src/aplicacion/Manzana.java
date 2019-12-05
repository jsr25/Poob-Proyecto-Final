package aplicacion;

public class Manzana extends Sorpresa {
	private int puntos;
	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public Manzana(int posX, int posY) {
		super(posX, posY);
		puntos=10;
		super.setTipo("puntos");
	}

	@Override
	public int beneficio() {
		return puntos;
	}

}
