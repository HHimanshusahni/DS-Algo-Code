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
	public static void main(String[] args)throws IOException{
		LinkedListNode<Integer> head = takeInput();
		System.out.println(isPalindrome_2(head));

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