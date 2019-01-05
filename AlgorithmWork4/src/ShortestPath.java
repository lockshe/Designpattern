import java.util.Stack;

public class ShortestPath {

	//��12����������޻�ͼ����֮��ľ���ת���ɶ�ά����,��ֱ��·�����������Ϊ999
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
			for(int j=0;j<i;j++) {//iǰ��ĵ�
				if(graph[j][i]<min) {//j��i��·���������ж�
					if(graph[j][i]+initPtoeveryPointShortestPathValue[j]<min) {//j��i��·�����Ҽ��ϳ�ʼ�㵽j�ľ���֮�ͻ�ҪС�ڵ�ǰ���·����һ��ʼ��ʼ���������
						min=graph[j][i]+initPtoeveryPointShortestPathValue[j];
					}
				}
			}
			initPtoeveryPointShortestPathValue[i]=min;
		}
		
		for(int i=0;i<initPtoeveryPointShortestPathValue.length;i++) {
			System.out.println(i+1+"�ŵ���̾���,"+initPtoeveryPointShortestPathValue[i]);
		}
	}
	
	//������ʼ�㵽�������̾�����м���
	//������㣬��ĩβ��ʼ������ʼ�㵽ĩβ�����̾��룬��ȥ����ֱ�ӵ���ĩβ��ĵ����̾����������ֵ��������֮�����ȶԣ���Ⱦ����Ǹ�����
	public void findPointSet() {
		int i=11;
		PointSet.push(12);
		while(i>0){//��ʼ�㲻�����ȥ
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
		
		System.out.print("����һ�����·��Ϊ");
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
