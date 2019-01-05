import javax.naming.event.NamespaceChangeListener;

public class ForStudent implements ComputerStore {

	@Override
	public Cpu createCpu() {
		
		return new StudentCpu();
	}

	@Override
	public Mainboard createMainboard() {
		
		return new StudentMainboard();
	}

	@Override
	public GraphicCard createGraphicCard() {
	
		return new StudentGraphicCard();
	}

	@Override
	public Hardisk createHardisk() {
		
		return new StudentHardisk();
	}

	@Override
	public MemoryBank createMemoryBank() {
		
		return new StudentMemoryBank();
	}



}
