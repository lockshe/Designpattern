/**
 * 用栈模拟汉诺塔的三个柱子，圆盘先进后出
 * 和栈的先进后出相似
 */
public class Stack {
	private final int MaxSize=64;//最大堆叠圆盘个数
	
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
