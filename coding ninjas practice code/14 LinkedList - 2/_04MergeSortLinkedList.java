import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	}
}

public class _04MergeSortLinkedList{
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head){
		// base case
		if(head == null || head.next == null)
			return head;
		LinkedListNode<Integer> h1 = null , h2 = null;
		LinkedListNode<Integer> midpoint= findMidpoint(head);
		h1 = head;
		h2 = midpoint.next;
		midpoint.next = null;

		h1 = mergeSort(h1);
		h2 = mergeSort(h2);
		head = merge(h1, h2);
		return head;
	}
	public static LinkedListNode<Integer> findMidpoint(LinkedListNode<Integer> head){
		LinkedListNode<Integer> slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; 
	}
	public static LinkedListNode<Integer> merge(LinkedListNode<Integer>h1, LinkedListNode<Integer> h2){
		LinkedListNode<Integer>tail = null, head = null;
		if(h1.data.intValue() <= h2.data.intValue()){
			head = h1;
			tail = h1;
			h1 = h1.next;
		}else{
			head = h2;
			tail = h2;
			h2 = h2.next;
		}
		while(h1 != null && h2 != null) {
			if(h1.data.intValue() <= h2.data.intValue()){
				tail.next = h1;
				tail = h1;
				h1 = h1.next;
			}else{
				tail.next = h2;
				tail = h2;
				h2 = h2.next; 
			}
			
		}
		while(h1 != null){
			tail.next = h1;
			tail = h1;
			h1 = h1.next; 

		}
		while(h2  != null){
			tail.next = h2;
			tail = h2;
			h2 = h2.next; 
		}
		return head;
	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		head = mergeSort(head);
		print(head);
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		LinkedListNode<Integer> head = null, newNode = null , tail = null; 
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			data = s.nextInt();
		}
		return head;
	}
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp!= null){
			System.out.print(temp.data.intValue()+" ");
			temp = temp.next;
		}
		System.out.println(); 
	}
}