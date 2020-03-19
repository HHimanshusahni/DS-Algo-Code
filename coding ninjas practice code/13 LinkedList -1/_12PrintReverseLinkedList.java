import java.util.Scanner;
class LinkedListNode<T>{
	public T data;
	public LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	}
	public T getData(){
		return this.data;
	}
	public void setData(T data){
		this.data = data;
	}
}
public class _12PrintReverseLinkedList{
	//Time Complexity : O(n) Space complexity O(n)
	public static void printReverseRecursive(LinkedListNode<Integer> root){
		//Base Case
		if(root == null)
			return ;
		//Recursive call
		printReverseRecursive(root.next);
		//Small Calculation
		System.out.print(root.getData().intValue()+" ");
	}
	public static void main(String[] args){
		LinkedListNode<Integer> head = 	takeInput();
		printReverseRecursive(head);
	}	
	public static LinkedListNode<Integer> takeInput() {
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer> tail = null,head = null , newNode;
		int data = scan.nextInt();
		while(data != -1){
			newNode = new LinkedListNode<Integer>(data);
			if(head == null)
				head = newNode;
			else 
				tail.next = newNode;
			tail  = newNode;

			data = scan.nextInt();
		}
		return head;

	}

}