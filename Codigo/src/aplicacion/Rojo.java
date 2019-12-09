package aplicacion;

import java.io.Serializable;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class Rojo extends Barril implements Serializable{
	
	/**
	 * constructor del barril rojo
	 */
	public Rojo() {
		super();
		x=10;
	}
	

	/**
	 * moviemiento del barril rojo
	 */
	@Override
	public void move() {
		y+=5;
	}
}
