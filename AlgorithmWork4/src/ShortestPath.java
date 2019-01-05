import java.util.Stack;

public class ShortestPath {

	//将12个点的有向无环图各点之间的距离转换成二维数组,无直接路径两点距离设为999
	final int max=9999;
	int x=max;
	int graph[][]= {
			{x	,9  ,7	,3	,2	,x	,x	,x	,x	,x	,x	,x},
			{x	,x	,x	,x	,x	,4	,2	,1	,x	,x	,x	,x},
			{x	,x	,x	,x	,x	,2	,7	,x	,x	,x	,x	,x},
			{x	,x	,x	,x	,x	,x	,x	,11	,x	,x	,x	,x},
			{x	,x	,x	,x	,x	,x	,11	,8	,x	,x	,x	,x},
			{x	,x	,x	,x	,x	,x	,x	,x	,6	,5	,x	,x},
			{x	,x	,x	,x	,x	,x	,x	,x	,4	,3	,x	,x},
			{x	,x	,x	,x	,x	,x	,x	,x	,x	,5	,6	,x},
			{x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,4},
			{x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,2},
			{x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,2},
			{x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,x	,x}
	};
	
	int initPtoeveryPointShortestPathValue[]=new int[12];
	Stack<Integer>PointSet =new Stack<>(); 
	
	public void findShortestPath() {
		initPtoeveryPointShortestPathValue[0]=0;
		for(int i=1;i<12;i++) {
			int min=max;
			for(int j=0;j<i;j++) {//i前面的点
				if(graph[j][i]<min) {//j到i有路径，继续判断
					if(graph[j][i]+initPtoeveryPointShortestPathValue[j]<min) {//j到i有路径而且加上初始点到j的距离之和还要小于当前最短路径（一开始初始化成无穷大）
						min=graph[j][i]+initPtoeveryPointShortestPathValue[j];
					}
				}
			}
			initPtoeveryPointShortestPathValue[i]=min;
		}
		
		for(int i=0;i<initPtoeveryPointShortestPathValue.length;i++) {
			System.out.println(i+1+"号点最短距离,"+initPtoeveryPointShortestPathValue[i]);
		}
	}
	
	//基于起始点到各点的最短距离进行计算
	//倒序计算，从末尾开始，即起始点到末尾点的最短距离，减去可以直接到达末尾点的点的最短距离算出来的值进行两点之间距离比对，相等就是那个点了
	public void findPointSet() {
		int i=11;
		PointSet.push(12);
		while(i>0){//起始点不用算进去
			for(int j=i-1;j>=0;j--) {
				if(graph[j][i]!=max) {
					int k=initPtoeveryPointShortestPathValue[i]-initPtoeveryPointShortestPathValue[j];
					if(k==graph[j][i]) {
						PointSet.push(j+1);
						i=j;
						break;
					}
				}
			}
		}
		
		System.out.print("其中一条最短路径为");
		while(!PointSet.empty()) {
			System.out.print(PointSet.pop()+"->");
		}
	}
	
	
	public static void main(String[] args) {
		ShortestPath tesShortestPath =new ShortestPath();
		tesShortestPath.findShortestPath();
		tesShortestPath.findPointSet();
	}

}
