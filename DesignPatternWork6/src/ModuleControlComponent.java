/*
 * 模块控制组件，采用饿汉式(急切实例化)方法创建
 */
public class ModuleControlComponent {
	
	private static final ModuleControlComponent instance =new ModuleControlComponent();
	private static String info="模块控制组件已启动";
	private ModuleControlComponent() {
		
	}
	
	public static ModuleControlComponent getInstance() {
		System.out.println(info);
		return instance;
	}
}
