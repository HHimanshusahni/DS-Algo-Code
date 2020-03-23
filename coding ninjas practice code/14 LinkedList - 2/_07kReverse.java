import java.util.Scanner;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<Integer> next;
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
public class _07kReverse{
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k){
		if(head == null || head.next == null)
			return head;

		LinkedListNode<Integer> ptr = head,h = head,tail = null;

		while(h != null){
			ptr = h;
			for(int i = 0;i<k-1 && ptr.next != null;i++){
				ptr = ptr.next;
			}

			
			hnext = ptr.next;
			ptr.next = null;
			LinkedListNode<Integer> temp = reverseList(h);
			if(tail == null)
				head = ptr;
			else
				tail.next = temp;
			tail = h;
			h = hnext;

			
		}
		return head;
	}
	public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		LinkedListNode<Integer> prev = null, current = head, next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		head = kReverse(head,s.nextInt());
		print(head);
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		LinkedListNode<Integer> head=null, newNode=null,tail = null;
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
	public static void print(LinkedListNode<Integer> temp){
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.next;
		}
	}
}