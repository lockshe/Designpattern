
public class Tofu extends Ingredient {
	
	private String name="³ô¶¹¸¯";
	private double cost=2.0;
	

	public Tofu(Ricenoodle ricenoodle) {
		super(ricenoodle);
		name=super.ricenoodle.getDescription()+"+"+name;
		cost=super.ricenoodle.cost()+cost;
	}
	

	public String getDescription() {
		
		return name;
	}

	public double cost() {
	
		return cost;
	}
	
}
