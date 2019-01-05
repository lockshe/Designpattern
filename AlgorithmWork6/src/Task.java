import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task {


	private int[][] cost = {	//��Ӧ����
			{ 9, 2, 7, 8 },
			{ 6, 4, 3, 7 },
			{ 5, 8, 1, 8 },
			{ 7, 6, 9, 4 }
	};

	Comparator<Node> comparator = new Comparator<Node>() {//����ȽϺ���
		public int compare(Node o1, Node o2) {
			return o1.getLb() - o2.getLb();
		};
	};

	PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(comparator);//�洢���ȶ���

	int results = 0;//��¼��ǰ���Ž�

	Node resultNode = null;//�洢�ڵ�
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
		root.setLb(lb);// ����lb
		return root;
	}

	public int mostBound() {//�����ʼֵ�Ͻ�
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

	public void setResults(int results) {//���ý��
		this.results = results;
	}


	public void calculateLb(Node node) {//����lb
		int lb = 0;
		ArrayList<Integer> upperNode = node.getUpperNode();
		int size = upperNode.size();
		for (int i = 0; i < size; i++) {// ������ѡperson�Ľ�
			lb += cost[i][upperNode.get(i)];
		}

		for (int i = size; i < cost.length; i++) {// ����ʣ��person����С��
			int min = cost[i][0];
			for (int j = 1; j < cost[i].length; j++) {
				if (min > cost[i][j]) {
					min = cost[i][j];
				}
			}
			lb += min;
		}
		node.setLb(lb);// ���½ڵ�lb
	}

	public ArrayList<Node> getChildNodes(Node node) {//���㺢�ӽڵ�
		ArrayList<Node> childNodes = new ArrayList<Node>();// ���ӽڵ�
		int i = node.getPerson() + 1;
		int order = 0;
		ArrayList<Integer> upperNode = node.getUpperNode();// ��ȡ�Ѿ�ѡ���job
		
		for (int j = 0; j < cost[i].length; j++) {
			if (upperNode == null || order >= upperNode.size()) {
				Node temp = getNode(i, j, upperNode);// ���ýڵ�
				childNodes.add(temp);
			}
			else {
				if (order < upperNode.size() && !upperNode.contains(j)) {// �����ӽڵ�
					Node temp = getNode(i, j, upperNode);// ���ýڵ�
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
		setResults(mostBound());// ��������
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
		System.out.println("��Ա���乤��Ϊ��");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(people[i]+"Ա��ѡ��"  + (list.get(i) + 1)+"�Ź���");
		}
		System.out.println("����ɱ���СΪ��");
		System.out.print(at.getResults());
	}
}
