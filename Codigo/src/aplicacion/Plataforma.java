package aplicacion;

import java.io.Serializable;

/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class Plataforma  implements Serializable{
	private int x1;
	private int x2;
	private int y1;
	private int tipo;
	/**
	 * constructor de la plataforma
	 * @param x1 posicion inicial en x
	 * @param y1 posicion inicial en y
	 * @param x2 poscion final en x
	 * @param tipo de plataforma
	 */
	public Plataforma(int x1, int y1, int x2,int tipo) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.tipo=tipo;
	}
	/**
	 * si se encuentra sobre ella
	 * @param x posicion en x
	 * @param y posision en y
	 * @return  si la coordenada dada esta sobre la plataforma
	 */
	public boolean estaSobre(int x,int y) {		
		return ((x1-10<=x && x2-10>x)&&(y==y1-12));
	}
	/**
	 * si se encuentra sobre ella
	 * @param x posicion en x
	 * @param y posision en y
	 * @return  si la coordenada dada esta sobre la plataforma
	 */
	public boolean estaSobre2(int x,int y) {		
		return ((x<=x2-10 && x1-10<x)&&(y==y1-12));
	}
	/**
	 * el tipo de plataforma
	 * @return el tipo de la plataforma
	 */
	public int getTipo() {
		return tipo;
	}
	/**
	 * posicion inicial en x
	 * @return la posicion inicial en x de la plataforma
	 */
	public int getX() {
		return x1 ;
	}
	/**
	 * posicion en y de la plataforma
	 * @return la posicion en y de la plataforma
	 */
	public int getY() {
		return y1;
	}
	/**
	 * posicion final en x de la plataforma
	 * @return poscion final en x de la plataforma
	 */
	public int getX2() {
		
		return x2;
	}
	/**
	 * rango en x
	 * @param i posicion e x
	 * @return si se encuentra en el rango de la plataforma
	 */
	public boolean rangoX(int i) {
		return (i<x2 && x1<=i);
	}
	/**
	 * si esta cerca en y
	 * @param i posicion en x
	 * @return si se encuentra en el rango en x
	 */
	public boolean rangoCercaY(int i) {
		return (i>=x2 && x1<=i);
	}
	
}
