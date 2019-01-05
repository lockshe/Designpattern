

public class HanoiTower {
	
/*	��ŵ���õݹ�����˼·��:�������ӵ���������ʼ���Ǵ�����������Ƶ����ұ����ӣ�
	����ʵ���������������ı��ˣ�move(n-1,a,c,b)��move(n-1,b,a,c)����ʵ�����˼·*/
	public static int times=0;
	public static void Recursionmove(int n,String a,String b,String c) {
		if(n<=0) {
			return;
		}
		Recursionmove(n-1, a, c, b);
		System.out.println(a+"--->"+c);
		Recursionmove(n-1, b, a, c);
		times++;
	}
	
	public static void Generalmove(int n,String a,String b,String c) {
		
		String temp;
		if(n%2==0) {
			while(n<=0) {
				temp=c;
				c=b;
				b=temp;
				System.out.println(a+"--->"+c);
				
			}
			
		}
		else {
			
		}
	}
	
/*	��ŵ���ǵݹ��˼·��ͨ��ѭ��ִ��һ���Ĺ��ɣ�������Բ�̵��ƶ�
 *  �����������̿�֪n��Բ����Ҫ�ƶ�2^n-1��
 *  �����ǽ�Բ�̰�˳ʱ��ڷź�
 *  ���Բ�̸���Ϊż����ڷ�˳��ΪA,B,C
 *  ����Ϊ������ڷ�˳��ΪA,C,B
 *  �ƶ������ǣ�	�ӵ�һ�����ӿ�ʼ��������Բ���ƶ�����һ������
 *  		   	��Բ���ƶ�����һ�����Ӻ����ǿ�ʼ�Ƚϳ���Բ���ƶ��������������������
 *  			���߽��д�С�Ƚϣ�С���ƶ��������
 *  			�����������֮һΪ�գ���ֱ�Ӱ���һ�����ӵĶ���Բ���ƶ�������������
 *  			����������Ӿ�Ϊ����ô˵���ƶ����
 * */
	
	public static void UnRecursionmove(int n) {
		
		Stack stack[] =new Stack[3];//ջģ����������
		stack[0]=new Stack();
		stack[1]=new Stack();
		stack[2]=new Stack();
		if(n%2==0) {
			stack[0].name="A";
			stack[1].name="B";
			stack[2].name="C";
		}
		else {
			stack[0].name="A";
			stack[1].name="C";
			stack[2].name="B";
		}
		
		for(int i=n;i>0;i--) {
			stack[0].push(i);
		}
		
	
		int temp=0;
		int pans=0;
		while(true) {
		
			pans=stack[temp%3].pop();
			stack[(temp+1)%3].push(pans);
			System.out.println(stack[temp%3].name+"�ƶ���"+stack[(temp+1)%3].name);
			times++;
			temp++;
			if(!stack[(temp-1)%3].isEmpty()||!stack[(temp+1)%3].isEmpty()) {
				if(stack[(temp-1)%3].top()!=0&&(stack[(temp-1)%3].top()<stack[(temp+1)%3].top())||stack[(temp+1)%3].isEmpty()) {
					pans=stack[(temp-1)%3].pop();
					stack[(temp+1)%3].push(pans);
					System.out.println(stack[(temp-1)%3].name+"�ƶ���"+stack[(temp+1)%3].name);
					times++;
				}else {
					pans=stack[(temp+1)%3].pop();
					stack[(temp-1)%3].push(pans);
					System.out.println(stack[(temp+1)%3].name+"�ƶ���"+stack[(temp-1)%3].name);
					times++;
				}
			}else {
				return;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		HanoiTower.UnRecursionmove(16);
		long endTime=System.currentTimeMillis();
		
		System.out.println("16�㺺ŵ�����ݹ���ʱ"+(endTime-startTime)+"ms");
		System.out.println(HanoiTower.times+"���ƶ�");
		

	}

}
