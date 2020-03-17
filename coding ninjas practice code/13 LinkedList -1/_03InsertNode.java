import java.util.Scanner;
class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}

}
public class _03InsertNode{
	public static Node<Integer> insert(Node<Integer> head, int data, int pos){
			Node<Integer> temp = head;
			int count = 0;
			if(pos == 0){//Insertion at the begining of the list 
				Node<Integer> newNode = new Node<Integer>(data);
				newNode.next = head;
				head = newNode;
				return head;
			}
			//Insertion in the middle and end of the list
			while(temp != null && count < pos-1){
				temp = temp.next;
				count++;
			}
			if(temp != null && count == pos -1 ){
				Node<Integer> newNode = new Node<Integer>(data);
				newNode.next = temp.next;
				temp.next = newNode;

			}
			return head;
	}

	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		Node<Integer> head = null;
		Node<Integer> temp = null;
		Node<Integer> newNode= null;
		int data = s.nextInt();
		while(data != -1){
			newNode = new Node<Integer>(data);
			newNode.next = null;
			if(head == null){
				head = newNode;	
				temp = newNode;
			}else{
				temp.next = newNode;
				temp = newNode;
			}
			data = s.nextInt();
		}
		int position = s.nextInt();
		data  = s.nextInt();
		head = insert(head,data,position);

		temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}


	}
}