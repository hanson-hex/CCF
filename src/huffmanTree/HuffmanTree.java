package huffmanTree;
import java.util.*;

import org.w3c.dom.NodeList;
public class HuffmanTree {
	public static Node createHuffmanTree(List<Node> nodeList) {
		while(nodeList.size() > 1) {
			quickSort(nodeList);
			Node firstNode = nodeList.get(0);
			Node secondNode = nodeList.get(1);
			Node parent = new Node("", firstNode.weight + secondNode.weight);
			nodeList.add(parent);
			parent.lChild = firstNode;
			parent.rChild = secondNode;
			nodeList.remove(firstNode);
			nodeList.remove(secondNode);
			
		}
		return nodeList.get(0);
	}
	public static void subSort(List<Node> nodeList, int start, int end) {
		if (start < end) {
			Node base = nodeList.get(start);
			int i = start;
			int j = end + 1;
			while(true) {
				while (i < end && nodeList.get(++i).weight <= base.weight);
				while (j > start && nodeList.get(--j).weight >= base.weight);
				if (i < j) {
					swap(nodeList, i , j);
				} else {
					break;
				}
			}
			swap(nodeList, start, i);
			subSort(nodeList, start, i - 1);
			subSort(nodeList, j + 1, end);
			
		}
	}
	public static void swap(List<Node> nodeList, int i, int j) {
		Node temp = nodeList.get(i);
		nodeList.set(i, nodeList.get(j));
		nodeList.set(j, temp);
	}
	public static void quickSort(List<Node> nodeList) {
		subSort(nodeList, 0, nodeList.size() - 1);
	}
	public static void start() {
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new Node("A", 2));
		nodeList.add(new Node("B", 6));
		nodeList.add(new Node("C", 4));
		nodeList.add(new Node("D", 10));
		nodeList.add(new Node("E", 9));
		nodeList.add(new Node("F", 1));
		nodeList.add(new Node("G", 3));
		Node root = createHuffmanTree(nodeList);
		
	}
}

class Node {
	String data;
	double weight;
	Node lChild;
	Node rChild;
	public Node(String data, double weight) {
		this.data = data;
		this.weight = weight;
	}
	public String toString() {
		return "Node[data:" + this.data + ",weight=" + this.weight + "]";
	}
}


