import java.util.Random;

public class MaximunSubarry {



	private location left=new location();
	private location right=new location();
	private location cross=new location();
	
	

	public location Find_Maxcrossing_Subarray(int arr[],int low,int mid,int high){
		int leftsum=(int) -1e10;
		int rightsum=(int)-1e10;
		int sum=0;
		int max_left=0;
		int max_right=0;
		for(int i=mid;i>=low;i--) {
			sum=sum+arr[i];
			if(sum>leftsum) {
				leftsum=sum;
				max_left=i;
			}
		}
		
		sum=0;
		for(int j=mid+1;j<=high;j++) {
			sum=sum+arr[j];
			if(sum>rightsum) {
				rightsum=sum;
				max_right=j;
			}
		}
		
		return new location(max_left, max_right, leftsum+rightsum);
	}
	
	public location Find_Maximum_Subarray(int arr[],int low,int high) {

		if(low==high){
			return new location(low,high,arr[low]);
		}
		else {
			int mid=(low+high)/2;
			
			left=Find_Maximum_Subarray(arr, low, mid);
			right=Find_Maximum_Subarray(arr, mid+1,high);
			cross=Find_Maxcrossing_Subarray(arr, low, mid, high);
			
			if(left.sum>=right.sum &&left.sum>=cross.sum)
				return new location(left.low, left.high, left.sum);
			else if(right.sum>=left.sum&&right.sum>=cross.sum)
				return new location(right.low, right.high, right.sum);
			else 
				return new location(cross.low, cross.high, cross.sum);
		}
	}
	
	public void Find_By_ExhaustiveMethod(int arr[]) {
		int sum=0;
		int left=0;
		int right=0;

		for(int i=0;i<arr.length;i++) {
			int temp=0;
			for(int j=i;j<arr.length;j++) {
				temp+=arr[j];
				if(temp>sum) {
					sum=temp;
					left=i;
					right=j;
				}
			}
		}
		
		System.out.println("穷举法"+left+","+right+","+"最大和为"+sum);
	}


	public static void main(String[] args) {
		int arr[]={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		MaximunSubarry maximunSubarry=new MaximunSubarry();
		location lcoLocation=maximunSubarry.Find_Maximum_Subarray(arr, 0, arr.length-1);
		System.out.println("分治法"+lcoLocation.low+","+lcoLocation.high+","+"最大和为"+lcoLocation.sum);
		maximunSubarry.Find_By_ExhaustiveMethod(arr);
	}

}
