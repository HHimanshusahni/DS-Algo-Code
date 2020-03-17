import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class _05LengthRecursively{
	public static int length(LinkedListNode<Integer> head){
		return head == null ? 0 : 1+length(head.next);
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> newNode = null;
		int data = s.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null){
				head = newNode;
				temp = newNode;
			}else{
				temp.next = newNode;
				temp = newNode;
			}	
			data = s.nextInt();

		}
		System.out.println(length(head));
	}
}