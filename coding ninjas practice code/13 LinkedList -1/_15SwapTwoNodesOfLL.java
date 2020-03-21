import java.util.Scanner;
// https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
class LinkedListNode<T> {
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
		this. data = data;
	}
}
public class _15SwapTwoNodesOfLL{
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
		LinkedListNode<Integer> p1 = null, c1 = null, n1 = null,n2 = null,p2 = null ,c2 = null;
		//empty linkedlist or list with one node
		if(head == null || head.next == null)
			return head;
		//Putting the lesser index at i and bigger index at j
		int temp;
		if(i>j){ //Swapping
			temp = i;
			i = j;
			j = temp;
		}
		if(i == 0 && j == 1){//Case 1: If we want to swap first two nodes
			p1 = head;
			c1 = head.next;
			p1.next = c1.next;
			c1.next = head;
			head = c1;
		}else if(i == 0){//Case 2: If one of the nodes is the head node
			p2 = head;
			for(int l = 0 ;l<j-1;l++)
				p2 = p2.next;
			c2 = p2.next;
			n2 = p2.next.next;
			p2.next = head;
			c2.next = head.next;
			head.next = n2;
			head = c2;
		}else if(j-i == 1){
		//Case 3: If the nodes are alternate internal nodes
			p1 = head;
			for(int l = 0 ;l<i-1;l++)
				p1 = p1.next;
			c1 = p1.next;
			p1.next = c1.next;
			c1.next = c1.next.next;
			p1.next.next = c1;
		}else{//Case 4: normal Case
			p1 = head;
			p2 = head;
			for(int l = 0;l<j-1;l++){
				if(l<i-1)
					p1 = p1.next;
				p2 = p2.next;
			}
			c1 = p1.next;
			n1 = p1.next.next;
			c2 = p2.next;
			p1.next = c2;
			p2.next = c1;
			c1.next = c2.next;
			c2.next = n1;
		}

		return head;
	}
	//Implmentation 2 : We club the separate cases
	public static LinkedListNode<Integer> swap_nodes_2(LinkedListNode<Integer> head,int i,int j){

		LinkedListNode<Integer> p1 = null, c1 = null, p2 = null, c2 = null,temp = head,prev = null;
		int counter = 0;
		while(temp != null){
			if(counter == i){
				c1 = temp;
				p1 = prev;
			}
			if(counter == j){
				c2 = temp;
				p2 = prev;
			}
			prev = temp;
			temp = temp.next;
			counter++;
		} 

		// If any of the p1 or p2 is null then we need to update the head as node is head node
		if(p1 == null)
			head = c2;
		else
			p1.next = c2;

		if(p2 == null)
			head = c1;
		else
			p2.next = c1;
		
		temp = c2.next;// Saving the next reference as it will get lost after the next statement
		c2.next = c1.next;
		c1.next = temp;
		return head;
	}


	public static void main(String[]args){
		LinkedListNode<Integer> head = takeInput();
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		head = swap_nodes_2(head,i,j);
		print(head);
	}
	public static LinkedListNode<Integer> takeInput(){
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		LinkedListNode<Integer> head = null, newNode = null, tail = null;
		while(data != -1){
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
			System.out.print(temp.getData()+" ");
			temp = temp.next;
		}
	}
}