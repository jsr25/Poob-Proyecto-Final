package aplicacion;

import java.util.ArrayList;

public abstract class Jugador implements movimiento {
	private ArrayList<String> mario;
	private ArrayList<String> luigi;
	protected int posX;
	protected int posY;
	protected int puntos;
	protected int plataforma;
	protected int subPlataforma;
	protected   boolean muerto;
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
		mario.add("data/marioDerecha.png");//1
		mario.add("data/marioPasoDerecha.png");//2
		mario.add("data/marioPasoDerecha2.png");//3
		mario.add("data/marioIzquierda.png");//4
		mario.add("data/marioPasoIzquierda.png");//5
		mario.add("data/marioPasoIzquierda2.png");//6
		mario.add("data/marioEscalera1.png");//7
		mario.add("data/marioEscalera2.png");//8
		mario.add("data/marioEscalera3.png");//9
		mario.add("data/marioEscalera4.png");//10
		mario.add("data/marioSalto.png");//11
		mario.add("data/marioSaltoIz.png");//12
		mario.add("data/marioMuertoDerecha.png");//13
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

	protected abstract void subir(boolean posible,int yFin);
	
	protected abstract void bajar(boolean posible,int yFin);
	
	protected abstract void setInEscalera(boolean s);

	protected abstract boolean getInEscalera();

	protected abstract int getPlat();


	protected abstract int getSubPlat();


	protected abstract void sumSub();


	protected abstract void sumY();


	protected abstract void sumY(int tipo);

	protected abstract void resSub();

	protected abstract void resY(int tipo);
	
	protected abstract void setPlat(int i);
	
	protected abstract void setSubPlat(int i);


	protected abstract void resVidas();


	protected abstract int getVidas();
	
	protected abstract boolean getMuerto();


	protected abstract void setMuerto(boolean b);


	protected abstract void setX();


	protected abstract void setY();


	protected abstract void reiniciar();
	
	

}
