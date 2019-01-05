import java.util.Scanner;

public class HuffmanCode {
	// �������Ľڵ���
	static class Node {
		int weight;// Ƶ��
		int parent;
		int leftChild;
		int rightChild;

		public Node(int weight, int parent, int leftChild, int rightChild) {
			this.weight = weight;
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		void setWeight(int weight) {
			this.weight = weight;
		}

		void setParent(int parent) {
			this.parent = parent;
		}

		void setLeftChild(int leftChild) {
			this.leftChild = leftChild;
		}

		void setRightChild(int rightChild) {
			this.rightChild = rightChild;
		}

		int getWeight() {
			return weight;
		}

		int getParent() {
			return parent;
		}

		int getLeftChild() {
			return leftChild;
		}

		int getRightChild() {
			return rightChild;
		}
	}

	// �½�����������
	static class NodeCode {
		String character;
		String code;

		NodeCode(String character, String code) {
			this.character = character;
			this.code = code;
		}

		NodeCode(String code) {
			this.code = code;
		}

		void setCharacter(String character) {
			this.character = character;
		}

		void setCode(String code) {
			this.code = code;
		}

		String getCharacter() {
			return character;
		}

		String getCode() {
			return code;
		}
	}

	// ��ʼ��һ��huffuman��
	public static void initHuffmanTree(Node[] huffmanTree, int m) {
		for (int i = 0; i < m; i++) {
			huffmanTree[i] = new Node(0, -1, -1, -1);
		}
	}

	// ��ʼ��һ��huffmanCode
	public static void initHuffmanCode(NodeCode[] huffmanCode, int n) {
		for (int i = 0; i < n; i++) {
			huffmanCode[i] = new NodeCode("", "");
		}
	}

	// ��ȡhuffmanCode�ķ���
	public static void getHuffmanCode(NodeCode[] huffmanCode, int n) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			String temp = input.next();
			huffmanCode[i] = new NodeCode(temp, "");
		}
	}

	// ��ȡhuffman���ڵ�Ƶ��
	public static void getHuffmanWeight(Node[] huffmanTree, int n) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			int temp = input.nextInt();
			huffmanTree[i] = new Node(temp, -1, -1, -1);
		}
	}

	// ��n�������ѡȡ��С���������,�Ե����Ͻ���
	public static int[] selectMin(Node[] huffmanTree, int n) {
		int min[] = new int[2];
		class TempNode {
			int newWeight;// �洢Ȩ
			int place;// �洢�ý�����ڵ�λ��

			TempNode(int newWeight, int place) {
				this.newWeight = newWeight;
				this.place = place;
			}

			void setNewWeight(int newWeight) {
				this.newWeight = newWeight;
			}

			void setPlace(int place) {
				this.place = place;
			}

			int getNewWeight() {
				return newWeight;
			}

			int getPlace() {
				return place;
			}
		}

		TempNode[] tempTree = new TempNode[n];

		// ��huffmanTree��û��˫�׵Ľ��洢��tempTree��
		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			if (huffmanTree[i].getParent() == -1 && huffmanTree[i].getWeight() != 0) {
				tempTree[j] = new TempNode(huffmanTree[i].getWeight(), i);
				j++;
			}
		}

		int m1, m2;
		m1 = m2 = 0;
		for (i = 0; i < j; i++) {
			if (tempTree[i].getNewWeight() < tempTree[m1].getNewWeight())// �˴�����ȡ����ȣ�����Ϊ���������ͬȨֵ��ʱ��m1ȡ��ǰ��
				m1 = i;
		}
		for (i = 0; i < j; i++) {
			if (m1 == m2)
				m2++;// ��m1�ڵ�һ��λ�õ�ʱ��m2�����һλ
			if (tempTree[i].getNewWeight() <= tempTree[m2].getNewWeight() && i != m1)// �˴�ȡ����ȣ������ڽ��������ͬ��Ȩֵ��ʱ�� m2ȡ�����Ǹ���
				m2 = i;
		}

		min[0] = tempTree[m1].getPlace();
		min[1] = tempTree[m2].getPlace();
		return min;
	}

	// ����huffmanTree
	public static void createHaffmanTree(Node[] huffmanTree, int n) {
		if (n <= 1)
			System.out.println("Parameter Error!");
		int m = 2 * n - 1;
		// initHuffmanTree(huffmanTree,m);

		for (int i = n; i < m; i++) {
			int[] min = selectMin(huffmanTree, i);
			int min1 = min[0];
			int min2 = min[1];
			huffmanTree[min1].setParent(i);
			huffmanTree[min2].setParent(i);
			huffmanTree[i].setLeftChild(min1);
			huffmanTree[i].setRightChild(min2);
			huffmanTree[i].setWeight(huffmanTree[min1].getWeight() + huffmanTree[min2].getWeight());
		}
	}

	// ����huffmanCode
	public static void createHaffmanCode(Node[] huffmanTree, NodeCode[] huffmanCode, int n) {
		Scanner input = new Scanner(System.in);
		char[] code = new char[10];
		int start;
		int c;
		int parent;
		int temp;

		code[n - 1] = '0';
		for (int i = 0; i < n; i++) {
			StringBuffer stringBuffer = new StringBuffer();
			start = n - 1;
			c = i;
			while ((parent = huffmanTree[c].getParent()) >= 0) {
				start--;
				code[start] = ((huffmanTree[parent].getLeftChild() == c) ? '0' : '1');
				c = parent;

			}
			for (; start < n - 1; start++) {
				stringBuffer.append(code[start]);
			}
			huffmanCode[i].setCode(stringBuffer.toString());
		}
	}

	// ���hufmanCode
	public static void ouputHaffmanCode(NodeCode[] huffmanCode, int n) {
		System.out.println("�ַ������Ķ�Ӧ��ϵ���£�");
		for (int i = 0; i < n; i++) {
			System.out.println(huffmanCode[i].getCharacter() + ":" + huffmanCode[i].getCode());
		}
	}

	// ������
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int m;
		System.out.print("�������ַ�������");
		n = input.nextInt();
		m = 2 * n - 1;
		Node[] huffmanTree = new Node[m];
		NodeCode[] huffmanCode = new NodeCode[n];

		// ��ʼ��huffmanTree,huffmanCode
		initHuffmanTree(huffmanTree, m);
		initHuffmanCode(huffmanCode, n);

		// ��ȡhuffmanCode�ķ���
		System.out.print("�����������������ַ���");
		getHuffmanCode(huffmanCode, n);

		// ��ȡhuffmanTree��Ƶ��
		System.out.print("����������������ַ���Ӧ��Ƶ����");
		getHuffmanWeight(huffmanTree, n);

		// ����huffmanTree
		createHaffmanTree(huffmanTree, n);
		// ����huffmanCode
		createHaffmanCode(huffmanTree, huffmanCode, n);

		// ���huffmanCode����
		ouputHaffmanCode(huffmanCode, n);

	}
}