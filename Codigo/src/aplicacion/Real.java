package aplicacion;

import java.io.Serializable;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class Real extends Jugador  implements Serializable {
	private int vidas;
	private boolean estado;
	
	/**
	 * contructor de Real
	 * @param posX posicion en x
	 * @param posY posicion en y
	 * @param personaje nombre del personaje
	 */
	public Real(int posX,int posY,String personaje) {
		super(posX,posY,personaje);
		vidas=3;
		estado=true;
		muerto=false;
		plataforma=0;
		subPlataforma=0;
		
		
		
	}
	
	/**
	 * 
	 * @return si se encuentra vivo
	 */
	public boolean estoyVivo() {
		if(vidas==0) {
			estado=false;
		}
		
		return estado;
	}
	
	/**
	 * cambia el estado de muerto
	 */
    public void setMuerto(boolean v) {
    	muerto=v;
    }
    /**
     * permite saltar y el cambio de los sprites
     */
	@Override
	public void saltar() {
		
			if(getForma().equals("data/marioDerecha.png")) {
				cambiarforma(11);
				posY=posY-20;
				posX=posX+10;
			}
			else if (getForma().equals("data/marioIzquierda.png")) {
				cambiarforma(12);
				posX=posX-10;
				posY=posY-20;
			}
			else if (getForma().equals("data/marioSalto.png")) {
					cambiarforma(1);
					posY=posY+20;
					posX=posX+10;
				}
				else if (getForma().equals("data/marioSaltoIz.png")) {
					posX=posX-10;
					cambiarforma(4);
					posY=posY+20;
				}
				
				
	}
	/**
	 * permite avanzar y el cambio de los sprites
	 */
	@Override
	public void avanzar() {
			if(vidas>0) {
				posX=posX+10;
				if(getForma().equals("data/marioDerecha.png")) {
					cambiarforma(2);
				}
				
				else if (getForma().equals("data/marioPasoDerecha.png")){
					cambiarforma(3);
				}
				
				else {
					cambiarforma(1);
				}
			}
		}

	/**
	 * permite retroceder y el cambio de los sprites
	 */
	@Override
	public void retroceder() {
			if  (vidas>0){
				posX=posX-10;
				if(getForma().equals("data/marioIzquierda.png")) {
					cambiarforma(5);
				}
				
				else if (getForma().equals("data/marioPasoIzquierda.png")){
					cambiarforma(6);
				}
				
				else {
					cambiarforma(4);
				}
				
			}
		}
	/**
	 * @return  si todavia puede seguir juagndo
	 */
	@Override
	protected boolean getEstado() {		
		return vidas>0;
	}
	/**
	 * @return si se ha colisionado con ciert posicion
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	@Override
	protected boolean colision(int x, int y) {
		
		return x==posX && y==posY ;
	}
	/**
	 * actualiza el estado de las vidas
	 */
	@Override
	protected void perdervida() {
		vidas=vidas-1;		
	}
	/**
	 * permite subir una escalera actualizando los sprites
	 * @param posible si es posible subir 
	 * @param y el del jugador
	 */
	@Override
	protected void subir(boolean posible,int y) {
		if(posible && vidas>0) {
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
	/**
	 * permite bajar una escalera y cambiar los sprites 
	 * @param posible si es posible bajar 
	 * @param y el del jugador
	 */
	@Override
	protected void bajar(boolean posible, int y) {
		if(posible && vidas>0) {
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
	

	/**
	 * @return si se encuentra en una escalera 
	 */
	@Override
	protected boolean getInEscalera() {
		return false;
	}
	/**
	 * si es posiobe saltar y cambia los sprites
	 */
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
	/**
	 * cambia de subplataforma
	 */
	@Override
	protected void sumSub() {
		subPlataforma++;
	}
	/**
	 * cambia el y del jugador
	 */
	@Override
	protected void sumY(int tipo) {
		posY+=tipo;
		
	}
	/**
	 * cambia de subplataforma
	 */
	@Override
	protected void resSub() {
		subPlataforma--;
		
	}
	/**
	 * cambia el y del jugador
	 */
	@Override
	protected void resY(int tipo) {
		posY-=tipo;
		
	}
	/**
	 * cambia de plataforma 
	 * @param i numero de la plataforma
	 */
	@Override
	protected void setPlat(int i) {		
		plataforma=i;	
	}
	/**
	 * cambia de subplataforma
	 * @param numero de la subplataforma
	 */
	@Override
	protected void setSubPlat(int i) {
		subPlataforma=i;
	}
	@Override
	protected void setInEscalera(boolean s) {	
	}
	/**
	 * Le resta vidas 
	 */
	@Override
	protected void resVidas() {
		muerto=true;
		vidas-=1;
		cambiarforma(13);
	}
	/**
	 * @return cantidad de vidas
	 */
	@Override
	protected int getVidas() {		
		return vidas;
	}
	/**
	 * @return si esta muerto
	 */
	protected boolean getMuerto() {
		return muerto;
	}
	/**
	 * posicion inicial en x del jugador
	 */
	@Override
	protected void setX() {
		posX=16;
		
	}
	/**
	 * posicion inicial en y del jugador
	 */
	@Override
	protected void setY() {
		posY=400;
		
	}
	/**
	 * reinicia los valores de posicion del jugador 
	 */
	@Override
	protected void reiniciar() {
		posX=10;
		posY=400;
		cambiarforma(1);		
	}
	/**
	 * cambia la vidas
	 */
	@Override
	protected void setVida() {
		vidas+=1;
	}
	@Override
	protected void sumY() {}
	
	
	
	

}
