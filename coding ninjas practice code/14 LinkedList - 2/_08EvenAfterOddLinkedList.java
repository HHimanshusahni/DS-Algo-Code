import java.util.Scanner;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
		this.next = null;
	}
}
public class _08EvenAfterOddLinkedList{
	
	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
		if(head == null || head.next == null)
			return head;
		LinkedListNode<Integer> headOdd = null,headEven = null,tailEven = null,prev = null,current = head,next;
		while(current != null){
			next = current.next;
			if(current.data.intValue() % 2 == 1){
				if(headOdd == null)
					headOdd = current;
				prev = current;
				current = next;
			}else{
				if(prev != null)
					 prev.next = next;
				current.next = null;
				if(headEven == null)
					headEven = current;
				else
					tailEven.next  = current;
				tailEven = current;
				current = next;
			}
		} 
		if(prev != null)
	    prev.next = headEven;
		if(headOdd !=null)
			return headOdd;
		else
			return headEven;
	}

	//Approach 2 By Making two separate list
	public static LinkedListNode<Integer> sortEvenOdd_2(LinkedListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		LinkedListNode<Integer> headOdd = null,tailOdd = null,headEven = null ,tailEven = null,ptr = head;
		while(ptr != null){
			if(ptr.data.intValue() %2 == 1){
				if(headOdd == null)
					headOdd = ptr;
				else
					tailOdd.next = ptr;
				tailOdd = ptr;
			}else{
				if(headEven == null)
					headEven = ptr;
				else
					tailEven.next = ptr;
				tailEven = ptr;
			}
			ptr = ptr.next;
		}
		if(tailOdd != null)
			tailOdd.next = null;
		if(tailEven != null)
			tailEven.next = null;
		if(tailOdd != null){
			tailOdd.next = headEven;
			return headOdd;
		}else{
			return headEven;
		}

	}
	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		head = sortEvenOdd_2(head);
		print(head);

	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null, newNode = null,tail = null;  
		int data = s.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else 
				tail.next = newNode;
			tail  =  newNode;
			data = s.nextInt();
		}
		return head;
	}
	public  static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> t = head;
		while(t != null){
			System.out.print(t.data+" ");
			t = t.next;
		}

	}
}