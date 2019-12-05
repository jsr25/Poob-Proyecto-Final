package aplicacion;

public class Escalera {
	private int x;
	private int yIni;
	private int yFin;
	private String imagen;
	private Plataforma plat1;
	private Plataforma plat2;
	
	
	/**
	 * Contructor de la escalera
	 * @param x valor en x
	 * @param uno plataformma inicial
	 * @param dos plataformma final
	 */
	public Escalera(int x,Plataforma uno, Plataforma dos) {
		this.x=x;
		imagen="data/escalera.png";
		plat1=uno;
		plat2=dos;
		yIni=plat1.getY();
		yFin=plat2.getY();
			}
	
	/**
	 * 
	 * @return valor en x de la escalera
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @return valor en inicial en y de la escalera
	 */
	public int getY1() {
		return yIni;
	}
	/**
	 * 
	 * @return valor en final en y de la escalera
	 */
	public int getY2() {
		return yFin;
	}
	/**
	 * 
	 * @param posX valor en x
	 * @param posY valor en y
	 * @return si es posible subir
	 */
	public boolean posibleSubir(int posX,int posY) {
		return (x==posX) && (yIni==posY || (posY>yFin &&  posY<=yIni));
	}
	/**
	 * 
	 * @param posX valor en x
	 * @param posY valor en y
	 * @return si es posible bajar
	 */
	public boolean posibleBajar(int posX,int posY) {
		return (x==posX) && (yFin==posY || (posY<yIni &&  posY>=yFin));
	}
	/**
	 * 
	 * @return nombre de la ruta de la imagen de la escalera
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * 
	 * @return la plataforma final de la escalera 
	 */
	public Plataforma getPlat2() {
		return plat2;
	}
	
}
