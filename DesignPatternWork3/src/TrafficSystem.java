import java.util.Random;

public class TrafficSystem {
	
	public static void main(String[] args) {
		Random random=new Random();
		int i=0;
		E2Wlight e2Wlight =new E2Wlight();
		N2Slight n2Slight =new N2Slight();
		S2Nlight s2Nlight =new S2Nlight();
		W2Elight w2Elight =new W2Elight();
		while(true) {
			if(i==0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("自东向西路口新增了一辆等待车辆");
						e2Wlight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("自东向西路口新增一位等待行人");
						e2Wlight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println(e2Wlight.getLightName()+"亮起，该通道行人车辆正在通过");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					e2Wlight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else if(i==1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("自北向南路口新增了一辆等待车辆");
						n2Slight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("自北向南路口新增一位等待行人");
						n2Slight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println(n2Slight.getLightName()+"亮起，该通道行人车辆正在通过");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					n2Slight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else  if(i==2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("自西向东路口新增了一辆等待车辆");
						w2Elight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("自西向东路口新增一位等待行人");
						w2Elight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println(w2Elight.getLightName()+"亮起，该通道行人车辆正在通过");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					w2Elight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else if(i==3) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("自南向北路口新增了一辆等待车辆");
						s2Nlight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("自南向北路口新增一位等待行人");
						s2Nlight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println(s2Nlight.getLightName()+"亮起，该通道行人车辆正在通过");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					s2Nlight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			i++;
			i%=4;
		}

	}

}
