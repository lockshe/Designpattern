import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		System.out.println("ϵͳ�����У������������˺ţ����룬�Լ���ݼ���");
		Scanner scanner=new Scanner(System.in);
		String username=scanner.nextLine();
		String password=scanner.nextLine(); 
		int permission=scanner.nextInt();
		RunTimeComponent runTimeComponent=RunTimeComponent.getInstance(username, password, permission);
		ModuleControlComponent moduleControlComponent=ModuleControlComponent.getInstance();
		ModuleCacheComponent moduleCacheComponent=ModuleCacheComponent.getInstance();
		System.out.println("��ѡ���� 1---���л������� 2----����ģ�������� 3---��������ģ�� ");
		System.out.println("��ѡ���� A---����ģ��A B----����ģ��B C---����ģ��C ");
		while(true) {
			String choice=scanner.nextLine();
			switch(choice) {
				case "1":
					runTimeComponent=RunTimeComponent.getInstance(username, password, permission);
					break;
				case "2":
					moduleControlComponent=ModuleControlComponent.getInstance();
					break;
				case "3":
					moduleCacheComponent=ModuleCacheComponent.getInstance();
					break;
				case "a":
					moduleCacheComponent.getModuleA();
					break;
				case "b":
					moduleCacheComponent.getModuleB();
					break;
				case "c":
					moduleCacheComponent.getModuleC();
					break;
			}		
		}
	}

}
