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
public class _14ReverseLinkedListRecursively{
	public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
		//Base Case
		if(head == null || head.next == null)
			return head;
		//Recursive Case
		LinkedListNode<Integer> ahead = head.next;
		head.next = null;
		LinkedListNode<Integer>headNew = reverse_R(ahead);
		//Small Calculation
		ahead.next = head;
		return headNew;

	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		head = reverse_R(head);
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