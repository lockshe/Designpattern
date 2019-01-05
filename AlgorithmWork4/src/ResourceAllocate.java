
public class ResourceAllocate {
	
	static int lastAllocate=6;//确定前一个一个分配多少，后面的接着进行计算就可以得到所有项目的分配数量
	int ResourceNum =6;
	int ProjectNum=3;
	double ResourceTable[][] = {
			{0	,1.2	,1.5	,1.85	,2.4	,2.8	,3.3},
			{0	,1.8	,2.0	,2.25	,2.4	,2.5	,2.6},
			{0	,1.3	,1.9	,2.2	,2.45	,2.7	,3.0},
	};
	
	double result[][] =new double [ProjectNum][ResourceNum+1];//包含不分配资源的情况，所以加一
	
	public void findMaxProfit() {
		
		//初始化第一个项目在给定资源下的收益，存放在result数组中
		for(int i=0;i<=ResourceNum;i++) {
			result[0][i]=ResourceTable[0][i];
		}
		

		for(int i=1;i<ProjectNum;i++) {//i为当前项目标号
			for(int j=0;j<=ResourceNum;j++) {//j为当前给定资源总数
				double maxProfit=0;
				for(int k=0;k<=j;k++) {//k为分配给当前项目的资源数,循环判断出最大值
					double temp=ResourceTable[i][k]+result[i-1][j-k];//i-1就是上一个项目的资源情况
					if(temp>maxProfit) {
						maxProfit=temp;
						lastAllocate=j-k;
					}
				}
				result[i][j]=maxProfit;//即第i个项目，分配给j个资源的最大利润	
			}
		}
		
		for(int i=0;i<ProjectNum;i++) {
			for(int j=0;j<=ResourceNum;j++) {
				System.out.print(result[i][j]+",    ");
			}
			System.out.println();
		}
		
		System.out.println("第"+3+"个项目分配"+(ResourceNum-lastAllocate)+"个资源");
		ResourceNum=lastAllocate;
		for(int i=1;i<ProjectNum-1;i++) {//i为当前项目标号
			for(int j=0;j<=ResourceNum;j++) {//j为当前给定资源总数
				double maxProfit=0;
				for(int k=0;k<=j;k++) {//k为分配给当前项目的资源数,循环判断出最大值
					double temp=ResourceTable[i][k]+result[i-1][j-k];//i-1就是上一个项目的资源情况
					if(temp>maxProfit) {
						maxProfit=temp;
						lastAllocate=j-k;
					}
				}
				result[i][j]=maxProfit;//即第i个项目，分配给j个资源的最大利润	
			}
		}
		

		System.out.println("第"+2+"个项目分配"+(ResourceNum-lastAllocate)+"个资源");
		System.out.println("第"+1+"个项目分配"+lastAllocate+"个资源");
		
	}
	
	public static void main(String[] args) {
		ResourceAllocate resourceAllocate=new ResourceAllocate();
		resourceAllocate.findMaxProfit();
	}	
}
