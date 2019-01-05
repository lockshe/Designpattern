import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



/*
 * ģ�黺�����,���������أ�˫�ؼ������ķ�������,��������Ҫʹ��ʱ���ͷ�
 */
public class ModuleCacheComponent {
	
	private volatile static ModuleCacheComponent instance=null;
	private static List<Module> modules=new ArrayList<>();
	private static String info=null;
	private static String info2=null;
	
	private ModuleCacheComponent() {
		
	}
	
	public static ModuleCacheComponent getInstance() {
		if(instance==null) {			
			synchronized(ModuleCacheComponent.class) {
				if(instance==null) {
					info="�������δ��������������";
					System.out.println(info);
					instance=new ModuleCacheComponent();
				}
			}			
		}else {
			info="��������Ѿ�����";
			System.out.println(info);
		}
		return instance;
	}
	
	//ģ��Ļ�ȡ�봴��ͬ��ʹ��������
	public Module getModuleA() {		
		for(Module module:modules) {
			if(module instanceof ModuleA) {
				info2="ģ��A�Ѿ����棬ֱ���ͷ�";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleA) {
					info2="ģ��A�ѻ��棬ֱ���ͷ�";
					System.out.println(info2);
					return module;
				}
			}
			info2="ģ��Aδ����,�Ƚ��д���";
			System.out.println(info2);
			Module module=new ModuleA();
			modules.add(module);
			return module;
		}
	}
	
	public Module getModuleB() {
		for(Module module:modules) {
			if(module instanceof ModuleB) {
				info2="ģ��B�Ѿ����棬ֱ���ͷ�";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleB) {
					info2="ģ��B�ѻ��棬ֱ���ͷ�";
					System.out.println(info2);
					return module;
				}
			}
			info2="ģ��Bδ����,�Ƚ��д���";
			System.out.println(info2);
			Module module=new ModuleB();
			modules.add(module);
			return module;
		}
	}
	
	public Module getModuleC() {
		for(Module module:modules) {
			if(module instanceof ModuleC) {
				info2="ģ��C�Ѿ����棬ֱ���ͷ�";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleC) {
					info2="ģ��C�ѻ��棬ֱ���ͷ�";
					System.out.println(info2);
					return module;
				}
			}
			info2="ģ��δC����,�Ƚ��д���";
			System.out.println(info2);
			Module module=new ModuleC();
			modules.add(module);
			return module;
		}
	}
}
