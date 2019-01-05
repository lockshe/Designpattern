 

public class SortAlgorithm {
	
	public long BubbleSort(double arr[]) {
		
		double temp;
		long startTime=System.currentTimeMillis();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		long endTime=System.currentTimeMillis();

		long TotalTime=endTime-startTime;
		return TotalTime;
	}
	
	public long SelectionSort(double arr[]) {//选择最小的作为参照
		
		int minIndex;
		double temp;
		long startTime=System.currentTimeMillis();
		for(int i=0;i<arr.length-1;i++) {
			minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
				
				temp=arr[minIndex];
				arr[minIndex]=arr[i];
				arr[i]=temp;
				
			}
		}
		long endTime=System.currentTimeMillis();

		long TotalTime=endTime-startTime;
		return TotalTime;
	}
	
	public long InsertionSort(double arr[]) {
		
		double temp;
		long startTime=System.currentTimeMillis();
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0&&arr[j]<arr[j-1];j--) {
				temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
		long endTime=System.currentTimeMillis();
		long TotalTime=endTime-startTime;

		return TotalTime;
	    
	}
	
	public long MergeSort(double arr[]) {
		long startTime=System.currentTimeMillis();
		double temp[]=new double[arr.length];
		sort(0, arr.length-1, arr, temp);
		long endTime=System.currentTimeMillis();
		long TotalTime=endTime-startTime;
		return TotalTime;
		
	}
	
	public void sort(int left,int right,double arr[],double temp[]) {
		if(left<right) {
			int mid=(left+right)/2;
			sort(left, mid, arr, temp);
			sort(mid+1, right, arr, temp);
			merge(arr, left, mid, right, temp);
		}
	}
	public void merge(double[] arr,int left,int mid,int right,double[] temp) {
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
	

	public static void main(String[] args) {
		SortAlgorithm test=new SortAlgorithm();
		
		System.out.println("冒泡排序用时"+test.BubbleSort(RandomArrary.produce())+"ms");
		System.out.println("冒泡排序用时"+test.BubbleSort(RandomArrary.produce())+"ms");
		System.out.println("冒泡排序用时"+test.BubbleSort(RandomArrary.produce())+"ms");
		System.out.println("选择排序用时"+test.SelectionSort(RandomArrary.produce())+"ms");
		System.out.println("选择排序用时"+test.SelectionSort(RandomArrary.produce())+"ms");
		System.out.println("选择排序用时"+test.SelectionSort(RandomArrary.produce())+"ms");
		System.out.println("插入排序用时"+test.InsertionSort(RandomArrary.produce())+"ms");
		System.out.println("插入排序用时"+test.InsertionSort(RandomArrary.produce())+"ms");
		System.out.println("插入排序用时"+test.InsertionSort(RandomArrary.produce())+"ms");
		System.out.println("自顶向下归并排序用时"+test.MergeSort(RandomArrary.produce())+"ms");
		System.out.println("自顶向下归并排序用时"+test.MergeSort(RandomArrary.produce())+"ms");
		System.out.println("自顶向下归并排序用时"+test.MergeSort(RandomArrary.produce())+"ms");
	}

}
