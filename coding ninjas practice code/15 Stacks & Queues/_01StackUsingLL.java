class Node<T>{
	T data;
    Node<T> next;
	public Node(T data){
		this.data = data;
	}
}
class StackEmptyException extends Exception{
	
}

class Stack<T>{
	private Node<T> top ;
	private int totalElements;
	//Constructor
	public Stack(){
		top = null;
		totalElements = 0;
	}
	
	//Push Function
	public void  push(T data){
		Node<T> newNode = new Node<T>(data);
		newNode.next = top;
		top = newNode;
		totalElements++;
	}
	//Pop Function
	public T pop() throws StackEmptyException{
		if(top == null)
			throw new StackEmptyException();
		Node<T> temp = top;
		top = top.next;
		totalElements--;
		return temp.data;
	}
	//Top function
	public T top() throws StackEmptyException{
		if(top == null)
			throw new StackEmptyException();
		return top.data;
	}
	//Size function
	public  int size(){
		return totalElements;
	}

	//isEmpty function
	public boolean isEmpty(){
		if(top == null)
			return true;
		else 
			return false;
	}

}
public class _01StackUsingLL{
	public static void main(String[] args) throws StackEmptyException{
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(" IsEmpty :"+stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("IsEmpty :"+stack.isEmpty());
		System.out.println("Size: "+stack.size());
		System.out.println("On Top:"+stack.top());
		System.out.println("Popped Element: "+stack.pop());
		stack.push(10);
		System.out.println(stack.pop());
		System.out.println(stack.pop());


	}		
}