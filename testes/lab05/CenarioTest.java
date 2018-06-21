package lab05;

import static org.junit.Assert.*;

import org.junit.Test;


@SuppressWarnings("unused")
public class CenarioTest {

	private Cenario cenario;
	private Apostas aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void testDescricaoVazia() {
		
		cenario = new Cenario("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComNomeDoApostadorVazio() {
		
		aposta = new Apostas("", 20, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComPrevisaoVazia() {
		
		aposta = new Apostas("Matheus Patriota", 20, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComValorDaApostaNegativo() {
		
		aposta = new Apostas("Matheus Patriota", -20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testDescricaoNula() {
		
		cenario = new Cenario(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComNomeDoApostadorNulo() {
		
		aposta = new Apostas(null, 20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComPrevisaoNula() {
		
		aposta = new Apostas("Matheus Patriota", 20, null);
	}
	
	@Test
	public void testToString() {
		
		cenario = new Cenario("RED Não vai ser rebaixada pro circuitão");
		assertEquals("RED Não vai ser rebaixada pro circuitão - Nao finalizado", cenario.toString());
	}
	
	

}
