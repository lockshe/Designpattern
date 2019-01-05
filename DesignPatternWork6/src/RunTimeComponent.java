/*
 * 运行环境组建,采用同步getInstance()方法构建运行环境
 */
public class RunTimeComponent {
	
	private static RunTimeComponent instance =null;
	
	private String username;
	
	private String password;
	
	private int permission;
	
	private static String info=null;
	
	private RunTimeComponent(String username,String password,int permission) {
		this.username=username;
		this.password=password;
		this.permission=permission;
	}
	
	//单例模式,同步getInstace()方法创建运行环境
	synchronized public static RunTimeComponent getInstance(String username,String password,int permission) {
		if(instance==null) {
			instance=new RunTimeComponent(username, password, permission);
			info="正在构建运行环境，账号："+username+"   级别"+permission+"级";
			System.out.println(info);
		}else {
			info="已经登录其他账号！！无法再次登录";
			System.out.println(info);
		}
		return instance;
	}

}
