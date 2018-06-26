package lab05;

public class ApostaSeguraPorValor extends Aposta{
	
	protected int valorDoResgate;
	private int custo;
	private boolean asseguradoPorValor;
	
	public ApostaSeguraPorValor(String apostador, int valor, String previsao, int valorDoResgate, int custo ) {
		
		super(apostador, valor, previsao);
		this.valorDoResgate = valorDoResgate;
		this.custo = custo;
		assegurado = true;
		this.asseguradoPorValor = true;
	}
	
	@Override
	public boolean getAssegurado() {
		return this.assegurado;
	}
	
	public boolean getAsseguradoPorValor() {
		return asseguradoPorValor;
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
	
	@Override
	public String toString() {

		return super.toString() + " - "  + "ASSEGURADO(VALOR) - R$" + valorDoResgate;
	}
}
