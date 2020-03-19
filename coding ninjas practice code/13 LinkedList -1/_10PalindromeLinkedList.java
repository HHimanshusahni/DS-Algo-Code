import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
public class _10PalindromeLinkedList{

	//Approach 1 O(n^2) & O(n)
	public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
			if(head == null || head.next == null)
				return true;
			LinkedListNode<Integer> temp1 = head,temp2 = head;
			int count = 0;
			while(temp1 != null){
				temp1 = temp1.next;
				count++;
			}
			temp1 = head;
			for(int i =0;i<count/2;i++){
				temp2 = head;
				for(int j = 0;j<count -i-1;j++)
					temp2 = temp2.next;
				if(!temp1.getData().equals(temp2.getData()))
					return false;
				temp1 = temp1.next;
				
			}
			return true;
	}
	//Approach 2 By Reversing the LinkedList and comparing the elements with the original list O(n) time and O(n) space
	public static boolean isPalindrome_3(LinkedListNode<Integer> head){
		if(head == null || head.next == null)
			return true;
		LinkedListNode<Integer>head2 = reverseLinkedList(head);
		LinkedListNode<Integer>temp1 = head,temp2 = head2;
		while(temp1 !=null && temp2 !=null){
			if(!temp1.getData().equals(temp2.getData()))
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return true;
	}
	public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer>head){
			if(head == null && head.next == null)
				return head;
			LinkedListNode<Integer> headReversed ,prev = null ,temp = head,newNode;
			while(temp != null){
				newNode = new LinkedListNode<Integer>(temp.getData());
				newNode.next = prev;
				prev = newNode;
				temp = temp.next;
			}
			headReversed = prev;
			return headReversed;

	}

	//Approach 3  Time Complexity O(n) & Space Complexity O(1) by reversing the 2nd half of the linkedlist and comparing the values with the first half
	public static boolean isPalindrome_4(LinkedListNode<Integer> head) {
		if(head == null || head.next == null)
			return true;
		//First find count the total nodes in the linkedlist
		int count = 0;
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		//Now find the midpoint of the linkedlist
		temp = head; 
		for(int i = 0;i<((count+1)/2)-1;i++){
			temp = temp.next;
		}
		LinkedListNode<Integer> head2 = temp.next;
		temp.next = null;
		head2 = reverse(head2);
		LinkedListNode<Integer> temp2 = head2;
		temp = head;
		while(temp!=null && temp2!=null){
			if(!temp.getData().equals(temp2.getData()))
				return false;
			temp = temp.next;
			temp2 = temp2.next;
		}
		return true;


	}
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
		if(head == null|| head.next == null)
			return head;
		LinkedListNode<Integer> prev = null, current = head,next;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	public static void main(String[] args)throws IOException{
		LinkedListNode<Integer> head = takeInput();
		System.out.println(isPalindrome_4(head));

	}

	public static LinkedListNode<Integer> takeInput() throws IOException{
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int data = Integer.parseInt(br.readLine());
		LinkedListNode<Integer> head = null, tail = null,newNode = null;
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			data = Integer.parseInt(br.readLine());
		}
		return head;
	}
}