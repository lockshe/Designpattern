import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task {


	private int[][] cost = {	//对应花费
			{ 9, 2, 7, 8 },
			{ 6, 4, 3, 7 },
			{ 5, 8, 1, 8 },
			{ 7, 6, 9, 4 }
	};

	Comparator<Node> comparator = new Comparator<Node>() {//构造比较函数
		public int compare(Node o1, Node o2) {
			return o1.getLb() - o2.getLb();
		};
	};

	PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(comparator);//存储优先队列

	int results = 0;//记录当前最优解

	Node resultNode = null;//存储节点
	public Node initRootNode() {
		Node root = new Node();
		int lb = 0;
		for (int i = 0; i < cost.length; i++) {
			int min = cost[i][0];
			for (int j = 1; j < cost[0].length; j++) {
				if (min > cost[i][j]) {
					min = cost[i][j];
				}
			}
			lb += min;
		}
		root.setLb(lb);// 设置lb
		return root;
	}

	public int mostBound() {//计算初始值上界
		int bound = 0;
		for (int i = 0; i < cost.length; i++) {
			int max = cost[i][0];
			for (int j = 1; j < cost[i].length; j++) {
				if (max < cost[i][j]) {
					max = cost[i][j];
				}
			}
			bound += max;
		}
		return bound;
	}

	public void setResults(int results) {//设置结果
		this.results = results;
	}


	public void calculateLb(Node node) {//计算lb
		int lb = 0;
		ArrayList<Integer> upperNode = node.getUpperNode();
		int size = upperNode.size();
		for (int i = 0; i < size; i++) {// 计算已选person的界
			lb += cost[i][upperNode.get(i)];
		}

		for (int i = size; i < cost.length; i++) {// 计算剩余person的最小界
			int min = cost[i][0];
			for (int j = 1; j < cost[i].length; j++) {
				if (min > cost[i][j]) {
					min = cost[i][j];
				}
			}
			lb += min;
		}
		node.setLb(lb);// 更新节点lb
	}

	public ArrayList<Node> getChildNodes(Node node) {//计算孩子节点
		ArrayList<Node> childNodes = new ArrayList<Node>();// 孩子节点
		int i = node.getPerson() + 1;
		int order = 0;
		ArrayList<Integer> upperNode = node.getUpperNode();// 获取已经选择的job
		
		for (int j = 0; j < cost[i].length; j++) {
			if (upperNode == null || order >= upperNode.size()) {
				Node temp = getNode(i, j, upperNode);// 设置节点
				childNodes.add(temp);
			}
			else {
				if (order < upperNode.size() && !upperNode.contains(j)) {// 构造子节点
					Node temp = getNode(i, j, upperNode);// 设置节点
					childNodes.add(temp);
				}
				else
					order++;
			}
		}
		return childNodes;
	}

	public Node getNode(int i, int j, ArrayList<Integer> list) {
		ArrayList<Integer> uppers = new ArrayList<Integer>();
		if (list != null && list.size() > 0) {
			uppers.addAll(list);
		}
		uppers.add(j);
		Node temp = new Node(uppers);
		temp.setPerson(i);
		temp.setJob(j);
		calculateLb(temp);
		return temp;
	}

	public void assiginment(Node node) {
		setResults(mostBound());// 计算最大界
		priorityQueue.add(node);
		while (!priorityQueue.isEmpty()) {
			Node currentNode = priorityQueue.poll();
			if (currentNode.getPerson() < cost.length - 1) {
				ArrayList<Node> childNodes = getChildNodes(currentNode);
				for (Node child : childNodes) {
					if (child.getLb() < results) {
						priorityQueue.add(child);
					}
				}
			}
			else {
				if (currentNode.getLb() < results) {
					results = currentNode.getLb();
					resultNode = currentNode;
				}
			}
		}
	}

	public int getResults() {
		return results;
	}
	
	public Node getResultNode() {
		return resultNode;
	}
	
	public static void main(String[] args) {
		char people[]= {'a','b','c','d'};
		Task at = new Task();
		Node root = at.initRootNode();
		at.assiginment(root);
		ArrayList<Integer> list = at.getResultNode().getUpperNode();
		System.out.println("人员分配工作为：");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(people[i]+"员工选择"  + (list.get(i) + 1)+"号工作");
		}
		System.out.println("分配成本最小为：");
		System.out.print(at.getResults());
	}
}
