package aplicacion;

public abstract class Jugador implements movimiento {
	protected int posX;
	protected int posY;
	protected int puntos;
	public Jugador(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		puntos=0;
			}


	public int getPosY() {
		
		return posY;
	}

	public int getPosX() {
		
		return posX;
	}
	
	public void setPuntos(int t) {
		puntos=puntos+t;
	}
	
	public int getPuntos() {
		return puntos;
	}


	protected abstract boolean getEstado();


	protected abstract boolean colision(int x, int y);


	protected abstract void perdervida();



	
	
	

}
