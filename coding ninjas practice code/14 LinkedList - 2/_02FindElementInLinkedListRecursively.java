import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	} 
}
public class _02FindElementInLinkedListRecursively{
	public static int indexOfNRec(LinkedListNode<Integer> head, int n) {
		return indexOfNRec(head,n,0);
	}
	public static int indexOfNRec(LinkedListNode<Integer> head, int n,int count) {
		//Base Case 
		if(head == null)
			return -1;
		if(head.data == n)
			return count;
		return indexOfNRec(head.next,n,count+1);
	}
	public static void main(String[]args){ 
		Scanner s = new Scanner(System.in);
		System.out.println(indexOfNRec(takeInput(),s.nextInt()));
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer> head = null, tail = null, newNode = null;
		int data = scan.nextInt();
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