package ary;
import java.util.Comparator;
import java.util.PriorityQueue;

// Using heap and trie
// This can be achived using Hashmap as well.
public class KFrequentWords {

	public static void main(String[] args) {
		int k = 2;
		String[] words = new String[7];
		words[0] = "abc";
		words[1] = "abc";
		words[2] = "geh";
		words[3] = "geh";
		words[4] = "abc";
		words[5] = "def";
		words[6] = "def";
		PriorityQueue<HNode> q = getFrequentKwords(k, words);

		for (HNode node : q) {
			System.out.println(node.word);
		}
	}
 // word by word we add element in trie.
	// for every word inserted in trie occurance will be incremeted.
	// for every inserted below checks will be performed in heap
	// if element already exist in q... fetch it ... remove it and add it.. as occurance is increased by 1.
	// else if we have space left in q and elment is not present simply add it.
	// else if compare the occurance of current word with min heap top element. 
	// whoever wins in terms of occurance put it in heap and remove other.
	private static PriorityQueue<HNode> getFrequentKwords(int k, String[] words) {
		PriorityQueue<HNode> q = new PriorityQueue<HNode>(k, new Comparator<HNode>() {

			@Override
			public int compare(HNode o1, HNode o2) {
				return o1.occurance - o2.occurance;
			}
		}); // min heap minimum at the top.
		Trie tri = new Trie();
		for (String word : words) {
			TNode tNode = tri.add(word);
			if (q.contains(tNode.ref)) {// this is required to trigger the sorting again.
				q.remove(tNode.ref);
				q.add(tNode.ref);
			} else {
				if (q.size() < k) {
					HNode node = new HNode();
					node.word = tNode.word;
					node.occurance = tNode.occurance;
					tNode.ref = node;
					q.offer(node);
				} else {
					HNode element = q.element();
					if (tNode.occurance > element.occurance) {
						q.poll();
						HNode node = new HNode();
						node.word = tNode.word;
						node.occurance = tNode.occurance;
						tNode.ref = node;
						q.offer(node);
					}
				}
			}
		}

		return q;
	}

}

class HNode {
	String word;
	int occurance;
}

class TNode {
	TNode[] ary = new TNode[26];
	String word;
	boolean end;
	int occurance;
	HNode ref; // connecting triNode with HeapNode.
}

class Trie {
	TNode root;

	public Trie() {
		root = new TNode();
	}

	public TNode add(String word) {
		TNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.ary[word.charAt(i) - 'a'] == null) {
				current.ary[word.charAt(i) - 'a'] = new TNode();
			}
			current = current.ary[word.charAt(i) - 'a'];
		}
		current.word = word;
		current.end = Boolean.TRUE;
		current.occurance += 1;
		return current;
	}
}