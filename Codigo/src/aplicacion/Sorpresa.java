package aplicacion;

public abstract class Sorpresa {
	private int posX;
	private int posY;
	private String tipo;

	public Sorpresa(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
	}

	public int getPosY() {
		
		return posY;
	}

	public int getPosX() {
		
		return posX;
	}
	
	public abstract int beneficio();
	
	public void setTipo(String n) {
		tipo=n;
	}
	
	public String getTipo() {
		return tipo;
	}
}
