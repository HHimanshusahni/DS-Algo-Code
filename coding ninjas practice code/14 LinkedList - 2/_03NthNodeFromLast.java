import java.util.Scanner;
//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	}
}
public class _03NthNodeFromLast{
	public static LinkedListNode<Integer> nthNodeFromLastIter(LinkedListNode<Integer> head, int n){
		LinkedListNode<Integer> slow = head, fast = head;
		for(int i = 0 ;i<=n;i++){
			if(slow == null)
				return null;
			slow = slow.next;
		}
		while(slow != null){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}	
	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int index = s.nextInt();
		LinkedListNode<Integer> ans = nthNodeFromLastIter(head,index);
		if(ans != null)
			System.out.println(ans.data.intValue());
		else 
			System.out.println("null");
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
}