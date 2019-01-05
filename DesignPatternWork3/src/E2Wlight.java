
public class E2Wlight extends TrafficLight {

	private String lightName="自东向西通行灯";	
	@Override
	public void addWaitObj(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void lightOn() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Observer observer;
		observer=observers.poll();
		observer.update();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObj() {
		
	}
	public String getLightName() {
		return lightName;
	}
	public void setLightName(String lightName) {
		this.lightName = lightName;
	}
	
	
	
}
