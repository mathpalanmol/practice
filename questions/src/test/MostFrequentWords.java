package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentWords {

	public static void main(String[] args) {
		String str = "input long string";
		String[] tokens = str.split(" ");
		Node[] nodes = new Node[tokens.length];
		int index = 0;
		for (String word : tokens) {
			nodes[index++] = new Node(word, 1);
		}
		Integer frequentWordCount = 5;

		PriorityQueue<Node> freqWords = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.count - o1.count;
			}

		});
		PriorityQueue<Node> freqWords = getFrequentWords(str.split(" "), freqWords, frequentWordCount);
	}

	private static PriorityQueue<Node> getFrequentWords(Node[] tokens, PriorityQueue<Node> freqWords,
			Integer frequentWordCount) {

		Map<Node, Integer> words = new HashMap<Node, Integer>();
		for (Node node : tokens) {
			if (words.containsKey(node)) {
				words.put(node, words.get(node) + 1);// update the count
				node.count++; //maintaing it for pq. otherwise map value will be sufficient to maintain count.
			} else {
				words.put(node, 1);
			}
			updateQ(node, freqWords, frequentWordCount);
		}

		return freqWords;
	}

	private static void updateQ(Node node, PriorityQueue<Node> freqWords, Integer frequentWordCount) {
		freqWords.
		if(freqWords.contains(node)) {
			frequentWordCount.
		}
	}

	static class Node {
		String word;
		Integer count;

		public Node(String word, Integer count) {
			super();
			this.word = word;
			this.count = count;
		}

	}

}
