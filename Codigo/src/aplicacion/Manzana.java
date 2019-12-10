package aplicacion;

import java.io.Serializable;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class Manzana extends Sorpresa implements Serializable {
	private int puntos;
	/**
	 * constructor de la manzana
	 * @param posX posicion en x
	 * @param posY posicion en y
	 */
	public Manzana(int posX, int posY) {
		super(posX, posY);
		puntos=5;
		super.setTipo("puntos");
		imagen="data/manzana.png";
	}
	/**
	 * beneficio de la manzana
	 */
	@Override
	public int beneficio() {
		return puntos;
	}

}
