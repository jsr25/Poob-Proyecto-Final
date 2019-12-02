package aplicacion;

public class Real extends Jugador  {
	private int vidas;
	private boolean estado;
	
	
	public Real(int posX,int posY,String personaje) {
		super(posX,posY,personaje);
		vidas=3;
		estado=true;
		inEscalera=false;
		plataforma=0;
		subPlataforma=0;
		
		
		
	}
	public int getPlat() {
		return plataforma;
		
	}
	public int getSubPlat() {
		return subPlataforma;
	}
	public boolean estoyVivo() {
		if(vidas==0) {
			estado=false;
		}
		
		return estado;
	}

	@Override
	public void saltar() {
			if(getForma().equals("data/marioDerecha.png")) {
				posX=posX+20;
				cambiarforma(11);
				posY=posY-10;
			}
			else if (getForma().equals("data/marioIzquierda.png")) {
				posX=posX-20;
				cambiarforma(12);
				posY=posY-10;
			}
			else {
				if(getForma().equals("data/marioSalto.png")) {
					posX=posX+20;
					cambiarforma(11);
					posY=posY-5;
				}
				else if (getForma().equals("data/marioSaltoIz.png")) {
					posX=posX-20;
					cambiarforma(12);
					posY=posY-5;
				}
				
			}
				
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
			posX=posX+4;
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
			posX=posX-4;
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

	@Override
	protected void subir(boolean posible,int y) {
		if(posible) {
			posY+=y;
			if (getForma().equals("data/marioEscalera1.png") ) {
				cambiarforma(8);
			}
			else if((getForma().equals("data/marioEscalera2.png"))) {
				cambiarforma(9);
			}
			else {
				cambiarforma(8);
			}
		}
		else 
		{
			cambiarforma(7);
		}
	
		
	}

	@Override
	protected void bajar(boolean posible, int y) {
		if(posible) {
			posY-=y;
			if (getForma().equals("data/marioEscalera1.png") || getForma().equals("data/marioEscalera3.png") ) {
				cambiarforma(8);
			}
			else if((getForma().equals("data/marioEscalera2.png"))) {
				cambiarforma(9);
			}
			else {
				cambiarforma(8);
			}
		}
		else 
		{
			cambiarforma(7);
		}
	
	}
	


	@Override
	protected boolean getInEscalera() {
		
		return inEscalera;
	}

	@Override
	public void dejarSaltar() {
		if (getForma().equals("data/marioSalto.png")) {
			posY=posY+20;
			cambiarforma(1);
		}
		if (getForma().equals("data/marioSaltoIz.png")) {
			posY=posY+20;
			cambiarforma(4);
		}
		
	}
	@Override
	protected void sumSub() {
		subPlataforma++;
	}
	@Override
	protected void sumY(int tipo) {
		posY+=tipo;
		
	}
	
	@Override
	protected void resSub() {
		subPlataforma--;
		
	}
	@Override
	protected void resY(int tipo) {
		posY-=tipo;
		
	}
	@Override
	protected void sumY() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setPlat(int i) {		
		plataforma=i;	
	}
	@Override
	protected void setSubPlat(int i) {
		subPlataforma=i;
	}
	@Override
	protected void setInEscalera(boolean s) {
		inEscalera=s;
		
	}
	
	
	
	

}
