package hashing;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

	SortedMap<String, Node> ring = new TreeMap<String, Node>();
	List<Node> nodes = new ArrayList<Node>();

	public void print() {
		System.out.println("Printing Ring: ");
		for (java.util.Map.Entry<String, Node> entry : ring.entrySet()) {
			BigInteger key;
			try {
	//			key = new String(entry.getKey().getBytes("UTF-8"));
				key = new BigInteger(entry.getKey().getBytes("UTF-8"));
				System.out.println("key: " + key.toString(10) + " " + "value: " + entry.getValue());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Printing Nodes");
		nodes.forEach(System.out::println);
	}

	public void add(String str) {
		Node node = new Node(str);
		String hashkey = getHash(str);
		ring.put(hashkey, node);
		nodes.add(node);
	}

	public boolean remove(String str) {
		Node node = new Node(str);
		if (!nodes.contains(node))
			return false;
		ring.remove(getHash(str));
		return true;
	}

	public Node findNode(String str) {
		String hashkey = getHash(str);
		SortedMap<String, Node> tailMap = ring.tailMap(hashkey);
		String key = null;
		if (!tailMap.isEmpty())
			key = tailMap.firstKey();
		else
			key = ring.firstKey();

		return ring.get(key);
	}

	public String getHash(String str) {
		String hashkey = null;
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			byte[] digest = instance.digest(str.getBytes("UTF-8"));
			hashkey = new String(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hashkey;
	}

	private static class Node {
		String key;

		public Node(String key) {
			this.key = key;
		}

//		@Override
//		public boolean equals(Object obj) {
//			return this.key == ((Node) obj).key;
//		}
		@Override
		public String toString() {
			return "key: " + key;
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update("string".getBytes() );
        byte[] hash = digest.digest();
        BigInteger bi = new BigInteger( hash );
        System.out.println( "hex:" + bi.toString(16) + "\r\ndec:" + bi.toString() );
		ConsistentHashing chash = new ConsistentHashing();
		chash.add("1234");
		chash.add("2345");
		chash.add("3456");
		chash.add("4567");
		chash.add("5678");
		chash.print();
		Node n = chash.findNode("1000");
		System.out.println("find node for 1000 key: " + n);
//		chash.remove("1234");
	}

}
