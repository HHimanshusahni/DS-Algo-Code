import java.util.Scanner;
class LinkedListNode<T> {
	T data;
	LinkedListNode<Integer> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class _07DeleteNodeRecursively{
	public static LinkedListNode<Integer> deleteIthNodeRec(LinkedListNode<Integer> head, int i){
		//Base Case
		if(head == null)
			return head;
	   else if(i == 0)
			return head.next;
		//Recursive Case
		LinkedListNode<Integer> smallAns = deleteIthNodeRec(head.next,i-1);
		//Small Calculation
		head.next = smallAns;
		return head;
	}
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> newNode = null;
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
		System.out.print("Enter position of node deleted:\t");
		int pos = scan.nextInt();
		head = deleteIthNodeRec(head,pos);
		print(head);
	}
	public static void print(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}