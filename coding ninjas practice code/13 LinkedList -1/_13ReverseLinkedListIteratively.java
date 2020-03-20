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
public class _13ReverseLinkedListIteratively{
	public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		LinkedListNode<Integer> prev = null, current = head , next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;

	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		head = reverse_I(head);
		print(head);
	}	
	public static LinkedListNode<Integer> takeInput(){
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		LinkedListNode<Integer> newNode , tail = null,head = null;
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
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.next;
		}
	}
}