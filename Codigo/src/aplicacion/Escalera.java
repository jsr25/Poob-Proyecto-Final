package aplicacion;

public class Escalera {
	private int x;
	private int yIni;
	private int yFin;
	
	

	public Escalera(int x, int yIni, int yFin) {
		this.x=x;
		this.yIni=yIni;
		this.yFin=yFin;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY1() {
		return yIni;
	}
	
	public int getY2() {
		return yFin;
	}

	public boolean posibleSubir(int posX,int posY) {
		return (x==posX) && (yIni==posY || posY>=yFin);
	}
	
	public boolean posibleBajar(int posX,int posY) {
		return (x==posX) && (yFin==posY || posY<=yIni);
	}
	
	
}
