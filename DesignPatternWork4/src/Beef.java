
public class Beef extends Tofu {
	
	private String name="В±ЕЈИв";
	private double cost=5;
	
	public Beef(Ricenoodle ricenoodle) {
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
