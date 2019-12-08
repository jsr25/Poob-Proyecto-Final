package aplicacion;

public class Corazon extends Sorpresa{
/**
 * contructor de la sorpresa corazon
 * @param posX valor en x
 * @param posY valor en y
 */
	public Corazon(int posX, int posY) {
		super(posX, posY);
		super.setTipo("cura");
		
	}

	@Override
	public int beneficio() {
		return 0;
	}

}
