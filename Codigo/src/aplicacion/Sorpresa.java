package aplicacion;

import java.io.Serializable;

public abstract class Sorpresa implements Serializable{
	private int posX;
	private int posY;
	private String tipo;
	protected String imagen;
	
	/**
	 * Constructor de sorpresa
	 * @param posX posicion en x
	 * @param posY posicion en y
	 */
	public Sorpresa(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
	}
	
	/**
	 * 
	 * @return la posicion en y de la sorpresa
	 */
	public int getPosY() {
		
		return posY;
	}
	
	/**
	 * 
	 * @return la posicion en x de la sorpresa
	 */
	public int getPosX() {
		
		return posX;
	}

	public abstract int beneficio();
	
	/**
	 * asigna el tipo de sopresa
	 * @param n tipo de sorpresa
	 */
	public void setTipo(String n) {
		tipo=n;
	}
	
	/**
	 * 
	 * @return tipo de sorpresa
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * 
	 * @return ruta de la imagen de la sorpresa
	 */
	public String getImagen() {
		return imagen;
	}
}
