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
		puntos=10;
		super.setTipo("puntos");
	}
	/**
	 * beneficio de la manzana
	 */
	@Override
	public int beneficio() {
		return puntos;
	}

}
