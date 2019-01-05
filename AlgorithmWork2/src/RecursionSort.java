
public class RecursionSort {
	public static double arr[]=RecursionSort.produce();
	
	public static double[] produce() {
		double temp;
		double arr[]=new double [10000];
		for(int i=0;i<arr.length;i++) {
			temp=Math.random();
			arr[i]=temp;
		}

		return arr;
	}

	/*µ›πÈ√∞≈›≈≈–Ú*/
	public static void RecurBubbleSort(int n) {
		double temp=0;
		if(n==1) {
			return ;
		}
		for(int j=0;j<n-1;j++) {
			if(arr[j]>arr[j+1]) {
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
			
		}
		RecursionSort.RecurBubbleSort(n-1);
		
	}
	
	/*µ›πÈ—°‘Ò≈≈–Ú*/
	public static void RecurSelectionSort(int n) {
		double temp;
		int minIndex=arr.length-n;
		if(n==1) {
			return;
		}
		
		for(int j=minIndex+1;j<arr.length;j++) {
			if(arr[j]<arr[minIndex]) {
				minIndex=j;
			}
			
			temp=arr[minIndex];
			arr[minIndex]=arr[j];
			arr[j]=temp;
		}
		RecurSelectionSort(n-1);
	}

	/*µ›πÈ≤Â»Î≈≈–Ú*/
	public static void RecurInsertionSort(int n) {
		double temp;
		if(n==1) {
			return ;
		}
		for(int j=arr.length-n+1;j>0;j--) {
			if(arr[j]>arr[j-1]) {
				temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
		 RecurInsertionSort(n-1);
	}
	public static void main(String[] args) {
		
		long startTime=System.currentTimeMillis();
		RecursionSort.RecurInsertionSort(arr.length);
		long endTime=System.currentTimeMillis();
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(RecursionSort.arr[i]);
		}

		System.out.println("µ›πÈ≤Â»Î≈≈–Ú”√ ±"+(endTime-startTime)+"ms");
		
	}

}
