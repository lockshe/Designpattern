
public class RandomArrary {//随机数组生成类
	
	public static double[] produce() {
		double temp;
		double arr[]=new double [10000];
		for(int i=0;i<arr.length;i++) {
			temp=Math.random();
			arr[i]=temp;
		}

		return arr;
	}

}
