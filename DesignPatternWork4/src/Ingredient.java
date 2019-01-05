
public class Ingredient extends Ricenoodle {
	
	protected Ricenoodle ricenoodle;
	
	public Ingredient(Ricenoodle ricenoodle) {
		this.ricenoodle=ricenoodle;
	}
	
	@Override
	public String getDescription() {
		
		return ricenoodle.getDescription();
	}

	@Override
	public double cost() {
	
		return ricenoodle.cost();
	}

}
