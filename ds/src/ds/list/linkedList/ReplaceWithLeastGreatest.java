package ds.list.linkedList;
//remove every element in given list with the next least greatest element and return new list
public class ReplaceWithLeastGreatest {

	Link first = null;
	Link outputFirst = null;
	Link outputStart = null;

	Link getList(Link start) {
		Link current = start;
		while (current != null) {
			int minMax = Integer.MAX_VALUE;
			Link nxtLink = current.next;
			int value = current.key;
			while (nxtLink != null) {
				if ((nxtLink.key >= current.key)) {
					int diff = nxtLink.key - current.key;
					if (diff < minMax) {
						minMax = diff;
						value = nxtLink.key;
					}
				}
				nxtLink = nxtLink.next;
			}
			insert(value);

			current = current.next;
		}

		return outputStart;
	}

	private void insert(int value) {
		Link newLink = new Link(value);
		if (outputFirst == null) {
			outputFirst = newLink;
			outputStart = newLink;
			return;
		}
		outputFirst.next = newLink;
		outputFirst = outputFirst.next;

	}

}
