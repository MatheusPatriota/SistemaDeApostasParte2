package lab05;


public class CenarioBonus extends Cenario {
	
	private int bonus;
	
	public CenarioBonus(String descricao, int bonus) {
		
		super(descricao);
		if (bonus <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		
		this.bonus = bonus;
		rateioCenario += bonus;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - R$ " + bonus/100 + ",00";
	}
	
}
