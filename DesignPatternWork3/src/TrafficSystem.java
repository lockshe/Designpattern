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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("�Զ�����·��������һ���ȴ�����");
						e2Wlight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("�Զ�����·������һλ�ȴ�����");
						e2Wlight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println(e2Wlight.getLightName()+"���𣬸�ͨ�����˳�������ͨ��");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					e2Wlight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}else if(i==1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("�Ա�����·��������һ���ȴ�����");
						n2Slight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("�Ա�����·������һλ�ȴ�����");
						n2Slight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println(n2Slight.getLightName()+"���𣬸�ͨ�����˳�������ͨ��");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					n2Slight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}else  if(i==2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("������·��������һ���ȴ�����");
						w2Elight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("������·������һλ�ȴ�����");
						w2Elight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println(w2Elight.getLightName()+"���𣬸�ͨ�����˳�������ͨ��");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					w2Elight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}else if(i==3) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

				for(int j=0;j<random.nextInt(20);j++) {
					if(random.nextInt(2)==0) {
						Observer observer=new Car();
						System.out.println("������·��������һ���ȴ�����");
						s2Nlight.addWaitObj(observer);
					}
					else {
						Observer observer=new Passerby();
						System.out.println("������·������һλ�ȴ�����");
						s2Nlight.addWaitObj(observer);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println(s2Nlight.getLightName()+"���𣬸�ͨ�����˳�������ͨ��");
				
			
				for(int j=0;j<random.nextInt(10);j++) {
					s2Nlight.lightOn();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			i++;
			i%=4;
		}

	}

}
