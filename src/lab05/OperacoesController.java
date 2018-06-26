/**
* Laboratorio de Programacao 2 - Lab 5
*
* @author Matheus da Silva Coimbra Patriota - 117210391
*/

package lab05;

import java.util.ArrayList;


public class OperacoesController {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;
	private int numeracaoCenarioCadastrado;


	/**
	 * Construtor da classe Operacoes responsavel por inicializar sua classe e seus atributos.
	 */
	public OperacoesController() {
		
		this.cenarios = new ArrayList<>();
		this.caixa = 0;
		this.taxa = 0;
		this.numeracaoCenarioCadastrado = 0;
		
	}
	
	/**
	 * metodo responsavel por inicializar o sistema de apostas
	 * recebendo como parametro caixa e taxa.
	 * 
	 * @param caixa - Total em centavos do caixa do sistema.
	 * @param taxa - taxa de retirada das apostas perdedoras
	 */
	public void inicializarSistema(int caixa, double taxa) {
		
		if (caixa < 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		
		if (taxa  <= 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	/**
	 * metodo responsavel por cadastras um cenario, recebendo como
	 * parametro uma descricao.
	 * 
	 * @param descricao - Descricao de um cenario qualquer que pode ocorrer ou nao.
	 */
	public int cadastrarCenario(String descricao) {
		
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		numeracaoCenarioCadastrado ++;
		return numeracaoCenarioCadastrado;
		
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		
		Cenario cenario = new CenarioBonus(descricao, bonus);
		cenarios.add(cenario);
		numeracaoCenarioCadastrado ++;
		this.caixa -= bonus;
		return numeracaoCenarioCadastrado;
	
	}
	
	/**
	 * metodo responsavel por exibir o Cenario especifico a partir da numeracao do cenario.
	 *  
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna uma String que representa o cenario escolhido.
	 */
	public String exibirCenario(int numeracaoCenario) {
		
		if (numeracaoCenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return numeracaoCenario + " - " + cenarios.get(numeracaoCenario-1);
	}
	
	/**
	 * metodo responsavel por listar todos os cenarios cadastrados.
	 * 
	 * @return - Retorna uma String com todos os cenarios cadastrados.
	 */
	public String listarCenarios() {
		
		String listaDeCenarios = "";
		for (int i = 0; i < cenarios.size(); i++) {
			
			listaDeCenarios += i+1 + " - " + cenarios.get(i) + System.lineSeparator();
		}
		
		return listaDeCenarios;
	}
	
	/**
	 * metodo responsavel por cadastrar uma nova aposta em um cenario especifico, passando como parametro
	 * a numeracaoCenario, apostador e previsao.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario que deve-se cadastrar a aposta.
	 * @param apostador - String com o nome do apostador.
	 * @param valor - O valor a ser apostado.
	 * @param previsao - Prever se o evento vai acontecer ou nao.
	 */
	public void cadastrarApostas(int numeracaoCenario, String apostador, int valor, String previsao) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracaoCenario-1).cadastrarApostas(apostador, valor, previsao);
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
		
	}
	
	public void cadastrarApostaSeguraTaxa(int numeracaoCenario, String apostador, int valor, String previsao, double taxa, int custo) {
		
                if (numeracaoCenario <= 0) {
                
                    throw  new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
                }
                
                if (numeracaoCenario > cenarios.size()) {
                
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
                }
                if (apostador == null) {
                    throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
                }
                
                if (apostador.equals("")) {
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
                }
		if (valor <= 0) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		
		if (apostador.equals("  ")) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		
		if (previsao.equals("  ")) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("") || previsao == null) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
                
                if (apostador.equals("   ")) {
                
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
                }
                
		cenarios.get(numeracaoCenario-1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa, custo);
		caixa += custo;
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
	}
	
	public void cadastrarApostaSeguraValor(int numeracaoCenario, String apostador, int valor, String previsao, int valorDoResgate, int custo) {
		
                if (numeracaoCenario <= 0) {
                
                    throw  new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
                }
                
                if (numeracaoCenario > cenarios.size()) {
                
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
                }
                if (apostador == null) {
                    throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
                }
                
                if (apostador.equals("")) {
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
                }
		if (valor <= 0) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		
		if (apostador.equals("  ")) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		
		if (previsao.equals("  ")) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("") || previsao == null) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
                
                if (apostador.equals("   ")) {
                
                    throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
                }
		cenarios.get(numeracaoCenario-1).cadastrarApostaSeguraValor(apostador, valor, previsao, valorDoResgate, custo);
		caixa += custo;
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
	}
	
