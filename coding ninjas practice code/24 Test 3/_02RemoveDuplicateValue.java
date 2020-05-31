import java.util.Scanner;
import java.util.HashMap;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data){
		this.data = data;
		this.next = null;
	}

}
public class _02RemoveDuplicateValue{
	
	public static void changeLL(LinkedListNode<Integer> head){
		//Finding the n value  in the linkedlist that is the maximum value
		int n = Integer.MIN_VALUE;
		LinkedListNode<Integer> temp = head ;
		while(temp != null){
			n = Math.max(n,temp.data);
			temp = temp.next;
		}
		//Putting the value in the HashMap and replacing the value with n + 1, n + 2 ...
		HashMap<Integer,Boolean> map = new HashMap<>(); 
		temp = head;
		while(temp != null){
			if(map.containsKey(temp.data)){
				temp.data = ++n;
			}else{
				map.put(temp.data,true);
			}
			temp = temp.next;
		} 
		
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		LinkedListNode<Integer> head = null,current = null;
		while(data != -1){
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
			if(head == null){
				head = newNode;
			}else{
				current.next = newNode;
			}
			current = newNode;
			data = scanner.nextInt();
		}
		return head;
	}
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		print(head);
		changeLL(head);
		print(head);
	}
}