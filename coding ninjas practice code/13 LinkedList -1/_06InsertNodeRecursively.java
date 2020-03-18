import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<Integer> next;
	LinkedListNode(T data){
		this.data = data;
	}
	
}
public class _06InsertNodeRecursively{
	public static LinkedListNode<Integer> insertR(LinkedListNode<Integer> head, int data, int pos){
		//Base Case
		if(pos == 0){
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			newNode.next = head;
			return newNode;
		}
		if(head == null) //If position is not present in the linkedlist
			return head;
		if(pos == 1 ){
			LinkedListNode<Integer> newNode =  new LinkedListNode<Integer>(data);
			newNode.next = head.next;
			head.next = newNode;
			return newNode;
		}
		//Recursive Case
	    insertR(head.next,data,pos-1);
		return head;

	}
	//Approach 2
	public static LinkedListNode<Integer> insertR2(LinkedListNode<Integer>head,int data,int pos){
		//Base Case
		if(pos == 0){
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			newNode.next = head;
			return newNode;
		}else if(head == null || pos<0){
			return head;
		}
		//Recursive Case
		LinkedListNode<Integer> smallAns = insertR2(head.next,data,pos-1);
		//Small Calculation
		head.next = smallAns;
		return head;
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> newNode= null;
		int data = s.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			newNode.next = null;
			if(head == null){
				head = newNode;	
				temp = newNode;
			}else{
				temp.next = newNode;
				temp = newNode;
			}
			data = s.nextInt();
		}
		int position = s.nextInt();
		data  = s.nextInt();
		head = insertR2(head,data,position);
		print(head);


	}
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer>temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}