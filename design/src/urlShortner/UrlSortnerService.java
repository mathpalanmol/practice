package urlShortner;

//Think of an alphabet we want to use. In your case that's [a-zA-Z0-9]. It contains 62 letters.
//
//Take an auto-generated, unique numerical key (the auto-incremented id of a MySQL table for example).
//
//For this example I will use 12510 (125 with a base of 10).
//
//Now you have to convert 12510 to X62 (base 62).
//
//12510 = 2×62 1 + 1×620 = [2,1]

//How to resolve a shortened URL to the initial ID
//
//The reverse is even easier. You just do a reverse lookup in your alphabet.
//
//    e9a  62 will be resolved to "4th, 61st, and 0th letter in alphabet".
//
//    e9a  62 = [4,61,0] = 4×62 2 + 61×62 1 + 0×62 0 = 19158
//
//    Now find your database-record with WHERE id = 19158 and do the redirect.

// inverse function f(x)--> y then g(y)-->x

// general normal is always base 10; decimal number
//Functional Requirements:
//
//Given a URL, our service should generate a shorter and unique alias of it.
//When users access a shorter URL, our service should redirect them to the original link.
//Users should optionally be able to pick a custom alias for their URL.
//Links will expire after a specific timespan automatically; users should also be able to specify expiration time
// write request 20%
// User will initiate the request with Rest call, it will come to loadbalancer.
// loadbalancer will send the request to worker server.

// read request 80%
//Storage estimates: Since we expect to have 500M new URLs every month and if we would be keeping these objects for five years; total number of objects we will be storing would be 30 billion.
//
//500 million * 5 years * 12 months = 30 billion
//Let’s assume that each object we are storing can be of 500 bytes (just a ballpark, we will dig into it later); we would need 15TB of total storage:
//
//30 billion * 500 bytes = 15 TB
//8. Cache
//We can cache URLs that are frequently accessed. We can use some off-the-shelf solution like Memcache, that can store full URLs with their respective hashes. The application servers, before hitting backend storage, can quickly check if the cache has desired URL.
//
//How much cache should we have? We can start with 20% of daily traffic and based on clients’ usage pattern we can adjust how many cache servers we need. As estimated above we need 170GB memory to cache 20% of daily traffic since a modern day server can have 256GB memory, we can easily fit all the cache into one machine, or we can choose to use a couple of smaller servers to store all these hot URLs.
//
//Which cache eviction policy would best fit our needs? When the cache is full, and we want to replace a link with a newer/hotter URL, how would we choose? Least Recently Used (LRU) can be a reasonable policy for our system. Under this policy, we discard the least recently used URL first. We can use a Linked Hash Map or a similar data structure to store our URLs and Hashes, which will also keep track of which URLs are accessed recently.
//
//To further increase the efficiency, we can replicate our caching servers to distribute load between them.
//
//How can each cache replica be updated? Whenever there is a cache miss, our servers would be hitting backend database. Whenever this happens, we can update the cache and pass the new entry to all the cache replicas. Each replica can update their cache by adding the new entry. If a replica already has that entry, it can simply ignore i

public class UrlSortnerService {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALPHABET.length();

	public static void main(String[] args) {
		System.out.println(encode(125));
		System.out.println(decode(encode(125)));
		System.out.println(decodeNew("e9a"));

	}

	public static String encode(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) { // last reminder will also be taken care of
			sb.append(ALPHABET.charAt(num % BASE));
			num /= BASE;
		}
		return sb.reverse().toString();
	}

	public static int decode(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++)
			num = num * BASE + ALPHABET.indexOf(str.charAt(i));
		return num;
	}

	// mine
	public static int decodeNew(String str) {
		int num = 0;
		str = new StringBuffer(str).reverse().toString();// e90 --> 09e
		for (int i = 0; i < str.length(); i++) {
			int no = ALPHABET.indexOf(str.charAt(i));
			num = num + (no * (int) Math.pow(BASE, i)); // --> 62^0-->62^1-->62^2
		}
		return num;
	}
}
