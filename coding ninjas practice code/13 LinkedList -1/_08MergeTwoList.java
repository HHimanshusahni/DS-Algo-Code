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
			LinkedListNode<Integer> temp1 = head1, temp2 = head2 ,temp = null, head = null;
			//Check if one list is empty
			if(head1 == null)
				return head2;
			else if(head2 == null)
				return head1;
			//Decide head
			if(temp1.data <= temp2.data){
				head = head1;
				temp = head1;
				temp1= temp.next;
			}else{
				head = head2;
				temp = head2;
				temp2= temp2.next;
			}
			//Merging list
			while(temp1 != null && temp2 != null){

				if(temp1.data <= temp2.data){
					temp.next = temp1;
					temp = temp1;
					temp1 = temp1.next;
				}else{
			    	temp.next = temp2;
					temp = temp2;
					temp2 = temp2.next;	
				}
			}
			//If one  of the list ends while merging
			if(temp1 != null)
				temp.next = temp1;
			if(temp2 != null)
				temp.next = temp2;
				
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