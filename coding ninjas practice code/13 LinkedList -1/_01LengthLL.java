import java.io.*;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}

public class _01LengthLL{

	public static int length(LinkedListNode<Integer> head){
		int len = 0;
		LinkedListNode<Integer> temp = head;
		while(temp != null){
			temp = temp.next;
			len++;
		}
		return len;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i = 0;
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> temp = null;
		while(i<n){
			int data = Integer.parseInt(br.readLine());
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(data);
			if(head == null){
				head = node;
				temp = node;
			}
			else
				temp.next = node;
			temp = node;
			i++;

		}
		System.out.println("Length of the list is :"+length(head));

	}
}