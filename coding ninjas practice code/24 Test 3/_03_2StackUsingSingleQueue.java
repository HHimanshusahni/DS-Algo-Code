//https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
import java.util.Queue;
import java.util.LinkedList;
public class _03_2StackUsingSingleQueue<T>{
	Queue<T>queue ;
	//Constructor
	public _03_2StackUsingSingleQueue(){
		queue = new LinkedList<T>();
	}
	//Time complexity : O(n)
	public void push(T data){
		queue.offer(data);
		for(int i = 1 ;i <= queue.size() - 1;i++){
			T temp = queue.poll();
			queue.offer(temp);
		}
	}
	//Time Complexity : O(1)
	public T pop(){
		return queue.poll();
	}
	public T top(){
		return queue.peek();
	}
	public int size(){
		return queue.size();
	}

}
class Test{
	public static void main(String[]args){
		_03_2StackUsingSingleQueue stack = new _03_2StackUsingSingleQueue();
		System.out.println("Pushing elements 3 ,2 ");
		System.out.println("Element at the top of the stack is "+stack.top());
		stack.push(3);
		stack.push(2);
		System.out.println("The size of the queue is "+stack.size());
		System.out.println("Popped element  "+stack.pop());
		System.out.println("Element at the top of the stack is "+stack.top());
		System.out.println("Popped eleement  "+stack.pop());
		System.out.println("The size of the queue is "+stack.size());
		System.out.println("Pushing elements 5  ");
		stack.push(5);
		System.out.println("Element at the top of the stack is "+stack.top());

	}
}