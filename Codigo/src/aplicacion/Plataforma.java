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
	private int y2;
	private int pendiente;
	private int factoB;
	
	public Plataforma(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		pendiente=(y2-y1)/(x2-x1);
		factoB=y1-(pendiente*x1);
	}

	public boolean estaEnRango(int x) {		
		return x1<=x && x2>=x;
	}
	
	public int valorY(int x) {		
		return (pendiente*x)+factoB;
	}
	
	public boolean pendienteNegativa() {
		return pendiente<0;
	}
	
	
}
