

public class BottomUpSort {
	

	private double arr[];
	
	public long MergeSort() {
		long startTime=System.currentTimeMillis();

		BottomUp();

		long endTime=System.currentTimeMillis();
		long TotalTime=endTime-startTime;
		return TotalTime;
		
	}
	
	public void BottomUp() {
		int n=arr.length;
		double temp[]=new double[arr.length];
		int t=1;
		int s,i;
		while(t<n) {
			s=t;
			t=2*s;
			i=0;	 
			while(i+t<=n) {
				merge( i, i+s-1, i+t-1, temp);
				i=i+t;
			}
			if(i+s<n) {
				merge( i, i+s-1, n-1, temp);//判断是否为2的整数次幂
		}
	}
	}
	public void merge(int left,int mid,int right,double[] temp) {
		int i=left;
		int j=mid+1;
		int t=0;
		while(i<=mid&&j<=right) {
			if(arr[i]<=arr[j]) {
				temp[t++]=arr[i++];
			}
			else {
				temp[t++]=arr[j++];	
			}
		}
		
		while(i<=mid) {
			temp[t++]=arr[i++];
		}
		
		while(j<=right) {
			temp[t++]=arr[j++];	
		}
		
		t=0;
		while(left<=right) {
			arr[left++]=temp[t++];
		}
	}
	
	public void printArray() {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BottomUpSort test1=new BottomUpSort();
		BottomUpSort test2=new BottomUpSort();
		BottomUpSort test3=new BottomUpSort();
		System.out.println("自底向上归并排序用时"+test1.MergeSort()+"ms");
		System.out.println("自底向上归并排序用时"+test2.MergeSort()+"ms");
		System.out.println("自底向上归并排序用时"+test3.MergeSort()+"ms");
	
	}

}
