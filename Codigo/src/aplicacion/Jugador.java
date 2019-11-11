package aplicacion;

public class Jugador {
	protected int posX;
	protected int posY;
	protected int puntos;
	public Jugador(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		puntos=0;
			}

	public void moverDerecha() {
		posX+=10;
		
	}

	public void moverIzquierda() {
		posY-=10;
		
	}

	public void saltar() {
		posY+=10;
				
	}

	public int getPosY() {
		
		return posY;
	}

	public int getPosX() {
		
		return posX;
	}

	

}
