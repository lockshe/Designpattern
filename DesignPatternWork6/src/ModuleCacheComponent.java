import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



/*
 * 模块缓存组件,采用懒加载，双重检查加锁的方法创建,存放组件，要使用时候释放
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
					info="缓存组件未启动，现在启动";
					System.out.println(info);
					instance=new ModuleCacheComponent();
				}
			}			
		}else {
			info="缓存组件已经启动";
			System.out.println(info);
		}
		return instance;
	}
	
	//模块的获取与创建同样使用懒加载
	public Module getModuleA() {		
		for(Module module:modules) {
			if(module instanceof ModuleA) {
				info2="模块A已经缓存，直接释放";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleA) {
					info2="模块A已缓存，直接释放";
					System.out.println(info2);
					return module;
				}
			}
			info2="模块A未缓存,先进行创建";
			System.out.println(info2);
			Module module=new ModuleA();
			modules.add(module);
			return module;
		}
	}
	
	public Module getModuleB() {
		for(Module module:modules) {
			if(module instanceof ModuleB) {
				info2="模块B已经缓存，直接释放";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleB) {
					info2="模块B已缓存，直接释放";
					System.out.println(info2);
					return module;
				}
			}
			info2="模块B未缓存,先进行创建";
			System.out.println(info2);
			Module module=new ModuleB();
			modules.add(module);
			return module;
		}
	}
	
	public Module getModuleC() {
		for(Module module:modules) {
			if(module instanceof ModuleC) {
				info2="模块C已经缓存，直接释放";
				System.out.println(info2);
				return module;
			}
		}
		
		synchronized(ModuleCacheComponent.class) {
			for(Module module:modules) {
				if(module instanceof ModuleC) {
					info2="模块C已缓存，直接释放";
					System.out.println(info2);
					return module;
				}
			}
			info2="模块未C缓存,先进行创建";
			System.out.println(info2);
			Module module=new ModuleC();
			modules.add(module);
			return module;
		}
	}
}
