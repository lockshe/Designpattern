public class Dijkstra {
    static float max = Float.MAX_VALUE;

    /**
     * 
     * @param v 源
     * @param a 图
     * @param dist 路径长度
     * @param prev 路径
     */
    public static void dijkstra(int v, float[][] a, float[] dist, int[] prev) {
        // v是源，dist[i]表示当前从源到顶点i的最短特殊路径长度,prev[i]=j：最短路径中顶点i的前一个顶点是j，类似于链表
        int n = dist.length - 1;// 节点个数，数组下标从零开始因此要减一
        if (v < 1 || v > n)
            return;
        boolean[] s = new boolean[n + 1];
        // 初始化
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

        for (int i = 1; i < n; i++) {// 循环n-1次
            float temp = Float.MAX_VALUE;
            int u = v;
            for (int j = 1; j <= n; j++) {// 寻找不在集合内且距离集合最近的节点j
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;// 记录节点
                    temp = dist[j];// 记录最短特殊路径长度
                }
            }

            s[u] = true;// 将节点u放入集合

            for (int j = 1; j <= n; j++) {// 重新设置dist[]和prev[]的值
                if ((!s[j]) && (a[u][j] < Float.MAX_VALUE)) {// 寻找不在集合内，且可达的节点
                    float newdist = dist[u] + a[u][j];
                    if (newdist < dist[j]) { // 与旧值进行比较，保留小的值
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
				{ max, 0, 9, 7, 3, 2, max, max, max, max, max, max, max },//邻接矩阵
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
        float[] dist = new float[n];//记录源点v到其它每个点的最短距离
        int[] prev = new int[n];//记录一条最短路径，每个点的前驱结点
        dijkstra(1, a, dist, prev);//源点为1
        for(int i=2;i<n;i++) {
        	System.out.println(" 顶点1到"+i+"的最短路径：");
        	trace(prev, i);
        	System.out.println(" 距离为"+dist[i]);
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
