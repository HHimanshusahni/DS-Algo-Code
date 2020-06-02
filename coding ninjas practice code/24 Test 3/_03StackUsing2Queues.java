import java.util.*;
public class _03StackUsingQueue<T>{
	//Implement stack using 2 queues
	/*	https://www.geeksforgeeks.org/implement-stack-using-queue/
		There are two approaches for doing this problem
		Push Costly: 
		1. By making PUSH costly

		push(s, x) // x is the element to be pushed and s is stack
		  1) Enqueue x to q2
		  2) One by one dequeue everything from q1 and enqueue to q2.
		  3) Swap the names of q1 and q2 
		// Swapping of names is done to avoid one more movement of all elements 
		// from q2 to q1. 

		https://youtu.be/ww5Ac232WEU

		Pop Costly
		https://youtu.be/ww5Ac232WEU?t=377
	*/
	// Approach 1 Push O(n) , Pop O(1)
	
	//Data Members
	public Queue<T> q1,q2;

	public _03StackUsingQueue(){
		q1 = new LinkedList<T>();
		q2 = new LinkedList<T>();
	}
	//Time complexity O(n)
	public  void push(T data){
		//dequeue alls elements from q1 and enqueue it into q2
		while(!q1.isEmpty()){
			T temp = q1.poll();
			q2.offer(temp);
		} 
		//enqueu the new data value into the q1
		q1.offer(data);

		//dequeue all data elements from q1 and enqueue it in the q2
		while(!q2.isEmpty()){
			T temp = q2.poll();
			q1.offer(temp);
		}
	}
	//Time Complexity O(1)
	public T pop(){
		//underflow condition
		if(q1.isEmpty())
			return null;
		else
			return q1.poll(); //No need of above if statement as it  poll() function returns null when queue is empty

	}
	public T top(){
		return q1.peek();
	}
	public int getSize(){
		return q1.size();
	}

	
}
public class _03StackUsingQueue<T>{
	/*	https://www.geeksforgeeks.org/implement-stack-using-queue/
		There are two approaches for doing this problem
		Push Costly: 
		1. By making PUSH costly

		push(s, x) // x is the element to be pushed and s is stack
		  1) Enqueue x to q2
		  2) One by one dequeue everything from q1 and enqueue to q2.
		  3) Swap the names of q1 and q2 
		// Swapping of names is done to avoid one more movement of all elements 
		// from q2 to q1. 

		https://youtu.be/ww5Ac232WEU

		Pop Costly
		https://youtu.be/ww5Ac232WEU?t=377
	*/
	// Approach 1 Push O(n) , Pop O(1)
	
	//Data Members
	public Queue<T> q1,q2;

	public _03StackUsingQueue(){
		q1 = new LinkedList<T>();
		q2 = new LinkedList<T>();
	}
	//Time complexity O(n)
	public  void push(T data){
		//dequeue alls elements from q1 and enqueue it into q2
		while(!q1.isEmpty()){
			T temp = q1.poll();
			q2.offer(temp);
		} 
		//enqueu the new data value into the q1
		q1.offer(data);

		//dequeue all data elements from q1 and enqueue it in the q2
		while(!q2.isEmpty()){
			T temp = q2.poll();
			q1.offer(temp);
		}
	}
	//Time Complexity O(1)
	public T pop(){
		//underflow condition
		if(q1.isEmpty())
			return null;
		else
			return q1.poll(); //No need of above if statement as it  poll() function returns null when queue is empty

	}
	public T top(){
		return q1.peek();
	}
	public int getSize(){
		return q1.size();
	}

	
}

//Approach 2 
public class _03_2StackUsingQueue<T>{
	//Data Members
	public Queue<T> q1,q2;
	T rear;
	public StackUsingQueue(){
		q1 = new LinkedList<T>();
		q2 = new LinkedList<T>();
        rear = null;
	}
	//Time complexity O(1)
	public  void push(T data){
		q1.offer(data);
        rear = data;
	}
	//Time Complexity O(n)
	public T pop(){
		//underflow condition
		if(q1.isEmpty())
			return null;
		else{
			//Dequeue all elements of q1 except the last in item and insert them into q2
				while(q1.size() != 1){
					T data = q1.poll();
					q2.offer(data);
                    rear = data;
				}
			T ans = q1.poll();
            if(q2.isEmpty())
                rear = null;

                
			//Swap q1 and q2
			Queue<T> temp = q1;
			q1 = q2;
			q2 = temp;
          
            return ans;
		}

	}
	//time complexity O(1)but by using rear we can reduce it
	public T top(){


// 		while(!q1.isEmpty()){
// 			data = q1.poll();
// 			q2.offer(data);
// 		}
// 		if(!q2.isEmpty()){
// 			Queue<T>  temp = q1;
// 			q1 = q2;
// 			q2 = q1;

// 		}
		return rear;
	}
	public int getSize(){
		return q1.size();
	}
	public Queue<T> getQueue(){
		return q1;
	}

	
}

