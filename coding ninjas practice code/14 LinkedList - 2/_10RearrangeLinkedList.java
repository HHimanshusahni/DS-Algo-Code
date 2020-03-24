import java.util.Scanner;
class ListNode<T>{
	public T data;
	public ListNode<Integer> next;
	public ListNode(T data){
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
public class _10RearrangeLinkedList{
	// Approach Iterative O(n^2)
	public static ListNode<Integer> changelist(ListNode<Integer> head) {
		ListNode<Integer> current  = head,next, ptr;
		if(head == null && head.next == null)
			return head;
		while(current.next != null && current.next.next !=null){
			next = current.next;
			ptr = current;
			while(ptr.next.next !=null)
				ptr = ptr.next;
			current.next = ptr.next;
			ptr.next.next = next;
			ptr.next = null;
			current = next;
			
		}
		return head;
	}
	public static void main(String[]args){
		ListNode<Integer> head = takeInput();
		head = changelist(head);
		print(head);
	}
	public static ListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		ListNode<Integer> head=null, newNode=null,tail = null;
		while(data != -1){
			newNode = new ListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			data = s.nextInt();
		}
		return head;
	}
	public static void print(ListNode<Integer> temp){
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.next;
		}
	}
}