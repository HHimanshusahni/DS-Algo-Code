import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data){
		this.data  = data;
	}
}
public class _01NextNumber{
	//Recursive Approach Time :O(N) Space :O(N)
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head){
		int smallAns = nextLargeNumberHelp(head);
		if(smallAns == 0)
			return head;
		else{
			LinkedListNode<Integer> newNode = new  LinkedListNode<>(1);
			newNode.next = head;
			head = newNode;
			return head;
		}

	}
	public static int nextLargeNumberHelp(LinkedListNode<Integer> head){
		//Base Case
		if(head == null)
			return 1;
		int carry = nextLargeNumberHelp(head.next);
		if(carry == 1){
			if(head.data == 9){
				head.data = 0;
				return 1;
			}else{
				head.data = 1 + head.data;
				return 0;
			}
		}else{
			return 0;
		}
	}
		// https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
		//Appraoch Iteratively Reverse the linkedList , add 1 , Reverse the linkedlist Time Complexity : O(n) , Space Complexity:O(1)
		public static LinkedListNode<Integer> nextLargeNumber_2(LinkedListNode<Integer> head){
			head = reverse(head);
			int carry = 1;
			LinkedListNode<Integer>temp = head,prev = null;
			while(temp != null){
				if(carry == 0)
					break;
				if(temp.data == 9){
					temp.data = 0;
					carry = 1;
				}else {
					temp.data = 1 + temp.data;
					carry = 0;
				}
				prev = temp;
				temp = temp.next;
			}
			if(carry == 1){
				LinkedListNode<Integer>newNode = new LinkedListNode<>(1);
				newNode.next = null;
				prev.next = newNode;
				if(head == null)
					head = newNode;
			}
			head = reverse(head);
			return head;
		}
		public static LinkedListNode<Integer> reverse(LinkedListNode<Integer>head){
			LinkedListNode<Integer> prev = null,current = head,next;
			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
			return head;
		}

	public static LinkedListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);

		LinkedListNode<Integer>head = null;
		LinkedListNode<Integer>current = null;
		int data = s.nextInt();
		while(data != -1){
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				current.next = newNode;
			
			current = newNode;
			data  = s.nextInt();
		}
		return head;
	}
	public static void printLinkedList(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();

	}
	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		printLinkedList(head);
		head = nextLargeNumber_2(head);
		printLinkedList(head);
	}
}