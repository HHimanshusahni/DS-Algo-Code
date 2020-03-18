import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;

	}
	public T getData(){
		return data;
	}
}
public class _09EliminateDuplicatesFromLL{
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		if(head == null)
			return head;
		LinkedListNode<Integer> temp1 = head, temp2 = head.next;
		while(temp2 != null){
			// if(temp1.getData == temp2.getData) --> This will compare the Object reference and not the values;
			if( !temp1.getData().equals(temp2.getData()) ){ // This will compare the object values
				temp1 = temp2;
				temp2 = temp2.next;
			}else{
				temp1.next = temp2.next;
				temp2 = temp2.next;
			}
		}
		return head;
	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = takeInput();
		head = removeDuplicates(head);
		print(head);
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer> head = null,tail = null, newNode = null;
		int data = scan.nextInt();
		while(data != -1) {
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
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}