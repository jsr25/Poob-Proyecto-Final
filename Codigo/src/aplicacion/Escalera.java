package aplicacion;

public class Escalera {
	private int x;
	private int yIni;
	private int yFin;
	private String imagen;
	
	

	public Escalera(int x,Plataforma uno, Plataforma dos) {
		this.x=x;
		imagen="data/escalera.png";
		//this.yIni=yIni;
		//this.yFin=yFin;
		
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
		return (x==posX) && (yIni==posY || (posY>yFin &&  posY<=yIni));
	}
	
	public boolean posibleBajar(int posX,int posY) {
		return (x==posX) && (yFin==posY || (posY<yIni &&  posY>=yFin));
	}
	
	public String getImagen() {
		return imagen;
	}
	
}
