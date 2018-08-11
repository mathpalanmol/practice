package ds.list.linkedList;

import java.util.HashSet;
/*
 * II method:
 * 1)	Sort the elements using Merge Sort. O(nLogn)
   2)	Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List. O(n)

Please note that this method doesn’t preserve the original order of elements.

Time Complexity: O(nLogn)
 * 
 * */
public class RemoveDuplicates 
{
    static class node 
    {
        int val;
        node next;
 
        public node(int val) 
        {
            this.val = val;
        }
    }
     
    /* Function to remove duplicates from a
       unsorted linked list 
       O(n)
       */
    static void removeDuplicate(node head) 
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>(); // or save link itself.
     
        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null) 
        {
            int curval = current.val;
             
             // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
 
    }
     
    /* Function to print nodes in a given linked list */
    static void printList(node head) 
    {
        while (head != null) 
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
 
    public static void main(String[] args) 
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        node start = new node(10);
        start.next = new node(12);
        start.next.next = new node(11);
        start.next.next.next = new node(11);
        start.next.next.next.next = new node(12);
        start.next.next.next.next.next = new node(11);
        start.next.next.next.next.next.next = new node(10);
 
        System.out.println("Linked list before removing duplicates :");
        printList(start);
 
        removeDuplicate(start);
 
        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }
}