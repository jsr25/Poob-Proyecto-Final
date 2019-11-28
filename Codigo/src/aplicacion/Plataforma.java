package aplicacion;
/**
 * 
 * @author ramos
 *
 */
public class Plataforma {
	private int x1;
	private int x2;
	private int y1;
	private int tipo;
	private int tipo2=-5;
	
	public Plataforma(int x1, int y1, int x2,int tipo) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.tipo=tipo;
	}
	public Plataforma(int x1, int y1, int x2,int tipo,int tipo2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.tipo=tipo;
		this.tipo2=tipo2;
	}

	public boolean estaSobre(int x,int y) {		
		return ((x1<=x && x2>x-1)&&(y==y1-12));
	}
	public boolean estaSobre2(int x,int y) {		
		return ((x>=x2 && x1<=x)&&(y==y1-12));
	}
	public int getTipo() {
		return tipo;
	}

	public int getX() {
		return x1 ;
	}

	public int getY() {
		return y1;
	}
	public int getTipo2() {
		
		return tipo2;
	}
	public int getX2() {
		
		return x2;
	}
	
	
}
