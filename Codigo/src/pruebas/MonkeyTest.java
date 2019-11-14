package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MonkeyTest {

	@Test
	public void deberiaHacebarril() {
		MonkeyPoob a= new MonkeyPoob();
		a.crearPlataforma(10,10,20,20);
		a.generarBarriles();
		a.generarBarriles();
		a.generarBarriles();
		ArrayList<Barril> barril=a.getBarriles();
		boolean correct=false;
		for (Barril b:barril) {
			correct=b.getY()==0;
		}
		assertTrue(correct);
	}
	
	@Test
	public void deberiaMoverDerechaPersonaje() {
		MonkeyPoob a= new MonkeyPoob();
		a.agregarJugadores(0, 0);
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		assertTrue((a.getJugador(1)).getPosX()==30);
	}
	
	@Test
	public void deberiaMoverIzquierdaPersonaje() {
		MonkeyPoob a= new MonkeyPoob();
		a.agregarJugadores(30, 0);
		a.moverIzquieda(1);
		a.moverIzquieda(1);
		a.moverIzquieda(1);
		assertTrue((a.getJugador(1)).getPosX()==0);
	}
	
	@Test
	public void debreriaPersonajeTomaBeneficio() {
		MonkeyPoob a= new MonkeyPoob();
		a.agregarJugadores(0, 0);
		a.generarSorpresa(40, 0);
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		assertTrue((a.getJugador(1)).getPosX()==40 && a.getJugador(1).getPuntos()==10 );
	}
}
