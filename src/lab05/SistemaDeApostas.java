package lab05;

public class SistemaDeApostas {
	
	public static void main(String[] args) {
		
		
		OperacoesFacade operacao = new OperacoesFacade();
		operacao.inicializa(100000, 0.01);
		/**
		 *  Operacoes realacionadas a Cenario
		 */
		
		operacao.cadastrarCenario("RED vai ganhar o mundial ",1000);
		operacao.cadastrarCenario("RED vai ganhar o mundial ",10);
		operacao.cadastrarCenario("As provas vao ser corrigidas ate sexta",1000); 
		operacao.cadastrarCenario("As provas nao vao ser corrigidas ate sexta",10);
		System.out.println(operacao.exibirCenario(1));
		System.out.println();
		System.out.println(operacao.listarCenarios());
		
		/**
		 * Operacoes relacionadas a Aposta
		 */
		operacao.cadastrarAposta(1, "Matheus Patriota", 1000, "VAI ACONTECER");
		operacao.cadastrarApostaSeguraValor(1, "Homer simpson", 1000, "VAI ACONTECER", 200, 50);
		operacao.cadastrarApostaSeguraTaxa(1, "Marge simpson", 500, "VAI ACONTECER", 5, 50);
		operacao.cadastrarAposta(2, "Matheus Patriota", 50, "VAI ACONTECER");
		operacao.cadastrarAposta(2, "Matheus Patriota", 10000, "N VAI ACONTECER");
		System.out.println(operacao.valorTotalDeApostas(1));
		System.out.println();
		System.out.println(operacao.totalDeApostas(1));
		System.out.println();
		System.out.println(operacao.exibeApostas(1));
		operacao.fecharAposta(1, false);
		operacao.fecharAposta(2, true);
		System.out.println(operacao.getCaixa());
		System.out.println(operacao.getCaixaCenario(1));
		System.out.println(operacao.getTotalRateioCenario(1));
		System.out.println();
		System.out.println(operacao.getCaixa());
		System.out.println(operacao.getCaixaCenario(2));
		System.out.println(operacao.getTotalRateioCenario(2));
		
	}

}
