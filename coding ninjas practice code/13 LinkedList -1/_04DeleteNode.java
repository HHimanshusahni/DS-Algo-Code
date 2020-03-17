import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class _04DeleteNode{
	public static LinkedListNode<Integer> deleteIthNode(LinkedListNode<Integer> head, int i){
		//EmptyList
		if(head == null )
			return head;
		if(i == 0){
			head = head.next;
			return head;
		}
		LinkedListNode<Integer> temp = head;
		int count = 0;
		while(temp != null && count < i-1){
			temp = temp.next;
			count++;
		}
		if(count == i-1){
			if(temp.next !=null)
			temp.next = temp.next.next;
			else
				temp.next = null;
		}
		return head;
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> newNode = null;
		int data = s.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			newNode.next = null;
			if(head == null)	//FirstNode
				head = newNode;	
			else
				temp.next = newNode;
			temp = newNode;
			data = s.nextInt();

		}		
		int i = s.nextInt();
		head = deleteIthNode(head,i);
		print(head);
	}
	public static void print(LinkedListNode<Integer>head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}