import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.function.IntToDoubleFunction;
import java.util.jar.Pack200;

public class NearestPoint {
	
	private int arrRange=100;
	private Point arr[]=new Point[arrRange];
	private double minimun=1e20;//初始最大距离无穷大
	private Point near_p1;
	private Point near_p2;
	public NearestPoint() {
		arrProduce();
	}
	
	public void arrProduce() {
		int x;
		int y;
		Random random=new Random();
		for(int i=0;i<arr.length;i++) {
			x=random.nextInt(1000);
			y=random.nextInt(1000);
			arr[i]=new Point(x, y);
		}
	}
	
	public double computeDistance(Point p1,Point p2) {
		
		double distance =Math.sqrt(Math.pow(p1.getX()+p2.getX(), 2)+Math.pow(p1.getY()+p2.getY(), 2));
		return distance;
	}
	
	public void ExhaustiveMethod(){
		
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() < o2.getX())
					return -1;
				if (o1.getX() > o2.getX())
					return 1;
				if (o1.getY() < o2.getY())
					return -1;
				if (o1.getY() > o2.getY())
					return 1;
				return 0;
			}
		});
		Point nearestP1 = null;
		Point nearestP2 = null;
		double distance;

		for(int i=0;i<arrRange-1;i++) {
			for(int j=i+1;j<arrRange;j++) {
				distance=computeDistance(arr[i], arr[j]);
				if(distance<minimun) {
					minimun=distance;
					nearestP1=arr[i];
					nearestP2=arr[j];
				}
			}
		}
		

		System.out.println("穷举法最近点对为");
		System.out.println(nearestP1.getX()+","+nearestP1.getY());
		System.out.println(nearestP2.getX()+","+nearestP2.getY());
		System.out.println("距离为"+minimun);
	}
	
	public double MergeMethod(Point []arr,int left,int right) {
		int mid =(left+right)/2;
		
		if(left==right) {
			near_p1=arr[left];
			near_p2=arr[right];
			return 1e20;
		}
		if(left+1==right) {
			near_p1=arr[left];
			near_p2=arr[right];
			return computeDistance(arr[left],arr[right]);
		}
		
		double d1=MergeMethod(arr, left, mid);
		double d2=MergeMethod(arr, mid+1, right);
		
		double min=(d1>d2?d2:d1);
		
		ArrayList<Point> list=new ArrayList<>();
		for(int i=left;i<right+1;i++) {
			if(Math.abs(arr[i].getX()-arr[mid].getX())<=min) {
				list.add(arr[i]);
			}
		}
		
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() < o2.getX())
					return -1;
				if (o1.getX() > o2.getX())
					return 1;
				if (o1.getY() < o2.getY())
					return -1;
				if (o1.getY() > o2.getY())
					return 1;
				return 0;
			}
		});
		
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(j).getY()-list.get(i).getY()>min) break;
				double d=computeDistance(list.get(i), list.get(j));
				near_p1=arr[i];
				near_p2=arr[j];
				min=min>d?d:min;
			}
		}
		
		return min;
		
	}
	
	public void test() {//测试，使用collection接口进行排序
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() < o2.getX())
					return -1;
				if (o1.getX() > o2.getX())
					return 1;
				if (o1.getY() < o2.getY())
					return -1;
				if (o1.getY() > o2.getY())
					return 1;
				return 0;
			}
		});
		
		minimun=MergeMethod(arr, 0, arrRange-1);
		System.out.println("分治法");
		System.out.println(near_p1.getX()+","+near_p1.getY());
		System.out.println(near_p2.getX()+","+near_p2.getY());
		System.out.println("最近距离"+minimun);

		
	}
	
	
	public static void main(String[] args) {
		NearestPoint nearestPoint =new NearestPoint();
		nearestPoint.arrProduce();
		nearestPoint.ExhaustiveMethod();
		nearestPoint.test();

	}
	

}
