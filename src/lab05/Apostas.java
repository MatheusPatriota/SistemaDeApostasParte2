/**
* Laboratorio de Programacao 2 - Lab 5
*
* @author Matheus da Silva Coimbra Patriota - 117210391
*/

package lab05;


public class Apostas {
	
	private String apostador;
	private int valor;
	private String previsao;
	
	/**
	 * Construtor de Apostas responsavel por inicializar sua classe e atributos.
	 * 
	 * @param apostador - Nome de quem está apostando
	 * @param valor - Valor da aposta
	 * @param previsao - Prever se o cenario vai acontecer ou não
	 */
	public Apostas(String apostador, int valor, String previsao) {
		
		if (apostador.equals(null) || apostador.equals("")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		
		if (valor <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		
		if (apostador.equals("  ")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		
		if (previsao.equals("   ")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("") || previsao.equals(null)) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		
		this.valor = valor;
		this.apostador = apostador;
		this.previsao = previsao;
	}
	
	public String getPrevisao() {
		return previsao;
	}
	
	public int getValor() {
		return valor;
	}
	
	/**
	 * toString para padronizar a exibicao da classe Apostas, usando apostador, valor e previsao.
	 * 
	 * @return - retorna uma string que representa as Apostas
	 */
	@Override
	public String toString() {
		
		return apostador + " - R$" + valor + " - " + previsao;
	}
}
