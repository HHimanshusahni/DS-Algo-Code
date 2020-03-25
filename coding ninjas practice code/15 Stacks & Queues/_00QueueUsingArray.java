public class _00QueueUsingArray{
	 private int data[];
	 private int front;
	 private int rear;
	 private int size;
	 public _00QueueUsingArray(){
	 	data = new int[10];
	 	front = -1;
	 	rear = -1;
	 	size = 0;
	 }	

	 public int size(){
	 	return size;
	 }

	 public boolean isEmpty(){
	 	return size == 0;
	 }

	 public void enqueue(int element){
	 	if(size == data.length){
	 		System.out.println("Queue Full!!!");
	 		return;
	 	}
	 	if(front == -1)
	 		front = 0;
	 	size++;
	 	rear = (rear + 1) % data.length;
	 	data[rear] = element;
	 }
	 
	 public int dequeue() throws QueueEmptyException{
	 	if(size == 0)
	 		throw new QueueEmptyException();
	 	int element = data[front];
	 	front = (front + 1) % data.length;
	 	size--;
	 	if(size == 0){
	 		front = -1;
	 		rear = -1;
	 	}
	 		
	 	return element;
	 }

	 public int front()throws  QueueEmptyException{
	 	if(size == 0)
	 		throw new QueueEmptyException();
	 	return data[front];
	 }
}
class QueueEmptyException extends Exception{
	
}
class QueueUse{
	public static void main(String args[]) throws QueueEmptyException{
		_00QueueUsingArray queue = new _00QueueUsingArray();
		System.out.println("Size of Queue"+queue.size());
		System.out.println("isEmpty "+queue.isEmpty());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println("isEmpty "+queue.isEmpty());
		System.out.println("Size Of Queue"+queue.size());
		System.out.println("Front of queue"+queue.front());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}