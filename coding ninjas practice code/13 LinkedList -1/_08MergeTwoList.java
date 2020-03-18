import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}	
}
public class _08MergeTwoList{
		public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
			LinkedListNode<Integer> temp1 = head1;
			LinkedListNode<Integer> temp2 = head2;
			LinkedListNode<Integer> temp = null;
			LinkedListNode<Integer> head = null;
			while(temp1 != null && temp2 != null){

				if(temp1.data <= temp2.data){
					if(head == null)
						head = temp1;
					else
						temp.next = temp1;
					temp = temp1;
					temp1 = temp1.next;
				}else{
					if(head == null)
						head = temp2;
					else
						temp.next = temp2;
					temp = temp2;
					temp2 = temp2.next;
					
				}
			}
			while(temp1 != null){
				if(head == null)
					head = temp1;
				else
					temp.next = temp1;
				temp = temp1;
				temp1 = temp1.next;
			}
			while(temp2 != null){
				if(head == null)
					head = temp2;
				else
					temp.next = temp2;
				temp = temp2;
				temp2 = temp2.next;
			}
			return head;
		}


	public static void main(String[] args){
		LinkedListNode<Integer> head1 = inputList();
		LinkedListNode<Integer> head2 = inputList();
		LinkedListNode<Integer> head = mergeTwoList(head1,head2);
		print(head);
	}
	public static LinkedListNode<Integer> inputList(){	
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer>head = null;
		LinkedListNode<Integer>newNode = null;
		LinkedListNode<Integer>temp = null;
		int data = scan.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				temp.next = newNode;
			temp = newNode;
			data = scan.nextInt();
		}	
		return head;
	}
	public static void print(LinkedListNode<Integer>head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}