	public void alterarSeguroValor(int numeracaoCenario, int apostaAssegurada, int valorDoResgate) {
		
		((ApostaSeguraPorValor)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(apostaAssegurada-1)).setValorDoResgate(valorDoResgate);
		
	}
	
	public int alterarSeguroTaxa(int numeracaoCenario, int apostaAssegurada, double taxa ) {
		
		((ApostaSeguraPorTaxa)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(apostaAssegurada-1)).setTaxa(taxa);
                return numeracaoCenario;
	}
	
	/**
	 * metodo responsavel por retornar o total do valor de apostas de um cenario especifico.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna um numero inteiro que representa o valor total de apostas no cenario. 
	 */
	public int valorTotalDeApostas(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		return cenarios.get(numeracaoCenario-1).getValorTotalApostas();
	}
	
	/**
	 * metodo responsavel por retornar o numero total de apostas no cenario especifico recebendo como parametro
	 * a numeracaoCenario.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna a quantidade em inteiro de apostas no cenario.
	 */
	public int totalDeApostas(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		return cenarios.get(numeracaoCenario-1).getTotalDeApostas();
	}
	
	/**
	 * metodo responsavel por exibir todas as apostas feitas em um cenario recebendo como parametro
	 * a numeracaoCenario.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna uma String com todas as apostas feitas no cenario.
	 */
	public String exibeApostas(int numeracaoCenario) {
		
		String exibindoApostas = "";
		for (int i = 0; i < cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
			exibindoApostas += "- " + cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i) + System.lineSeparator();
		}
		
		
		return exibindoApostas;
		
	}
	
	/**
	 * metodo responsavel por fechar uma aposta recebendo como parametro a
	 * numeracaoCenario e um boolean determinando se ocorreu ou nao.
	 * 
	 * @param numeracaoCenario - Numeracao em inteiro do cenario.
	 * @param ocorreu - valor booleano representando se o Cenario ocorreu ou nao.
	 */
	public void fecharAposta(int numeracaoCenario, boolean ocorreu) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		if (!cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
		if (ocorreu  == true) {
			
			for (int i = 0; i <cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
				
				if (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getPrevisao().equals("N VAI ACONTECER")) {
					
					if (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getAssegurado() == true) {
						
						if (((ApostaSeguraPorValor)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i)).getAsseguradoPorValor() == true) {
							
							caixa += cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor() * taxa;
							caixa -= ((ApostaSeguraPorValor)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i)).getValorDoResgate();	
						}
						else if (((ApostaSeguraPorTaxa)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i)).getAsseguradoPorTaxa() == true) {
							
							caixa += cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor() * taxa;
							caixa -= (((ApostaSeguraPorTaxa)cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i)).getTaxa() / 100) * (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor());	
						}
					}
					else {
						cenarios.get(numeracaoCenario-1).setCaixaCenario(cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor());
						
					}
					
				}
			}
			
			caixa += (cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa);
			cenarios.get(numeracaoCenario-1).setRateioCenario((int) (cenarios.get(numeracaoCenario-1).getCaixaCenario() - cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa));
			cenarios.get(numeracaoCenario-1).setStatus("Finalizado (ocorreu)");
		}
		
		else {
			
			for (int i = 0; i <cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
				
				if (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getPrevisao().equals("VAI ACONTECER")) {
					
					cenarios.get(numeracaoCenario-1).setCaixaCenario(cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor());
				}
				
			}
			
			caixa += (cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa);
			cenarios.get(numeracaoCenario-1).setRateioCenario((int) (cenarios.get(numeracaoCenario-1).getCaixaCenario() - cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa));
			cenarios.get(numeracaoCenario-1).setStatus("Finalizado (não ocorreu)");
		}
	
		
	}
	
	
	public int getCaixaCenario(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		if (cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		
		return cenarios.get(numeracaoCenario-1).getCaixaCenario()/100;
	}
	
	public int getTotalRateioCenario(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		if (cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		
		return cenarios.get(numeracaoCenario-1).getRateioCenario();
	}
	
	public int getCaixa() {
		
		return this.caixa;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
}
