
public class ForCompany implements ComputerStore{

	@Override
	public Cpu createCpu() {
		return new CompanyCpu();
	}

	@Override
	public Mainboard createMainboard() {

		return new CompanyMainboard();
	}

	@Override
	public GraphicCard createGraphicCard() {

		return new CompanyGraphicCard();
	}

	@Override
	public Hardisk createHardisk() {

		return new CompanyHardisk();
	}

	@Override
	public MemoryBank createMemoryBank() {
		
		return new CompanyMemoryBank();
	}

}
