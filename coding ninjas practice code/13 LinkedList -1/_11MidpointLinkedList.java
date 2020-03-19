import java.lang.*;
import java.util.Scanner;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data){
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
public class _11MidpointLinkedList{
	//Approach 1 O(n) but traversing the linkedlist list more than once
	public static int printMiddel(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		int count = 0;
		// finding the total no of nodes in the linked list in the first traversal
		while(temp != null){
			temp = temp.next;
			count++;
		}
		temp = head;
		//
		for(int i = 0;i<(count-1)/2;i++){
			temp = temp.next;
		}
		return temp.getData().intValue();

	}
	//Approach 2 Finding the middle node in one traversal
	public static int printMiddel_2(LinkedListNode<Integer>head){
		LinkedListNode<Integer> slow = head , fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.getData().intValue();
	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		System.out.println(printMiddel_2(head));
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		LinkedListNode<Integer>head = null ,tail = null,newNode;
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			data = scan.nextInt();
		} 
		return head;
	}
}