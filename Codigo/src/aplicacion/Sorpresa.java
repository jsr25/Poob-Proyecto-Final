package aplicacion;

public abstract class Sorpresa {
	private int posX;
	private int posY;
	private String tipo;
	protected String imagen;
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public Sorpresa(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosY() {
		
		return posY;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosX() {
		
		return posX;
	}

	/**
	 * 
	 * @return
	 */
	public abstract int beneficio();
	
	/**
	 * 
	 * @param n
	 */
	public void setTipo(String n) {
		tipo=n;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getImagen() {
		return imagen;
	}
}
