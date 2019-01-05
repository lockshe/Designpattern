
public class ResourceAllocate {
	
	static int lastAllocate=6;//ȷ��ǰһ��һ��������٣�����Ľ��Ž��м���Ϳ��Եõ�������Ŀ�ķ�������
	int ResourceNum =6;
	int ProjectNum=3;
	double ResourceTable[][] = {
			{0	,1.2	,1.5	,1.85	,2.4	,2.8	,3.3},
			{0	,1.8	,2.0	,2.25	,2.4	,2.5	,2.6},
			{0	,1.3	,1.9	,2.2	,2.45	,2.7	,3.0},
	};
	
	double result[][] =new double [ProjectNum][ResourceNum+1];//������������Դ����������Լ�һ
	
	public void findMaxProfit() {
		
		//��ʼ����һ����Ŀ�ڸ�����Դ�µ����棬�����result������
		for(int i=0;i<=ResourceNum;i++) {
			result[0][i]=ResourceTable[0][i];
		}
		

		for(int i=1;i<ProjectNum;i++) {//iΪ��ǰ��Ŀ���
			for(int j=0;j<=ResourceNum;j++) {//jΪ��ǰ������Դ����
				double maxProfit=0;
				for(int k=0;k<=j;k++) {//kΪ�������ǰ��Ŀ����Դ��,ѭ���жϳ����ֵ
					double temp=ResourceTable[i][k]+result[i-1][j-k];//i-1������һ����Ŀ����Դ���
					if(temp>maxProfit) {
						maxProfit=temp;
						lastAllocate=j-k;
					}
				}
				result[i][j]=maxProfit;//����i����Ŀ�������j����Դ���������	
			}
		}
		
		for(int i=0;i<ProjectNum;i++) {
			for(int j=0;j<=ResourceNum;j++) {
				System.out.print(result[i][j]+",    ");
			}
			System.out.println();
		}
		
		System.out.println("��"+3+"����Ŀ����"+(ResourceNum-lastAllocate)+"����Դ");
		ResourceNum=lastAllocate;
		for(int i=1;i<ProjectNum-1;i++) {//iΪ��ǰ��Ŀ���
			for(int j=0;j<=ResourceNum;j++) {//jΪ��ǰ������Դ����
				double maxProfit=0;
				for(int k=0;k<=j;k++) {//kΪ�������ǰ��Ŀ����Դ��,ѭ���жϳ����ֵ
					double temp=ResourceTable[i][k]+result[i-1][j-k];//i-1������һ����Ŀ����Դ���
					if(temp>maxProfit) {
						maxProfit=temp;
						lastAllocate=j-k;
					}
				}
				result[i][j]=maxProfit;//����i����Ŀ�������j����Դ���������	
			}
		}
		

		System.out.println("��"+2+"����Ŀ����"+(ResourceNum-lastAllocate)+"����Դ");
		System.out.println("��"+1+"����Ŀ����"+lastAllocate+"����Դ");
		
	}
	
	public static void main(String[] args) {
		ResourceAllocate resourceAllocate=new ResourceAllocate();
		resourceAllocate.findMaxProfit();
	}	
}
