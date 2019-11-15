package aplicacion;

import java.util.ArrayList;

public abstract class Jugador implements movimiento {
	private ArrayList<String> mario;
	private ArrayList<String> luigi;
	protected int posX;
	protected int posY;
	protected int puntos;
	private String personaje;
	private String forma;
	public Jugador(int posX, int posY,String personaje) {
		this.posX=posX;
		this.posY=posY;
		puntos=0;
		this.personaje=personaje;
		
		prepararArrays();
		
	}


	private void prepararArrays() {
		if(personaje.equals("mario")) {
		mario=new ArrayList<String>();
		mario.add("data/marioDerecha.png");
		mario.add("data/marioPasoDerecha.png");
		mario.add("data/marioPasoDerecha2.png");
		mario.add("data/marioIzquierda.png");
		mario.add("data/marioPasoIzquierda.png");
		mario.add("data/marioPasoIzquierda2.png");
		
		forma=mario.get(0);}
		
	}
	
	public String getForma() {
		return forma;
	}
	
	public void cambiarforma(int a) {
		forma=mario.get(a-1);
	}


	
	public ArrayList<String> getmario(){
		return mario;
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
