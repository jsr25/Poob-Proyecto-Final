package aplicacion;

public class Cereza extends Sorpresa {
	private int puntos;
	
	/**
	 * contructor de la sorpresa cereza
	 * @param posX valor en x
	 * @param posY valor en y
	 */
	public Cereza(int posX, int posY) {
		super(posX,posY);
		puntos=10;
		super.setTipo("puntos");
		imagen="data/cereza.png";
		
	}
	
	
	@Override
	public int beneficio() {
		return puntos;
	}
	
	
}
