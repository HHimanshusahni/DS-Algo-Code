import java.util.Scanner;
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data){
		this.data = data;
	}
}
public class _05BubbleSortLinkedList{
	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head){

		LinkedListNode<Integer> t = head,t1,t2,prev;
		int len = 0;
		while(t != null){
			++len;
			t = t.next;
		}
		for(int i = 0;i<len-1;i++){
			t1 = head;
			t2 = head.next;
			prev = null;
			for(int j = 0;j<len-i-1;j++){
				if(t1.data.intValue() > t2.data.intValue()){
					//swap the data of the nodes
					// Integer temp = t1.data;
					// t1.data = t2.data;
					// t2.data = temp;

					// Or Swapping the nodes and not the data
					if(prev == null)
						head = t2;
					else
						prev.next = t2;

					t1.next = t2.next;
					t2.next = t1;
					
					prev = t2;
					t2 = t1.next;
					

				}else{
					prev = t1;
					t1 = t1.next;
					t2 = t2.next;
		   		}
			}
		}
		return head;
    }
    public static void main(String[]args){
    	LinkedListNode<Integer> head = takeInput();
    	print(head);
    	head = bubbleSort(head);
    	print(head);
    }
    public static LinkedListNode<Integer> takeInput(){
    	Scanner s = new Scanner(System.in);
    	LinkedListNode<Integer> head = null, newNode = null, tail = null;
    	int data = s.nextInt();
    	while(data != -1){
    		newNode = new LinkedListNode<Integer>(data);
    		if(head == null)
    			head = newNode;
    		else
    			tail.next = newNode;
    		tail = newNode;
    		data = s.nextInt();
    	}
    	return head;
    }
    public static void print(LinkedListNode<Integer> head){
    	while(head != null){
    		System.out.print(head.data.intValue()+" ");
    		head = head.next;
    	}
    	System.out.println();
    }

}