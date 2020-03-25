class Node<T>{
	T data;
	Node<T> next;
	public Node(T data){
		this.data = data;
	}
}
class Queue<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;
	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	public void enqueue(T data) {
		Node<T> newNode = new Node(data);
		newNode.next = null;
		if(rear == null)
			front = newNode;
		else
			rear.next = newNode;
		rear = newNode;
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T dequeue() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		T data = front.data;
		front = front.next;
		if(size == 0)
            rear = null;
		size--;
		return data;
	}

	public T front() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		return front.data;
	}
}
class QueueEmptyException extends Exception{
	
}
public class _03QueueUsingLinkedList {
	public static void main (String[] args) throws QueueEmptyException{
		Queue<Integer> queue = new Queue<Integer>();
		int arr[] = {1,2,3,4,5,6,7};
		System.out.println("isEmpty"+queue.isEmpty());
		for(int i = 0;i<arr.length;i++){
			System.out.println("enqueued"+arr[i]);
			queue.enqueue(arr[i]);
		}
		System.out.println("isEmpty"+queue.isEmpty());
		while(!queue.isEmpty())
			System.out.println(queue.dequeue());
		System.out.println("isEmpty"+queue.isEmpty());

		
	}
}