

public class HanoiTower {
	
/*	汉诺塔用递归解决的思路是:交换柱子的索引，即始终是从最左边柱子移到最右边柱子，
	不过实际上是柱子索引改变了，move(n-1,a,c,b)和move(n-1,b,a,c)都是实现这个思路*/
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
	
/*	汉诺塔非递归的思路是通过循环执行一定的规律，最后完成圆盘的移动
 *  根据特征方程可知n个圆盘需要移动2^n-1次
 *  规律是将圆盘按顺时针摆放好
 *  如果圆盘个数为偶数则摆放顺序为A,B,C
 *  个数为奇数则摆放顺序为A,C,B
 *  移动规则是：	从第一个柱子开始，将顶部圆盘移动到下一个柱子
 *  		   	该圆盘移动到下一个柱子后，我们开始比较除掉圆盘移动到的柱子外的两个柱子
 *  			两者进行大小比较，小的移动到大的上
 *  			如果柱子其中之一为空，则直接把另一个柱子的顶部圆盘移动到空柱子上面
 *  			如果两个柱子均为空那么说明移动完成
 * */
	
	public static void UnRecursionmove(int n) {
		
		Stack stack[] =new Stack[3];//栈模拟三个柱子
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
			System.out.println(stack[temp%3].name+"移动到"+stack[(temp+1)%3].name);
			times++;
			temp++;
			if(!stack[(temp-1)%3].isEmpty()||!stack[(temp+1)%3].isEmpty()) {
				if(stack[(temp-1)%3].top()!=0&&(stack[(temp-1)%3].top()<stack[(temp+1)%3].top())||stack[(temp+1)%3].isEmpty()) {
					pans=stack[(temp-1)%3].pop();
					stack[(temp+1)%3].push(pans);
					System.out.println(stack[(temp-1)%3].name+"移动到"+stack[(temp+1)%3].name);
					times++;
				}else {
					pans=stack[(temp+1)%3].pop();
					stack[(temp-1)%3].push(pans);
					System.out.println(stack[(temp+1)%3].name+"移动到"+stack[(temp-1)%3].name);
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
		
		System.out.println("16层汉诺非塔递归用时"+(endTime-startTime)+"ms");
		System.out.println(HanoiTower.times+"次移动");
		

	}

}
