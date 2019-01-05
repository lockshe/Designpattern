
public class Egg extends Tofu {
	
	private String name="Â±µ°";
	private double cost=1.5;
	
	public Egg(Ricenoodle ricenoodle) {
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
