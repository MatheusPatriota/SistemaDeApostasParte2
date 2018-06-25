package lab05;

public class ApostaSeguraPorValor extends Aposta{
	
	protected int valorDoResgate;
	private int custo;
	
	public ApostaSeguraPorValor(String apostador, int valor, String previsao, int valorDoResgate, int custo ) {
		
		super(apostador, valor, previsao);
		this.valorDoResgate = valorDoResgate;
		this.custo = custo;
	}
	
	@Override
	public String toString() {

		return super.toString() + " - "  + "ASSEGURADO(VALOR) - R$" + valorDoResgate;
	}
	
	public int getCusto() {
		return custo;
	}
	
	public int getValorDoResgate() {
		return valorDoResgate;
	}
	
	public void setValorDoResgate(int valorDoResgate) {
		this.valorDoResgate = valorDoResgate;
	}
}
