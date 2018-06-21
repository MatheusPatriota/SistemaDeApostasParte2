/**
* Laboratorio de Programacao 2 - Lab 5
*
* @author Matheus da Silva Coimbra Patriota - 117210391
*/

package lab05;

import java.util.ArrayList;

public class Cenario {
	
	
	protected String descricao;
	protected String status;
	private ArrayList<Apostas> arrayDeApostas;
	private int valorTotalApostas;
	private int totalDeApostas;
	protected int rateioCenario;
	private int caixaCenario;

	
	/**
	 * Construtor da classe Cenario responsavel por iniciar a classe e seus atributos.
	 * 
	 * @param descricao - Descricao do cenario possivel
	 */
	public Cenario(String descricao) {
		
		if (descricao.equals(null)) {
			
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}
		
		if (descricao.equals("")) {
			
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.descricao = descricao;
		this.status = "Nao finalizado";
		this.arrayDeApostas = new ArrayList<>();
		this.valorTotalApostas = 0;
		this.totalDeApostas = 0;
		this.caixaCenario = 0;
		this.rateioCenario = 0;
	}
	
	/**
	 * metodo responsavel por cadastrar apostas recebendo como parametro
	 * apostador, valor e previsao. 
	 * 
	 * @param apostador - Nome de quem esta apostando.
	 * @param valor - Valor da aposta a ser feita.
	 * @param previsao - Prever se o cenario vai acontecer ou nao.
	 */
	public void cadastrarApostas(String apostador, int valor, String previsao) {
		
		Apostas aposta = new Apostas(apostador, valor, previsao);
		arrayDeApostas.add(aposta);
				
	}
	
	public int getRateioCenario() {
		return rateioCenario;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getCaixaCenario() {
		return caixaCenario;
	}
	
	public int getTotalDeApostas() {
		return totalDeApostas;
	}
	
	public ArrayList<Apostas> getArrayDeApostas() {
		return arrayDeApostas;
	}
	
	public int getValorTotalApostas() {
		return valorTotalApostas;
	}
	
	public void setCaixaCenario(int caixaCenario) {
		this.caixaCenario += caixaCenario;
	}
	
	public void setTotalDeApostas() {
		this.totalDeApostas ++;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setValorTotalApostas(int valorTotalApostas) {
		
		this.valorTotalApostas += valorTotalApostas;
	}
	
	public void setRateioCenario(int rateioCenario) {
		this.rateioCenario += rateioCenario;
	}
	
	/**
	 * toString para padronizar a exibicao da classe Cenario utilizando descricao e status.
	 * 
	 * @return - Retorna uma representacao em String da classe Cenario
	 */
	@Override
	public String toString() {
	
		return  descricao + " - " + status;
	}
	
	
	
	 
}
