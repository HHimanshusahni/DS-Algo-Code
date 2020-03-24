import java.util.Scanner;
class ListNode<T>{
	public T data;
	public ListNode<Integer> next;
	public ListNode(T data){
		this.setData(data);
		this.next = null;
	}
	public T getData(){
		return data;
	}
	public void setData(T data){
		this.data = data;
	}
}
public class _10RearrangeLinkedList{
	// Approach Iterative O(n^2)
	public static ListNode<Integer> changelist(ListNode<Integer> head) {
		ListNode<Integer> current  = head,next, ptr;
		if(head == null && head.next == null)
			return head;
		while(current.next != null && current.next.next !=null){
			next = current.next;
			ptr = current;
			while(ptr.next.next !=null)
				ptr = ptr.next;
			current.next = ptr.next;
			ptr.next.next = next;
			ptr.next = null;
			current = next;
			
		}
		return head;
	}
 
// https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
// https://www.geeksforgeeks.org/rearrange-linked-list-alternate-first-last-element/

// Approach 2 O(n) : find the midpt of the list .separate into two list . reverse the second list and 
// merge the two list alternatively
 	public static ListNode<Integer> changelist_2(ListNode<Integer> head) {
 		// if(head == null || head.next  == null || head.next.next == null)
 		// 	return head;
 		 ListNode<Integer> midpoint,head2,tail = null,ptr1,ptr2,next1,next2; 
 		 midpoint = findMidpt(head);
 		 head2 = midpoint.next;
 		 midpoint.next = null;
 		 head2 = reverseList(head2);
 		 ptr1 = head;
 		 ptr2 = head2;
 		 while(ptr1 != null && ptr2 != null){
 			next1 = ptr1.next;
 		    next2 = ptr2.next;
 		 	if(tail == null)
 		 		tail = head;
 		 	
 		 	tail.next = ptr2;
 		 	ptr2.next = next1;
 		 	ptr1 = next1;
 		 	ptr2 = next2;
 		 	tail  = next1;
 		 }
 		 return head;

	}
	public static ListNode<Integer> findMidpt(ListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		ListNode<Integer> slow = head , fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static ListNode<Integer> reverseList(ListNode<Integer> head){
		ListNode<Integer> prev = null, current = head , next;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public static void main(String[]args){
		ListNode<Integer> head = takeInput();
		head = changelist_2(head);
		print(head);
	}
	public static ListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		ListNode<Integer> head=null, newNode=null,tail = null;
		while(data != -1){
			newNode = new ListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			data = s.nextInt();
		}
		return head;
	}
	public static void print(ListNode<Integer> temp){
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.next;
		}
	}
}