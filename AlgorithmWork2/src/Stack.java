/**
 * ��ջģ�⺺ŵ�����������ӣ�Բ���Ƚ����
 * ��ջ���Ƚ��������
 */
public class Stack {
	private final int MaxSize=64;//���ѵ�Բ�̸���
	
	private int hanoi[] =new int[MaxSize];
	private int pos=-1; 
	public String name;
	public int top(){
		if(!isEmpty())
		return hanoi[pos];
		else {
			return 0;
		}
	}
	 
	public void push(int x) {
		hanoi[++pos]=x;
	}
	
	public int pop() {
		return hanoi[pos--];
	}
	
	public boolean isEmpty() {
		if(pos==-1)
			return true;
		return false;
	}
	
}
