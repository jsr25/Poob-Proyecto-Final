package aplicacion;

public class Real extends Jugador  {
	private int vidas;
	private boolean estado;
	public Real(int posX,int posY) {
		super(posX,posY);
		vidas=3;
		estado=true;
		
	}
	
	public boolean estoyVivo() {
		if(vidas==0) {
			estado=false;
		}
		
		return estado;
	}

	@Override
	public void saltar() {
		posY=posY+10;
		
	}

	@Override
	public void avanzar() {
		posX=posX+10;
		
	}

	@Override
	public void retroceder() {
		posX=posX-10;
		
	}

	@Override
	protected boolean getEstado() {
		
		return vidas>0;
	}

	@Override
	protected boolean colision(int x, int y) {
		
		return x==posX && y==posY ;
	}

	@Override
	protected void perdervida() {
		vidas=vidas-1;		
	}
	
	
	
	

}
