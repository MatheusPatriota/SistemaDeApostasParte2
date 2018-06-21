package lab05;

import static org.junit.Assert.*;

import org.junit.Test;


public class ApostasTest {


	private Apostas aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostadorVazio() {
		
		aposta = new Apostas("", 20, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrevisaoVazia() {
		
		aposta = new Apostas("Matheus Patriota", 20, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorDaApostaNegativo() {
		
		aposta = new Apostas("Matheus Patriota", -20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testNomeDoApostadorNulo() {
		
		aposta = new Apostas(null, 20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testPrevisaoNula() {
		
		aposta = new Apostas("Matheus Patriota", 20, null);
	}
	
	@Test
	public void testToString() {
		
		aposta = new Apostas("Matheus Patriota", 20, "VAI ACONTECER");
		assertEquals("Matheus Patriota - R$20 - VAI ACONTECER", aposta.toString());
	}
	
	

}
