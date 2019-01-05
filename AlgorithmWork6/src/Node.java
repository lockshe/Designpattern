import java.util.ArrayList;

public class Node {
	int person = -1;
	int job = -1;
	int weight = 0;
	int lb = 0;

	ArrayList<Integer> upperNode;

	public Node() {
	}

	public Node(ArrayList<Integer> upperNode) {
		this.upperNode = upperNode;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLb() {
		return lb;
	}

	public void setLb(int lb) {
		this.lb = lb;
	}

	public ArrayList<Integer> getUpperNode() {
		return upperNode;
	}
	
	public void setUpperNode(ArrayList<Integer> upperNode) {
		this.upperNode = upperNode;
	}
}
