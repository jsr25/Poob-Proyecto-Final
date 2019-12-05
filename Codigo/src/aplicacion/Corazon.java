package aplicacion;

public class Corazon extends Sorpresa{

	public Corazon(int posX, int posY) {
		super(posX, posY);
		super.setTipo("cura");
		
	}

	@Override
	public int beneficio() {
		return 0;
	}

}
