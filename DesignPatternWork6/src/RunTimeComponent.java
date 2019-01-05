/*
 * ���л����齨,����ͬ��getInstance()�����������л���
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
	
	//����ģʽ,ͬ��getInstace()�����������л���
	synchronized public static RunTimeComponent getInstance(String username,String password,int permission) {
		if(instance==null) {
			instance=new RunTimeComponent(username, password, permission);
			info="���ڹ������л������˺ţ�"+username+"   ����"+permission+"��";
			System.out.println(info);
		}else {
			info="�Ѿ���¼�����˺ţ����޷��ٴε�¼";
			System.out.println(info);
		}
		return instance;
	}

}
