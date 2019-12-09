package aplicacion;

import java.io.Serializable;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class Cereza extends Sorpresa implements Serializable {
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
	
	/**
	 * metodo para la obtencion de puntos
	 */
	@Override
	public int beneficio() {
		return puntos;
	}
	
	
}
