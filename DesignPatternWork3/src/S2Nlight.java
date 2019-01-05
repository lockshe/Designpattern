
public class S2Nlight extends TrafficLight {
	
	private String lightName="������ͨ�е�";	
	@Override
	public void addWaitObj(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void lightOn() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Observer observer;
		observer=observers.poll();
		observer.update();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
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
