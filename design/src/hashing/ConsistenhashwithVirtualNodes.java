package hashing;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class ConsistenhashwithVirtualNodes {

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

//  virtualnodes 0 means no virtual node.
	public void add(String str, int virtualNodes) {
		Node pnode = new Node(str);
		String hashkey = getHash(str);
		ring.put(hashkey, pnode);
		nodes.add(pnode);
		// added for the virutal nodes.
	
		for(int i=0; i<virtualNodes; i++) {
			Node vNode = new Node(pnode, str+"-"+i);
			vNode.setVirtualNode(Boolean.TRUE);
			ring.put(getHash(str+"-"+i), vNode);
			nodes.add(vNode);
		}
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
        // for virtual servers we need to return physical server
		return ring.get(key).isVirtualNode() ? ring.get(key).getpNode()  : ring.get(key);
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
		Boolean virtualNode;
		// need to maintain physical node. actual server can have multiple virtual nodes.
		Node pNode;

		public Node getpNode() {
			return pNode;
		}

		public Boolean isVirtualNode() {
			return virtualNode;
		}

		public void setVirtualNode(Boolean virtualNode) {
			this.virtualNode = virtualNode;
		}

		

		public Node(String key) {
			this.key = key;
		}
		
		public String getKey() {
			return key;
		}
		public Node(Node pNode, String key) {
			this.pNode = pNode;
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
        ConsistenhashwithVirtualNodes chash = new ConsistenhashwithVirtualNodes();
		chash.add("1234", 3);
		chash.add("2345", 3);
		chash.add("3456", 3);
		chash.add("4567", 3);
		chash.add("5678", 3);
		chash.print();
		Node n = chash.findNode("1000");
		System.out.println("find node for 1000 key: " + n);
//		chash.remove("1234");
	}

}
