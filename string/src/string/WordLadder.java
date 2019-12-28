package string;

import java.util.*;

//Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
//Find length of the smallest chain from ‘start’ to ‘target’ if it exists, 
//such that adjacent words in the chain only differ by one character 
//and each word in the chain is a valid word i.e., it exists in the dictionary. 
//It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary
// words is same.

//Example:

//Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
//             start = TOON
//             target = PLEA
//Output: 7
//Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "COLD";
        String endWord = "WARM";
        String[] wAry = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN", "COLD", "CORD",
                "CARD", "WARD",
                "WARM"};
        List<String> dictionary = Arrays.asList(wAry);
        int len = calculateLadderLength(beginWord, endWord, dictionary);
        // printladderWords(beginWord, endWord, dictionary); // it will print it in reverse order
        System.out.println("\nLength: " + len);
        int lenwithoutusinmap = calculateLadderLen(beginWord, endWord, dictionary);
        System.out.println("\nLength: " + lenwithoutusinmap);

    }

    private static void printladderWords(String beginWord, String endWord,
                                         List<String> dictionary) {
        Node current = printladder(beginWord, endWord, dictionary);

        while (current != null) {
            if (current.pre != null)
                System.out.print(current.word + "->");
            else
                System.out.print(current.word);
            current = current.pre;
        }
    }

    // Transformation of calculateLadderLength to get the path
    private static Node printladder(String beginWord, String endWord, List<String> dictionary) {
        HashSet<String> words = new HashSet<String>(dictionary); // create set- a copy of orignal
        // dictionary, will remove word from set so that orignal dictionary can be retained
        Queue<Node> q = new LinkedList<Node>(); // BFS
        Map<String, Integer> map = new HashMap<String, Integer>(); // key: word; value: level //
        // NOT required for printing path
        map.put(beginWord, 1);
        Node pre = new Node(beginWord, null);
        q.offer(pre);
        words.remove(beginWord);
//		System.out.println("NewWord: " + beginWord);
//		words.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll().word;
            // System.out.println("word: " + word);
            char[] ary = word.toCharArray();
            int currentLevel = map.get(word);
            for (int i = 0; i < ary.length; i++) {

                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    ary[i] = ch;
                    String newWord = new String(ary);
//					System.out.println("NewWord: " + newWord);
                    if (words.contains(newWord)) {
                        Node newNode = new Node(newWord, pre);
//						System.out.println("NewWord: " + newWord);
                        if (newNode.word.equals(endWord))
                            return newNode;
                        q.offer(newNode);
                        map.put(newWord, currentLevel + 1);
                        words.remove(newWord);// remove is must. otherwise it might create cycle.
                        pre = newNode;
                    }
                    ary = word.toCharArray();

                }
            }
        }
        return null;
    }

    private static int calculateLadderLength(String beginWord, String endWord,
                                             List<String> dictionary) {
        HashSet<String> words = new HashSet<String>(dictionary);// clone the dictionary...
        //in this dictory once we find the word in dictionary will remove it to avoid cycle.
        Queue<String> q = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>(); // key: word; value: level
        map.put(beginWord, 1);// starting level at 1.. no oflevels-->length form start to end WORD.
        q.offer(beginWord);
        words.remove(beginWord);
        // System.out.println("NewWord: " + beginWord);
        //words.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
//			System.out.println("word: " + word);
            char[] ary = word.toCharArray();
            int currentLevel = map.get(word);
            for (int i = 0; i < ary.length; i++) {
                // 26 possible combination possible for one outer iteration.
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    ary[i] = ch;
                    String newWord = new String(ary);
//					System.out.println("NewWord: " + newWord);
                    if (words.contains(newWord)) {
//						System.out.println("NewWord: " + newWord);
                        if (newWord.equals(endWord))
                            return currentLevel + 1;
                        q.offer(newWord);
                        map.put(newWord, currentLevel + 1);
                        words.remove(newWord);

                    }
                    ary = word.toCharArray(); // retain original word so that other letter can be
                    // altered from a->z

                }
            }
        }

        return 0;
    }

    private static int calculateLadderLen(String beginWord, String endWord,
                                          List<String> dictionary) {
        Queue<String> words = new LinkedList<>();
        dictionary = new ArrayList<>(dictionary); // or use set, we can't do add/remove operation
        // on dictionary as it's derived from Arrays.asList so created new one and assigned same
        // variable for minimal code change.
        words.add(beginWord);
        if (dictionary.contains(beginWord))
            dictionary.remove(beginWord);
        words.add(null);
        int currentLevel = 1; // current level is length here so starting with one. think of
        // source and target as same word.
        while (!words.isEmpty()) {
            String word = words.poll();
            if (word == null && words.isEmpty())
                return -1;
            if (word == null) {
                words.add(null);
                currentLevel++;
                continue;
            }
            if (word.equals(endWord))
                return currentLevel;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars = word.toCharArray();
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if (dictionary.contains(newWord)) {
                        words.add(newWord);
                        dictionary.remove(newWord);
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        String word;
        Node pre; // to track parent, not required if you have to print length only.

        public Node(String word, Node pre) {
            this.word = word;
            this.pre = pre;
        }
    }

}
