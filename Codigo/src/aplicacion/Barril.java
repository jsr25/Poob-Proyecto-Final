package aplicacion;

import java.util.ArrayList;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public abstract class Barril {
	protected int x;
	protected int y;
	private MonkeyPoob monkey;
	
	/**
	 * Contructor de los barriles
	 */
	public Barril() {
		this.x=0;
		this.y=50;
		this.monkey=MonkeyPoob.getMonkey();
	}
	
	/**
	 * Realiza el moviemto general del barril normal
	 */
	public void move() {		
			ArrayList<Plataforma> pT= monkey.getplata();
			boolean posible=false;
			int tipo=0;
			for (int i=0;i<pT.size() && posible==false;i++) {
				 
				if (pT.get(i).estaSobre(x, y) && pT.get(i).getTipo()==1) {
					posible=true;
					tipo=1;
				}
				else if (pT.get(i).estaSobre2(x, y) && pT.get(i).getTipo()==-1) {
					posible=true;
					tipo=-1;
				}
			}
			if (posible) {
				x+=(10*tipo);
			}
			else {
				y+=10;
			}
	}
	
	/**
	 * 
	 * @return valor en y del barril
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * retorna la si un barril colisiono
	 * @param posX valor de x del jugador 
	 * @param posY  valor de y del jugador
	 * @return si se colisionan 
	 */
	public boolean colision(int posX, int posY) {
		return x==posX && y==posY;
	}
	
	/**
	 * 
	 * @return el valor de x del barril 
	 */
	public int getX() {
		
		return x;
	}
	
	/**
	 * reinicia el barril a las posiciones iniciales
	 */
	public void reiniciar() {
		x=0;
		y=50;		
	}
}
