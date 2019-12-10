package aplicacion;

import java.io.Serializable;

public class Corazon extends Sorpresa implements Serializable{
/**
 * contructor de la sorpresa corazon
 * @param posX valor en x
 * @param posY valor en y
 */
	public Corazon(int posX, int posY) {
		super(posX, posY);
		super.setTipo("cura");
		imagen="data/corazon.png";
		
	}
	/**
	 * beneficion del corazon
	 */
	@Override
	public int beneficio() {
		return 0;
	}

}
