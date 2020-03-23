import java.util.Scanner;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	}
}
public class _09DeleteEveryNNodes{
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		LinkedListNode<Integer> ptr1 = head, ptr2 = head;
		if(M ==0) //skip nothing so delete everything
			return null;
		if(N == 0)// delete nothing
			return head; 

		while(ptr1 != null){
			//Skip M
			for(int i = 0;i < M-1 && ptr1.next != null;i++)
				ptr1 = ptr1.next;
			ptr2 = ptr1.next;
				
			//delete N
			for(int i = 0 ;i<N && ptr2 != null;i++)
					ptr2 = ptr2.next;
			
			ptr1.next = ptr2;
			ptr1 = ptr2;
		}
		return head;
	}
	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		head = skipMdeleteN(head,s.nextInt(),s.nextInt());
		print(head);
	}	
	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		LinkedListNode<Integer> newNode, head = null,tail = null;
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
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data.intValue()+" ");
			temp = temp.next;
		}
	}
}
