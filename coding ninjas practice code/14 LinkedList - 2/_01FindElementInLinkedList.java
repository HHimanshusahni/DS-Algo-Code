import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	} 
}
public class _01FindElementInLinkedList{
	public static int indexOfNIter(LinkedListNode<Integer> head, int n) {
		LinkedListNode<Integer> temp = head;
		int count = 0;
		while(temp != null){
			if(temp.data.intValue() == n)
				return count;
			count++;
			temp = temp.next;
		}
		return -1;
	}		public static void main(String[]args){
		// LinkedListNode<Integer> head = 
		Scanner s = new Scanner(System.in);
		System.out.println(indexOfNIter(takeInput(),s.nextInt()));
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