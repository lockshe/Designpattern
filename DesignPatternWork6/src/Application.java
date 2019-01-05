import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		System.out.println("系统构建中，请输入您的账号，密码，以及身份级别");
		Scanner scanner=new Scanner(System.in);
		String username=scanner.nextLine();
		String password=scanner.nextLine(); 
		int permission=scanner.nextInt();
		RunTimeComponent runTimeComponent=RunTimeComponent.getInstance(username, password, permission);
		ModuleControlComponent moduleControlComponent=ModuleControlComponent.getInstance();
		ModuleCacheComponent moduleCacheComponent=ModuleCacheComponent.getInstance();
		System.out.println("请选择功能 1---运行环境构建 2----启动模块控制组件 3---启动缓存模块 ");
		System.out.println("请选择功能 A---启动模块A B----启动模块B C---启动模块C ");
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
