package aplicacion;

public class Rojo extends Barril{
	
	/**
	 * 
	 */
	public Rojo() {
		super();
		x=10;
	}
	
	
	@Override
	public void move() {
		y+=5;
	}
}
