public class Dijkstra {
    static float max = Float.MAX_VALUE;

    /**
     * 
     * @param v Դ
     * @param a ͼ
     * @param dist ·������
     * @param prev ·��
     */
    public static void dijkstra(int v, float[][] a, float[] dist, int[] prev) {
        // v��Դ��dist[i]��ʾ��ǰ��Դ������i���������·������,prev[i]=j�����·���ж���i��ǰһ��������j������������
        int n = dist.length - 1;// �ڵ�����������±���㿪ʼ���Ҫ��һ
        if (v < 1 || v > n)
            return;
        boolean[] s = new boolean[n + 1];
        // ��ʼ��
        for (int i = 1; i <= n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] == Float.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;

        for (int i = 1; i < n; i++) {// ѭ��n-1��
            float temp = Float.MAX_VALUE;
            int u = v;
            for (int j = 1; j <= n; j++) {// Ѱ�Ҳ��ڼ������Ҿ��뼯������Ľڵ�j
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;// ��¼�ڵ�
                    temp = dist[j];// ��¼�������·������
                }
            }

            s[u] = true;// ���ڵ�u���뼯��

            for (int j = 1; j <= n; j++) {// ��������dist[]��prev[]��ֵ
                if ((!s[j]) && (a[u][j] < Float.MAX_VALUE)) {// Ѱ�Ҳ��ڼ����ڣ��ҿɴ�Ľڵ�
                    float newdist = dist[u] + a[u][j];
                    if (newdist < dist[j]) { // ���ֵ���бȽϣ�����С��ֵ
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
		float[][] a = { 
				{ max,max, max, max, max, max, max, max, max, max, max, max, max },
				{ max, 0, 9, 7, 3, 2, max, max, max, max, max, max, max },//�ڽӾ���
				{ max,max, 0, max, max, max, 4, 2, 1, max, max, max, max },
				{ max,max, max, 0, max, max, 2, 7, max, max, max, max, max },
				{ max,max, max, max, 0, max, max, max, 11, max, max, max, max },
				{ max,max, max, max, max, 0, max, 11, 8, max, max, max, max },
				{ max,max, max, max, max, max, 0, max, max, 6, 5, max, max },
				{ max,max,max, max, max, max, max, 0, max, 4, 3, max, max },
				{ max,max, max, max, max, max, max, max, 0, max, 5, 6, max },
				{ max,max,max, max, max, max, max, max, max, max, 0, max, 4 },
				{ max,max, max, max, max, max, max, max, max, max, 0, max, 2 },
				{ max,max, max, max, max, max, max, max, max, max, max, 0, 5 },
				{ max,max, max, max, max, max, max, max, max, max, max, max, 0 },
        };
        int n = a.length;
        float[] dist = new float[n];//��¼Դ��v������ÿ�������̾���
        int[] prev = new int[n];//��¼һ�����·����ÿ�����ǰ�����
        dijkstra(1, a, dist, prev);//Դ��Ϊ1
        for(int i=2;i<n;i++) {
        	System.out.println(" ����1��"+i+"�����·����");
        	trace(prev, i);
        	System.out.println(" ����Ϊ"+dist[i]);
        }
      
    }

    public static void trace(int[] prev, int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        trace(prev, prev[n]);
        System.out.print(n + " ");
    }
}
