package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MonkeyTest {

	//@Test
	/*public void deberiaHacebarril() {
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
	}*/
	
	@Test
	public void deberiaMoverDerechaPersonaje() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(0, 0,"mario");
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		assertTrue((a.getJugadorPosX(1))==30);
	}
	
	@Test
	public void deberiaMoverIzquierdaPersonaje() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(30, 0,"mario");
		a.moverIzquieda(1);
		a.moverIzquieda(1);
		a.moverIzquieda(1);
		assertTrue((a.getJugadorPosX(1))==0);
	}
	
	@Test
	public void debreriaPersonajeTomaBeneficio() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(0, 0,"mario");
		a.generarSorpresa(40, 0);
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);
		assertTrue((a.getJugadorPosX(1)==40 ) );
	}
	
	@Test
	public void deberiaSubirEscalera() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(0, 0,"mario");
		a.generarEscaleras(0,0,30);
		a.subirEscalera(1);
		a.subirEscalera(1);		
		a.subirEscalera(1);		
		assertTrue((a.getJugadorPosX(1)==30));
	}

	@Test
	public void deberiaBajarEscalera() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(0, 30,"mario");
		a.generarEscaleras(0,0,30);
		a.bajarEscalera(1);
		a.bajarEscalera(1);	
		a.bajarEscalera(1);	
		assertTrue((a.getJugadorPosY(1)==0));
	}
	
	@Test
	public void deberiaCrearEsacalera() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(0, 30,"mario");
		a.crearPlataformaBaja(0, 400);
		a.crearPlataformaCentral(340);
		a.generarEscaleras(40, 1, 2);
	}
	
	
}
