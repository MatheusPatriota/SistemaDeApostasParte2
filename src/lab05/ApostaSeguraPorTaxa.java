package lab05;

public class ApostaSeguraPorTaxa extends Aposta {
	
	private double taxa;
	private int custo;
	private boolean asseguradoPorTaxa;
	
	public ApostaSeguraPorTaxa(String apostador, int valor, String previsao, double taxa, int custo){
		
		super(apostador, valor, previsao);
		this.taxa = taxa;
		this.custo = custo;	
		assegurado = true;
		this.asseguradoPorTaxa = true;
	}
	
	public boolean getAsseguradoPorTaxa() {
		return asseguradoPorTaxa;
	}
	
	@Override
	public boolean getAssegurado() {
		return this.assegurado;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
	public int getCusto() {
		return custo;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - " + "ASSEGURADA(TAXA) - " + (int)(taxa) + "%";
	}
}
