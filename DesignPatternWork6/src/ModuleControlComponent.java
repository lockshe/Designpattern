/*
 * ģ�������������ö���ʽ(����ʵ����)��������
 */
public class ModuleControlComponent {
	
	private static final ModuleControlComponent instance =new ModuleControlComponent();
	private static String info="ģ��������������";
	private ModuleControlComponent() {
		
	}
	
	public static ModuleControlComponent getInstance() {
		System.out.println(info);
		return instance;
	}
}
