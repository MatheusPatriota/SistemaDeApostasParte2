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
		
		//4 - As provas vao ser corrigidas ate sexta - Nao finalizado - R$ 10,00
		//4 - As provas nao vao ser corrigidas ate sexta - Nao finalizado - R$ 10,00
		
		return super.toString() + " - R$ " + bonus + ",00";
	}
	
}
