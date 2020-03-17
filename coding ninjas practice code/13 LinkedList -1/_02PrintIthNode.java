import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class _02PrintIthNode{
	public static void printIth(LinkedListNode<Integer> head, int i){
		int index = 0;
		LinkedListNode<Integer> temp = head;
		while(temp != null && index != i){
			temp = temp.next;
			index++;	
		}
		if(temp != null)
			System.out.println(temp.data);
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> newNode = null;
		LinkedListNode<Integer> temp = null;
		int data = s.nextInt();
		while(data !=-1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null){//First Node
				temp = newNode;
				head = newNode;
				head.next = null;
			}else{
				temp.next = newNode;
				newNode.next = null;
				temp = newNode;
			}
			data = s.nextInt();
		}
		int index = s.nextInt();
		printIth(head,index);

	}
}
