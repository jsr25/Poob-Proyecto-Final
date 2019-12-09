package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public abstract class Jugador implements movimiento ,Serializable {
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
	/**
	 * constructor del jugador
	 * @param posX posicion en x
	 * @param posY posicion en y
	 * @param personaje numero del personaje
	 */
	public Jugador(int posX, int posY,String personaje) {
		this.posX=posX;
		this.posY=posY;
		puntos=0;
		this.personaje=personaje;
		
		prepararArrays();
		
	}

	/**
	 * prepara el array de los sprites de mario
	 */
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
	/**
	 *el nombre del sprite en el que se encuentra el personaje
	 * @return nombre de la ruta de la imagen
	 */
	public String getForma() {
		return forma;
	}
	/**
	 * cambia el sprite del personaje
	 * @param a numero del sprite nuevo
	 */
	public void cambiarforma(int a) {
		forma=mario.get(a-1);
	}


	/**
	 * sprites de mario
	 * @return los sprites de mario
	 */
	public ArrayList<String> getmario(){
		return mario;
	}
	/**
	 * posicion en y del personaje
	 * @return posicion en y del personaje
	 */
	public int getPosY() {		
		return posY;
	}
	/**
	 * posicion en x del personaje
	 * @return posicion en x del personaje
	 */
	public int getPosX() {		
		return posX;
	}
	/**
	 * cambia los puntos del peronaje
	 * @param t cantidad de puntos a sumar
	 */
	public void setPuntos(int t) {
		puntos=puntos+t;
	}
	/**
	 * puntos actuales del personaje 
	 * @return numero de puntos que tiene
	 */
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


	protected abstract void setVida();
	
	

}
