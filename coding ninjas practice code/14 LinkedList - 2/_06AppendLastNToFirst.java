import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next ;
	public LinkedListNode(T data){
		this.data = data;
	}
}
public class _06AppendLastNToFirst{
	public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
		if(n == 0)
			return root;
		LinkedListNode<Integer> slow  = root, fast = root , head = root;
		for(int i = 0;i<n;i++){
			fast = fast.next;
		} 
		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		head = slow.next;
		slow.next = null;
		fast.next = root;
		return head;
	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		head = append(head,s.nextInt());
		print(head);
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> head = null, tail = null, newNode = null;
		int data = s.nextInt();
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
			System.out.print(temp.data.intValue()+" ");
			temp = temp.next;
		}
	}
}