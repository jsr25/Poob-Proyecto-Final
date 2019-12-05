package aplicacion;

public class Cereza extends Sorpresa {
	private int puntos;
	
	/**
	 * 
	 * @param posX
	 * @param posY
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
