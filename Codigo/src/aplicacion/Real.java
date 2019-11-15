package aplicacion;

public class Real extends Jugador  {
	private int vidas;
	private boolean estado;
	
	public Real(int posX,int posY,String personaje) {
		super(posX,posY,personaje);
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
		if(getForma().equals("data/marioDerecha.png")) {
			cambiarforma(2);
		}
		
		else if (getForma().equals("data/marioPasoDerecha.png")){
			cambiarforma(3);
		}
		
		else {
			cambiarforma(1);
		}
		posX=posX+10;
		
	}

	@Override
	public void retroceder() {
		if(getForma().equals("data/marioIzquierda.png")) {
			cambiarforma(5);
		}
		
		else if (getForma().equals("data/marioPasoIzquierda.png")){
			cambiarforma(6);
		}
		
		else {
			cambiarforma(4);
		}
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
