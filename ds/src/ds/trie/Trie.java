package ds.trie;

// Insert and search costs O(key_length), however the memory requirements of trie is O(ALPHABET_SIZE * key_length * N) for abab(2bytes for character*4*26)
// where N is number of keys in trie. 
// each node in a trie represents a prefix of the stored strings
// Tries are also called as Lexicographic Search trees.
// The complexities of the search ,delete and insert operations were given by O(h) where the height h is dependent on the number of keys represented in the search tree
// Auto-complete functionality is used widely over the internet and mobile apps. A lot of websites and apps try to complete your input as soon as you start typing.• All the descendants of a node have a common prefix of the string associated with that node.
// Trie is also known as Prefix tree.
// we can create suffix tree using trie... for word abab, first put abab(index 0) then bab(index 1) the ab(index 2) then b(index 3)
// suffix tree is used to find common substring problem in linear time

public class Trie {

	static Node node;

	Trie() {
		node = new Node(); //starts with empty node
	}

	// a trie is a tree-like data structure in which each node contains an array
	// of pointers,
	class Node {
		Node[] pointerAry = new Node[26];
		boolean end = false; // isWord, if it's last character of a word mark it true
	}

	public void delete(String word) {
		char[] chAry = word.toCharArray();
		Node current = node;
		delete(chAry, current, -1);
	}

	private void delete(char[] chAry, Node current, int index) {
		if (index == chAry.length-1) {
			return;
		} else {
			delete(chAry, current.pointerAry[chAry[++index] - 'a'], index);
			// check if is having other pointers
			boolean markDelete = check(current.pointerAry[chAry[++index] - 'a']);
			if (markDelete)
				current = null;
			else
				current.end = false;

		}
	}

	private boolean check(Node current) {
		for (int i = 0; i < current.pointerAry.length; i++) {
			if (current.pointerAry[i] != null)
				return false;
		}
		return true;
	}

	public void insert(String word) {
		char[] chars = word.toCharArray();
		Node current = node;
		int k = 0;//character count in given word.
		while (k < chars.length) {
			if (current.pointerAry[chars[k] - 'a'] == null) { //-a is equivalent to -65 to get 65-65=0 index for a, for b it is 66-65=1 and so on...
				current.pointerAry[chars[k] - 'a'] = new Node();
				current = current.pointerAry[chars[k] - 'a'];// remove it and
																// remove else
			} else
				current = current.pointerAry[chars[k] - 'a'];
			k++;
		}
		current.end = true;

	}

	public boolean find(String word) {
		char[] chars = word.toCharArray();
		Node current = node;
		int k = 0;
		while (k < chars.length) {
			if (current == null)
				return false;
			if (current.pointerAry[chars[k] - 'a'] == null) {
				System.out.println("String not found1");
				return false;
			}

			current = current.pointerAry[chars[k] - 'a'];
			k++;
		}
		if (current != null && current.end == false) {
			System.out.println("String not found");
			return false;
		}

		System.out.println("String found");
		return true;
	}

	static void print(){
		Node current = node;
		while(current != null){
			for(int i=0; i< current.pointerAry.length; i++){
				System.out.print("|" + current.pointerAry[i] + "|" );
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.insert("animal");
		trie.insert("anmola");
		trie.insert("ankit");
		// trie.find("anmola");
		// trie.display();
		trie.find("anmola");
		trie.delete("anmol");
//		print();
	}

}
// TRIE using hashmap
// class TrieNode {
// char c;
// HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
// boolean isLeaf;
//
// public TrieNode() {}
//
// public TrieNode(char c){
// this.c = c;
// }
// }
//
//// Inserts a word into the trie.
// public void insert(String word) {
// HashMap<Character, TrieNode> children = root.children;
//
// for(int i=0; i<word.length(); i++){
// char c = word.charAt(i);
//
// TrieNode t;
// if(children.containsKey(c)){
// t = children.get(c);
// }else{
// t = new TrieNode(c);
// children.put(c, t);
// }
//
// children = t.children;
//
// //set leaf node
// if(i==word.length()-1)
// t.isLeaf = true;
// }
// }
//
//// Returns if the word is in the trie.
// public boolean search(String word) {
// TrieNode t = searchNode(word);
//
// if(t != null && t.isLeaf)
// return true;
// else
// return false;
// }
//
//// Returns if there is any word in the trie
//// that starts with the given prefix.
// public boolean startsWith(String prefix) {
// if(searchNode(prefix) == null)
// return false;
// else
// return true;
// }
