package aplicacion;

public class Cereza extends Sorpresa {
	private int puntos;
	
	public Cereza(int posX, int posY) {
		super(posX,posY);
		puntos=10;
		super.setTipo("puntos");
		
	}

	@Override
	public int beneficio() {
		return puntos;
	}
}
